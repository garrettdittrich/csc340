package com.example.myapplicationtest;

import android.content.Intent;

import com.example.myapplicationtest.com.example.myapplicationtest.gps.GpsLat;
import com.example.myapplicationtest.com.example.myapplicationtest.gps.GpsLong;
import com.example.myapplicationtest.com.example.myapplicationtest.gps.GpsUser;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GpsUnitTest {


    @Test
    public void testGpsDistanceCalculator(){
        // We create 2 new users and run get difference method and compare against expected
        // Note we must supply a delta value when comparing two floats
        GpsUser user = new GpsUser(36.064814, -79.8044);
        GpsUser user2 = new GpsUser(36.0734, -79.8104);
        assertEquals(user.getDifference(user2), 1096.499196572194, .0001);
    }

    @Test
    public void testInnerGpsClass() {
        GpsLat lat = new GpsLat(36.064814);
        GpsLong longi = new GpsLong(-79.8044);
        GpsUser user = new GpsUser(lat, longi);
    }
}
