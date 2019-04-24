package com.example.myapplicationtest.com.example.myapplicationtest.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface LoginService {
    @GET("/rest/login")
    Call<SuccessObject> getLoginString(@Header("Authorization") String authHeader);
}
