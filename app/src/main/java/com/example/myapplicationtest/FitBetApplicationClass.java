package com.example.myapplicationtest;

import android.app.Application;

import java.util.HashMap;

public class FitBetApplicationClass extends Application {
    public HashMap<String, Contract> contractList = new HashMap<String, Contract>();

    public HashMap<String, Contract> getContractList() {
        return contractList;
    }

    public void setContractList(HashMap<String, Contract> contractList) {
        this.contractList = contractList;
    }
}
