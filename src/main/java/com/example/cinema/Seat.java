package com.example.cinema;

public class Seat {

    private final int row;
    private final int column;
    private final int price;
    private boolean purchase = false;

    public Seat(int row, int column, int price) {
        this.row = row;
        this.column = column;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean isPurchase() {
        return purchase;
    }

    public void buyingTicket() {this.purchase = true;}
}