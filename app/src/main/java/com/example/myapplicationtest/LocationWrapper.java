package com.example.myapplicationtest;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class LocationWrapper implements  Parcelable, LocationListener  {

    public Parcelable getParce(){
        Parcelable some = this;
        return some;
    }
    public LocationWrapper(){

    }
    protected LocationWrapper(Parcel in) {

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<LocationWrapper> CREATOR = new Creator<LocationWrapper>() {
        @Override
        public LocationWrapper createFromParcel(Parcel in) {
            return new LocationWrapper(in);
        }

        @Override
        public LocationWrapper[] newArray(int size) {
            return new LocationWrapper[size];
        }
    };

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
