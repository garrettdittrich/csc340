package com.example.myapplicationtest.com.example.myapplicationtest.gps;

public class GpsUser {
    private GpsLat lattitude;
    private GpsLong longitude;

    public GpsLat getLattitude() {
        return lattitude;
    }

    public GpsLong getLongitude() {
        return longitude;
    }

    public static double distance(double lat1, double lat2, double lon1,
                                  double lon2, double el1, double el2) {

        final int R = 6371;

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000;

        double height = el1 - el2;

        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return Math.sqrt(distance);
    }

    public double getDifference(GpsUser user) {
        return distance(lattitude.getLatitude(), user.getLattitude().getLatitude(), longitude.getLongitude(),
                user.getLongitude().getLongitude(), 0.0, 0.0);
    }
}
