package com.example.satan.nfcattendance;

import android.util.Log;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyFireBaseInstanceIDService extends BroadcastReceiver  {
    private static final String TAG = "MyFirebaseIIDService";
/*
    //get cloud message notification from firebase
    @Override
    public void onTokenRefresh() {
//Getting registration token
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
//Displaying token on logcat
        Log.d(TAG, refreshedToken);
    }
}
*/
public void onReceive(Context context, Intent intent) {
    Log.d(TAG, "I'm in!!!");

    if (intent.getExtras() != null) {
        for (String key : intent.getExtras().keySet()) {
            Object value = intent.getExtras().get(key);
            Log.e("FirebaseDataReceiver", "Key: " + key + " Value: " + value);
        }
    }
}
}


