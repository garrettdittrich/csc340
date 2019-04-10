package com.example.myapplicationtest;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.example.myapplicationtest.socket.StompedClientAddHeaders;
import com.stomped.stomped.component.StompedFrame;
import com.stomped.stomped.listener.StompedListener;

public class ContractIntentService extends IntentService {
    public final StompedClientAddHeaders client = new StompedClientAddHeaders.StompedClientBuilder().build("http://192.168.43.117:8080/livescore-websocket");
    public int counter;
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
                counter++;
                Log.d("ContractIntentService", "RECEIVED NOTIFY INSIDE INTENT SERVICE");
                goToRequestScreen();
            }
        });


    }
    public int getCounter(){
        return this.counter;
    }
    @Override
    protected void onHandleIntent(Intent intent){
        subscribe();
    }
}
