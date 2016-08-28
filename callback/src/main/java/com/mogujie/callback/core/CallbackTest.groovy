package com.mogujie.callback.core

import com.mogujie.callback.FreeMarkerHelper

/**
 * @author zijiao
 * @version 16/8/26
 * Mark 
 */
class CallbackTest {

    static def main() {
        FreeMarkerHelper.init('/Users/jiao/Desktop/ideaWorkSpace/FreeMarkerDemo/template')
        FreeMarkerHelper.generate('Callback.ftl', getCallbackInfo())
    }

    static CallbackInfo getCallbackInfo() {
        CallbackInfo callbackInfo = new CallbackInfo()
        callbackInfo.packageName = 'com.mogujie.callback'
        callbackInfo.simpleClassName = 'SimpleCallback'
        callbackInfo.proxyClassName = 'CallbackProxy'
        callbackInfo.rootClass = 'com.mogujie.callback.core.Callback'
        callbackInfo.callbacks = [
                'com.mogujie.callback.core.CallbackHolder$Callback1',
                'com.mogujie.callback.core.CallbackHolder$Callback2',
                'com.mogujie.callback.core.CallbackHolder$Callback3',
                'com.mogujie.callback.core.CallbackHolder$Callback4'
        ]
        return callbackInfo
    }

}
