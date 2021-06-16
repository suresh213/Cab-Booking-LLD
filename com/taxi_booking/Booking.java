package com.taxi_booking;

import java.util.*;

public class Booking {
    private int customerId;
    private char pickUpPoint;
    private char dropPoint;
    private int pickUpTime;
    private int dropTime;
    private int billAmount;

    public Booking(int customerId, char pickUpPoint, char dropPoint, int pickUpTime) {
        this.customerId = customerId;
        this.pickUpPoint = pickUpPoint;
        this.dropPoint = dropPoint;
        this.pickUpTime = pickUpTime;
    }

    public Taxi allotTaxi(List<Taxi> taxies) {
        int min = 6;
        Taxi allotedTaxi = null;
        for (Taxi taxi : taxies) {
            int x = Math.abs(taxi.getCurrrentPoint() - pickUpPoint);

            if (taxi.getAvailabilityTime() < pickUpTime && x <= min) {
                if (x < min) {
                    allotedTaxi = taxi;
                }
                if (x == min && taxi.getEarnings() > 0) {
                    if (allotedTaxi != null && (taxi.getEarnings() < allotedTaxi.getEarnings())) {
                        allotedTaxi = taxi;
                    }
                }
                min = x;
            }
        }
        if (allotedTaxi != null) {
            setValues(allotedTaxi);
        }
        return allotedTaxi;
    }

    public void setValues(Taxi allotedTaxi) {
        allotedTaxi.setAvailabilityTime(pickUpTime, pickUpPoint, dropPoint);
        this.billAmount = calculateBill();
        allotedTaxi.addEarnings(billAmount);
        this.dropTime = calculateDropTime();
    }

    public int calculateBill() {
        int distance = Math.abs(pickUpTime - dropPoint) * 15;
        return ((distance - 5) * 10) + 100;
    }

    public int calculateDropTime() {
        return pickUpTime + Math.abs(pickUpPoint - dropPoint);
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public int getBillAmount() {
        return this.billAmount;
    }

    public char getPickUpPoint() {
        return this.pickUpPoint;
    }

    public char getDropPoint() {
        return this.dropPoint;
    }

    public int getPickUpTime() {
        return this.pickUpTime;
    }

    public int getDropTime() {
        return this.dropTime;
    }
}
