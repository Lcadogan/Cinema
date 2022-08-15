package com.example.cinema;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Seat {

    private final int row;
    private final int column;
    private final int price;
    private boolean isPurchase = false;

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

    @JsonIgnore
    public boolean isPurchase() {
        return isPurchase;
    }

    public void setPurchase(boolean purchase) {
        this.isPurchase = purchase;
    }
}