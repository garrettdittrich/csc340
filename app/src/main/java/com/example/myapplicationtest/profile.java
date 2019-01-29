package com.example.myapplicationtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.stomped.stomped.client.StompedClient;
import com.stomped.stomped.component.StompedFrame;
import com.stomped.stomped.listener.StompedListener;

public class profile extends AppCompatActivity {
    public final StompedClient client = new StompedClient.StompedClientBuilder().build("http://192.168.1.10:8080/livescore-websocket");
    public void subscribe(){

        client.subscribe("/topic/user", new StompedListener() {
            EditText editText = (EditText) findViewById(R.id.editText);
            TextView textView = (TextView) findViewById(R.id.testdata);
            @Override
            public void onNotify(final StompedFrame frame) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(frame.getStompedBody());
                        Log.d("MainActivity", "subscribed");
                    }
                });
            }
        });


    }
    public void sendData(String input){
        EditText editText = (EditText) findViewById(R.id.editText);
        TextView textView = (TextView) findViewById(R.id.testdata);
        client.send("/app/user", "{\"username\":\"" + input + "\" , "
                + "\"password\": \"abc123\", " +
                "\"gps\": 100 }");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        subscribe();
        sendData("ggggggggggggggggggggg");

        Button sendbutton = (Button) findViewById(R.id.sendbutton);
        sendbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
