package com.example.myapplicationtest;

import android.content.Intent;
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
import android.util.Base64;
import com.stomped.stomped.client.StompedClient;
import com.stomped.stomped.component.StompedFrame;
import com.stomped.stomped.listener.StompedListener;
import ua.naiksoftware.stomp.client.StompClient;

public class MainActivity extends AppCompatActivity {
    public enum ConnectionProvider {
        OKHTTP, JWS
    }
    private StompClient mStompClient;

    private EditText username;
    private EditText password;
    public Button loginbutton;



    private void validate(String user, String pass){
        Log.d("MainActivity", "username : " + user + " password: " + pass);
        if (user.equals("admin") && pass.equals("password")  ) {
            Log.d("MainActivity", "The username and password are correct");
            Intent intent = new Intent(MainActivity.this, profile.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        username = (EditText) findViewById(R.id.eusername);
        password = (EditText) findViewById(R.id.password);
        loginbutton = (Button) findViewById(R.id.logbutt);
        super.onCreate(savedInstanceState);

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
        //btn = (Button) findViewById(R.id.thatButton);
        //subscribe();
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(username.getText().toString(), password.getText().toString());
                Log.d("MainActivity", "The Button has been clicked");
            }
        });



    }


}
