package com.taxi_booking;

import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static List<Taxi> taxies = new ArrayList<Taxi>();

    public static void main(String args[]) {

        int noOfTaxies = 4;

        for (int i = 0; i < noOfTaxies; i++) {
            taxies.add(new Taxi(i + 1));
        }

        boolean exit = false;
        while (!exit) {
            System.out.println(("          Taxi Booking        "));
            System.out.println(("1.Book Taxi"));
            System.out.println(("2.Display Details"));
            System.out.println(("3.Exit"));
            System.out.print(("Enter your choice:  "));
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    bookTaxi();
                    break;
                case 2:
                    getDetails();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.print(("Please enter correct choice :)"));
            }

        }
    }

    public static void bookTaxi() {
        System.out.print(("Customer ID: "));
        int customerId = sc.nextInt();
        System.out.print(("Pickup Point: "));
        char pickupPoint = sc.next().charAt(0);
        System.out.print(("Drop Point: "));
        char dropPoint = sc.next().charAt(0);
        System.out.print(("Pickup Time: "));
        int pickupTime = sc.nextInt();
        Booking booking = new Booking(customerId, pickupPoint, dropPoint, pickupTime);
        Taxi allotedTaxi = booking.allotTaxi(taxies);

        if (allotedTaxi != null) {
            allotedTaxi.addBooking(booking);
            System.out.println("Taxi " + allotedTaxi.getTaxiNo() + " is alloted");
        } else {
            System.out.println("No taxies available");
        }
    }

    public static void getDetails() {
        if (taxies.size() == 0) {
            System.out.println("No bookings found");
            return;
        }
        System.out.println("All Booking Details");
        for (Taxi taxi : taxies) {
            System.out.println("Taxi - " + taxi.getTaxiNo());
            System.out.println("Total Amount Earned: Rs." + taxi.getEarnings());
            List<Booking> bookings = taxi.getBookings();
            System.out.println("Total Bookings --> " + bookings.size());
            for (Booking booking : bookings) {
                System.out.println("Customer ID  : " + booking.getCustomerId());
                System.out.println("Pickup Point : " + booking.getPickUpPoint());
                System.out.println("Drop Point   : " + booking.getDropPoint());
                System.out.println("Pickup Time  : " + booking.getPickUpTime() + "hrs");
                System.out.println("Drop Time    : " + booking.getDropTime() + "hrs");
                System.out.println("Bill Amount  : " + booking.getBillAmount());
                System.out.println("              ******             ");
            }
            System.out.println("---------------------");
        }
    }
}