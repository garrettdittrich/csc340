package com.example.myapplicationtest;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplicationtest.socket.StompedClientAddHeaders;

import java.text.DateFormat;
import java.util.Calendar;

public class proposal extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    public final StompedClientAddHeaders client = new StompedClientAddHeaders.StompedClientBuilder().build("http://192.168.1.10:8080/livescore-websocket");
    protected FitBetApplicationClass app;
    public Contract contract = new Contract();
    public Calendar cal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proposal);
        Intent intent = new Intent(proposal.this, ContractIntentService.class);
        app = (FitBetApplicationClass) getApplication();
        Button button = (Button) findViewById(R.id.datepick);
        EditText username = (EditText) findViewById(R.id.username);
        EditText location = (EditText) findViewById(R.id.location);
        EditText time = (EditText) findViewById(R.id.time);
        EditText amount = (EditText) findViewById(R.id.amount);
        Button submitButton = (Button) findViewById(R.id.submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CALLLL", String.valueOf(cal.get(Calendar.YEAR)));
                contract.setScheduleDate(cal);
                contract.setProposer(username.getText().toString());
                contract.setGym(location.getText().toString());
                contract.setScheduleTime(time.getText().toString());
                contract.setPaymentAmount(Double.valueOf(amount.getText().toString()));
                contract.setActiveStatus(false);
                app.getContractList().put("1", contract);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(cal.getTime());
        TextView textView = (TextView) findViewById(R.id.datechosen);
        textView.setText(currentDateString);
    }

}
