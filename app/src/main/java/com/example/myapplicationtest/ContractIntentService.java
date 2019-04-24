package com.example.myapplicationtest;

import android.app.IntentService;
import android.content.Intent;
import android.location.LocationListener;
import android.location.LocationManager;
import android.util.Log;

import com.example.myapplicationtest.socket.StompedClientAddHeaders;
import com.stomped.stomped.component.StompedFrame;
import com.stomped.stomped.listener.StompedListener;

public class ContractIntentService extends IntentService {
<<<<<<< HEAD
    public final StompedClientAddHeaders client = new StompedClientAddHeaders.StompedClientBuilder().build("http://192.168.1.10:8080/livescore-websocket");

=======
    public final StompedClientAddHeaders client = new StompedClientAddHeaders.StompedClientBuilder().build("http://142.93.63.201:8080/livescore-websocket");
    public int counter;
>>>>>>> 96569b412c5bf3244c77c0da6c96388e0eb9c069
    private static final String TAG = "com.example.myapplicationtest";
    public ContractIntentService(){
        super("ContractIntentService");
    }
    private void goToProfileScreen(){
        Log.d("ContractIntentService", "The username and password are correct");
        Intent intent = new Intent(ContractIntentService.this, profile.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
    public void goToRequestScreen(){
        Log.d("ContractIntentService", "Going to Request Screen");
        Intent intent = new Intent(ContractIntentService.this, proposal.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
    public void subscribe(){

        client.subscribe("/topic/user", new StompedListener() {
            @Override
            public void onNotify(final StompedFrame frame) {
                Log.d("ContractIntentService", "RECEIVED NOTIFY INSIDE INTENT SERVICE");
                goToRequestScreen();
            }
        });

    }

    @Override
    protected void onHandleIntent(Intent intent){
        subscribe();
    }
}
