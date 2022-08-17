package com.example.cinema;

import java.util.*;


public class SeatsList {

    private int totalRows;
    private int totalColumns;
    List<Ticket> availableSeats = new ArrayList<>();


    public SeatsList(int totalRows, int totalColumns) {
        this.totalRows = totalRows;
        this.totalColumns = totalColumns;
        createSeatsListAndPrice(totalRows, totalColumns);
    }

    private void createSeatsListAndPrice(int totalRows, int totalColumns) {

        for (int i = 1; i < totalRows + 1; i++) {
            for (int j = 1; j < totalColumns + 1; j++) {
                if (i <= 4) {
                    availableSeats.add(new Ticket(i, j, 10 ));
                } else {
                    availableSeats.add(new Ticket(i, j, 8));
                }
            }
        }
    }

    public List<Ticket> getAvailableSeats() {
        return availableSeats;
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
