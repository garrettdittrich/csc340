package com.example.myapplicationtest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.stomped.stomped.client.StompedClient;
import com.stomped.stomped.component.StompedFrame;
import com.stomped.stomped.listener.StompedListener;

public class MainActivity extends AppCompatActivity {
    public final StompedClient client = new StompedClient.StompedClientBuilder().build("http://192.168.1.10:8080/livescore-websocket");

    public Button btn;
    public void subscribe(){




        client.subscribe("/topic/user", new StompedListener() {
            EditText editText = (EditText) findViewById(R.id.editText);
            TextView textView = (TextView) findViewById(R.id.textView);
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

    public void sendData(){
        EditText editText = (EditText) findViewById(R.id.editText);
        TextView textView = (TextView) findViewById(R.id.textView);
        client.send("/app/user", "{\"username\":\"" + editText.getText().toString() + "\" , "
                + "\"password\": \"abc123\", " +
                "\"gps\": 100 }");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // testing stomp client
        btn = (Button) findViewById(R.id.thatButton);
        subscribe();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
                Log.d("MainActivity", "The Button has been clicked");
            }
        });

    }


}
