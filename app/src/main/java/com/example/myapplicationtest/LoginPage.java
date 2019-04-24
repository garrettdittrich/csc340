package com.example.myapplicationtest;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
<<<<<<< HEAD:app/src/main/java/com/example/myapplicationtest/LoginPage.java

import ua.naiksoftware.stomp.client.StompClient;

public class LoginPage extends AppCompatActivity {
=======
import android.widget.TextView;
import android.util.Base64;
import android.widget.Toast;

import com.example.myapplicationtest.com.example.myapplicationtest.service.ApiAuthenticationClient;
import com.example.myapplicationtest.com.example.myapplicationtest.service.LoginService;
import com.example.myapplicationtest.com.example.myapplicationtest.service.SuccessObject;
import com.example.myapplicationtest.socket.StompedClientAddHeaders;
import com.stomped.stomped.client.StompedClient;
import com.stomped.stomped.component.StompedFrame;
import com.stomped.stomped.listener.StompedListener;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ua.naiksoftware.stomp.client.StompClient;

public class MainActivity extends AppCompatActivity {
    private LocationManager locationManager;
    private LocationWrapper locationListener;
    private Intent gpsService;

    private void initializeGps() {
        gpsService = new Intent(this, GpsService.class);
        startService(gpsService);
    }
>>>>>>> master:app/src/main/java/com/example/myapplicationtest/MainActivity.java
    public enum ConnectionProvider {
        OKHTTP, JWS
    }
    private StompClient mStompClient;
    private String baseUrl;
    private EditText username;
    private EditText password;
    public Button loginbutton;
    public LoginService loginClient;


    private void validate(String user, String pass){
        Log.d("LoginPage", "username : " + user + " password: " + pass);
        if (user.equals("admin") && pass.equals("password")  ) {
            Log.d("LoginPage", "The username and password are correct");
            Intent intent = new Intent(LoginPage.this, profile.class);
            startActivity(intent);
        }
    }
    private void goToProfileScreen(){
        Log.d("MainActivity", "The username and password are correct");
        Intent intent = new Intent(MainActivity.this, profile.class);
        startActivity(intent);
    }
    public void goToRequestScreen(){
        Log.d("MainActivity", "Going to Request Screen");
        Intent intent = new Intent(MainActivity.this, Requests.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        //baseUrl = "http://192.168.1.10:8080/rest/login";

        initializeGps();


        username = (EditText) findViewById(R.id.eusername);
        password = (EditText) findViewById(R.id.password);
        loginbutton = (Button) findViewById(R.id.loginButt);
        super.onCreate(savedInstanceState);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // testing stomp client
        //btn = (Button) findViewById(R.id.thatButton);
        //subscribe();
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
<<<<<<< HEAD:app/src/main/java/com/example/myapplicationtest/LoginPage.java
                validate(username.getText().toString(), password.getText().toString());
                Log.d("LoginPage", "The Button has been clicked");
=======
                AsyncTask<Void, Void, Boolean> execute = new UserLoginTask(username.getText().toString(),
                        password.getText().toString());
                execute.execute();
                Intent intent = new Intent(MainActivity.this, ContractIntentService.class);
                //intent.put
                startService(intent);


                Log.d("MainActivity", "The Button has been clicked");
>>>>>>> master:app/src/main/java/com/example/myapplicationtest/MainActivity.java
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
                    Log.d("MainActivity",  "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" +resp.body().getSuccess());
                    goToProfileScreen();
                    //Toast.makeText(getApplicationContext(), "Login succedded", Toast.LENGTH_LONG).show();
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
