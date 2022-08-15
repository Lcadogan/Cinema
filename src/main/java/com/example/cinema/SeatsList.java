package com.example.cinema;

import java.util.ArrayList;
import java.util.List;


public class SeatsList {

    private int totalRows;
    private int totalColumns;
    private final int ticketPriceUpTo4rows = 10;
    private final int ticketPriceOther = 8;
    List<Seat> availableSeats = new ArrayList<>();

    public SeatsList(int totalRows, int totalColumns) {
        this.totalRows = totalRows;
        this.totalColumns = totalColumns;
        createSeatsListAndPrice(totalRows, totalColumns);
    }

    private void createSeatsListAndPrice(int totalRows, int totalColumns) {

        for (int i = 1; i < totalRows + 1; i++) {
            for (int j = 1; j < totalColumns + 1; j++) {
                if (i <= 4) {
                    availableSeats.add(new Seat(i, j, ticketPriceUpTo4rows));
                } else {
                    availableSeats.add(new Seat(i, j, ticketPriceOther));
                }
            }
        }
    }

    public List<Seat> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(List<Seat> availableSeats) {
        this.availableSeats = availableSeats;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public void setTotalColumns(int totalColimns) {
        this.totalColumns = totalColimns;
    }
}
