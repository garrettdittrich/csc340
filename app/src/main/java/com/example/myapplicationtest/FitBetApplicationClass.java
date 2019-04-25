package com.example.myapplicationtest;

import android.app.Application;
import android.provider.ContactsContract;

import com.example.myapplicationtest.com.example.myapplicationtest.service.Profile;

import java.util.HashMap;

public class FitBetApplicationClass extends Application {
    public HashMap<String, Contract> contractList = new HashMap<String, Contract>();
    public Profile currentProfile;
    public HashMap<String, Contract> getContractList() {
        return contractList;
    }

    public void setCurrentProfile(Profile currentProfile) {
        this.currentProfile = currentProfile;
    }

    public Profile getCurrentProfile() {
        return currentProfile;
    }

    public void setContractList(HashMap<String, Contract> contractList) {
        this.contractList = contractList;
    }
}
