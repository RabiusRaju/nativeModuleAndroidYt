package com.nativemoduleandroidyt.newarchitecture.components;

import android.util.Log;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.modules.core.DeviceEventManagerModule;


public class CalendarModule extends ReactContextBaseJavaModule {
    private int eventCount = 0;
    public CalendarModule(ReactApplicationContext context) {
        super(context);
    }

    @NonNull
    @Override
    public String getName() {
        return "CalendarModule";
    }

    @ReactMethod
    public void createCalendarEvent(Callback callback) {
        Log.d("Calendar Module","Logged from our Calendar module");
        callback.invoke("Data returned from native calendar module");
    }
    @ReactMethod
    public void createCalendarEvent(Promise promise) {
        try {
            promise.resolve("Call");
            //eventCount += 1;
            //sendEvent(getReactApplicationContext(),"EventCount",eventCount);
        } catch(Exception e) {
            promise.reject("Create Event Error", e);
        }
    }

    private void sendEvent(ReactContext reactContext,
                           String eventName,
                           int params) {
        reactContext
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(eventName, params);
    }


}