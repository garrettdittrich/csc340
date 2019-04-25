package com.example.myapplicationtest;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplicationtest.com.example.myapplicationtest.service.LoginService;
import com.example.myapplicationtest.com.example.myapplicationtest.service.Profile;
import com.example.myapplicationtest.com.example.myapplicationtest.service.SuccessObject;
import com.example.myapplicationtest.socket.StompedClientAddHeaders;
import com.stomped.stomped.client.StompedClient;
import com.stomped.stomped.component.StompedFrame;
import com.stomped.stomped.listener.StompedListener;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class profile extends AppCompatActivity {
    public final StompedClientAddHeaders client = new StompedClientAddHeaders.StompedClientBuilder().build("http://192.168.1.10:8080/livescore-websocket");
   // public final StompedClientAddHeaders client = new StompedClientAddHeaders.StompedClientBuilder().build("http://142.93.63.201:8080/livescore-websocket");

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


        Button buttonRequest = (Button) findViewById(R.id.button3);
        buttonRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profile.this, Requests.class);
                Log.d("TT", "HIT REEQUST BUTTON");
                startActivity(intent);
            }
        });

        Button buttonSearch = (Button) findViewById(R.id.button2);
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profile.this, search.class);
                Log.d("TT", "yeeeet");
                startActivity(intent);
            }
        });
    }

    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {
        private final String username;
        private final String password;

        UserLoginTask(String username, String password){
            this.username = username;
            this.password = password;
        }
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
        }
        @Override
        protected void onPostExecute(final Boolean success){

        }
        @Override
        protected Boolean doInBackground(Void... voids) {
            Retrofit.Builder builder = new Retrofit.Builder().baseUrl("http://142.93.63.201:8080/").
                    addConverterFactory(GsonConverterFactory.create());

            Retrofit retrofit = builder.build();
            LoginService loginClient = retrofit.create(LoginService.class);
            String auth = "Basic " + Base64.encodeToString((username + ":" + password).getBytes(), Base64.NO_WRAP);
            Call<SuccessObject> call = loginClient.getLoginString(auth);
            try {
                Response<SuccessObject> resp = call.execute();
                if (resp.isSuccessful()) {
                    FitBetApplicationClass app = (FitBetApplicationClass) getApplication();
                    Profile currentProfile = new Profile();
                    currentProfile.setId(Long.getLong(resp.body().getSuccess()));
                    app.setCurrentProfile(currentProfile);
                    return true;
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
            return false;
        }
    }
}
