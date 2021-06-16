package com.taxi_booking;

import java.util.*;

public class Taxi {
    private int taxiNo;
    private int totalEarnings;
    private char currentPoint;
    private int avalabilityTime;
    private List<Booking> bookings = new ArrayList<Booking>();

    public Taxi(int id) {
        this.taxiNo = id;
        this.currentPoint = 'A';
        this.totalEarnings = 0;
        this.avalabilityTime = 0;
    }

    public int getTaxiNo() {
        return this.taxiNo;
    }

    public char getCurrrentPoint() {
        return this.currentPoint;
    }

    public int getEarnings() {
        return this.totalEarnings;
    }

    public int getAvailabilityTime() {
        return this.avalabilityTime;
    }

    public List<Booking> getBookings() {
        return this.bookings;
    }

    public void setCurrentPoint(char point) {
        this.currentPoint = point;
    }

    public void addEarnings(int amount) {
        this.totalEarnings += amount;
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public void setAvailabilityTime(int pickupTime, char pickUpPoint, char dropPoint) {
        this.avalabilityTime = pickupTime + Math.abs(pickUpPoint - dropPoint);
    }

}
