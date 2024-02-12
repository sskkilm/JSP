package org.example.mission1;

public class CalculateDist {
    public static double calculateDist(double lat1, double lng1, double lat2, double lng2) {
        double theta = Math.toRadians(lng1 - lng2);
        double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(theta);
        dist = Math.acos(dist);
        dist = Math.toDegrees(dist);
        dist = dist * 60 * 1.1515 * 1.609344; // Convert to kilometers
        return dist;
    }
}
