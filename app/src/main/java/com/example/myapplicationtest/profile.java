package com.example.myapplicationtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplicationtest.socket.StompedClientAddHeaders;
import com.stomped.stomped.client.StompedClient;
import com.stomped.stomped.component.StompedFrame;
import com.stomped.stomped.listener.StompedListener;

public class profile extends AppCompatActivity {
    public final StompedClientAddHeaders client = new StompedClientAddHeaders.StompedClientBuilder().build("http://142.93.63.201:8080/livescore-websocket");

    public void sendData(String input){
        EditText editText = (EditText) findViewById(R.id.editText);
        TextView textView = (TextView) findViewById(R.id.testdata);
        client.sendWithHeaders("/app/user", "{\"username\":\"" + "dingdong" + "\" , "
                + "\"password\": \"whosthere\", " +
                "\"gps\": 100 }");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //subscribe();
        //sendData("ggggggggggggggggggggg");

        Button sendbutton = (Button) findViewById(R.id.sendbutton);
        sendbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profile.this, proposal.class);
                startActivity(intent);
                Log.d("TT", "OKKKKKKAYYYY");
            }
        });

        Button buttonRequest = (Button) findViewById(R.id.button3);
        buttonRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profile.this, Requests.class);
                Log.d("TT", "HIT REEQUST BUTTON");
                startActivity(intent);
            }
        });
    }
}
