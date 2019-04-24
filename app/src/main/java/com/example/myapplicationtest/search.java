package com.example.myapplicationtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        //subscribe();
        //sendData("ggggggggggggggggggggg");

        Button sendbutton = (Button) findViewById(R.id.button);
        sendbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(search.this, profile.class);
                startActivity(intent);
                Log.d("TT", "OKKKKKKAYYYY");
            }
        });

        Button buttonRequest = (Button) findViewById(R.id.button3);
        buttonRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(search.this, Requests.class);
                Log.d("TT", "HIT REEQUST BUTTON");
                startActivity(intent);
            }
        });
    }

}
