package com.example.cinema;

public class Stats {

    private static final String password = "super_secret";
    private final int currentIncome;
    private final int numberOfAvailable_seats;
    private final int numberOfPurchasedTickets;

    public Stats(int currentIncome, int numberOfAvailable_seats, int numberOfPurhasedTickets) {
        this.currentIncome = currentIncome;
        this.numberOfAvailable_seats = numberOfAvailable_seats - numberOfPurhasedTickets;
        this.numberOfPurchasedTickets = numberOfPurhasedTickets;
    }

    public static String getPassword() {
        return password;
    }

    public int getCurrentIncome() {
        return currentIncome;
    }

    public int getNumberOfAvailable_seats() {
        return numberOfAvailable_seats;
    }

    public int getNumberOfPurhasedTickets() {
        return numberOfPurchasedTickets;
    }

}
