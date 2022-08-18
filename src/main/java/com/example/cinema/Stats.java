package com.example.cinema;

public class Stats {

    private static final String superSecret = "123";
    private final int currentIncome;
    private final int numberOfAvailable_seats;
    private final int numberOfPurchasedTickets;

    public Stats(int currentIncome, int numberOfAvailable_seats, int numberOfPurhasedTickets) {
        this.currentIncome = currentIncome;
        this.numberOfAvailable_seats = numberOfAvailable_seats;
        this.numberOfPurchasedTickets = numberOfPurhasedTickets;
    }

    public static String getPassword() {
        return superSecret;
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
