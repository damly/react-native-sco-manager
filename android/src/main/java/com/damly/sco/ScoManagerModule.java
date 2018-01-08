package com.damly.sco;

import android.media.AudioManager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by damly on 2018/1/5.
 */

public class ScoManagerModule extends ReactContextBaseJavaModule {

    private static AudioManager mAudioManager;

    public ScoManagerModule(ReactApplicationContext reactContext) {
        super(reactContext);

        mAudioManager = (AudioManager) reactContext.getSystemService(reactContext.AUDIO_SERVICE);
    }

    @Override
    public String getName() {
        return "ScoManagerModule";
    }

    @ReactMethod
    public void startWithMode(int mode) {
        mAudioManager.setMode(mode);
        mAudioManager.setBluetoothScoOn(true);
        mAudioManager.startBluetoothSco();
    }

    @ReactMethod
    public void start() {
        mAudioManager.setBluetoothScoOn(true);
        mAudioManager.startBluetoothSco();
    }

    @ReactMethod
    public void stop() {
        if (mAudioManager.isBluetoothScoOn()) {
            mAudioManager.stopBluetoothSco();
            mAudioManager.setBluetoothScoOn(false);
        }
    }

    @Override
    public Map<String, Object> getConstants() {

        final Map<String, Object> constants = new HashMap<>();
        constants.put("MODE_CURRENT", AudioManager.MODE_CURRENT);
        constants.put("MODE_INVALID", AudioManager.MODE_INVALID);
        constants.put("MODE_IN_CALL", AudioManager.MODE_IN_CALL);
        constants.put("MODE_IN_COMMUNICATION", AudioManager.MODE_IN_COMMUNICATION);
        constants.put("MODE_NORMAL", AudioManager.MODE_NORMAL);
        constants.put("MODE_RINGTONE", AudioManager.MODE_RINGTONE);
        constants.put("STREAM_VOICE_CALL", AudioManager.STREAM_VOICE_CALL);
        return constants;
    }
}
