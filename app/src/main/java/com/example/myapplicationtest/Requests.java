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

public class Requests extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requests);
        //subscribe();
        //sendData("ggggggggggggggggggggg");

        Button sendbutton = (Button) findViewById(R.id.button);
        sendbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Requests.this, profile.class);
                startActivity(intent);
                Log.d("TT", "OKKKKKKAYYYY");
            }
        });


        Button buttonSearch = (Button) findViewById(R.id.button2);
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Requests.this, search.class);
                Log.d("TT", "yeeeet");
                startActivity(intent);
            }
        });


        Button buttonProposal = (Button) findViewById(R.id.button8);
        buttonProposal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Requests.this, proposal.class);
                Log.d("didyou", "readmydiagram?");
                startActivity(intent);
            }
        });
    }

}
