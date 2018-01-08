import { Platform, NativeModules } from 'react-native';

var ScoManagerModule = null;

if(Platform.OS === 'android') {
    ScoManagerModule = NativeModules.ScoManagerModule
}

class ScoManager {

    start(mode = null) {
        if(!ScoManagerModule) {
            return;
        }

        if(mode === 'MODE_CURRENT') {
            ScoManagerModule.startWithMode(ScoManagerModule.MODE_CURRENT);
        }
        else if(mode === 'MODE_INVALID') {
            ScoManagerModule.startWithMode(ScoManagerModule.MODE_INVALID);
        }
        else if(mode === 'MODE_IN_CALL') {
            ScoManagerModule.startWithMode(ScoManagerModule.MODE_IN_CALL);
        }
        else if(mode === 'MODE_IN_COMMUNICATION') {
            ScoManagerModule.startWithMode(ScoManagerModule.MODE_IN_COMMUNICATION);
        }
        else if(mode === 'MODE_NORMAL') {
            ScoManagerModule.startWithMode(ScoManagerModule.MODE_NORMAL);
        }
        else if(mode === 'MODE_RINGTONE') {
            ScoManagerModule.startWithMode(ScoManagerModule.MODE_RINGTONE);
        }
        else if(mode === 'STREAM_VOICE_CALL') {
            ScoManagerModule.startWithMode(ScoManagerModule.STREAM_VOICE_CALL);
        }
        else {
            ScoManagerModule.start()
        }
    }

    stop() {
        if(!ScoManagerModule) {
            return;
        }
        ScoManagerModule.stop();
    }
}

module.exports = new ScoManager();