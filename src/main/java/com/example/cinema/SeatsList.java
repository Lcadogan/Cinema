package com.example.cinema;

import java.util.ArrayList;
import java.util.List;


public class SeatsList {

    private int totalRows;
    private int totalColums;
    List<Seat> availableSeats;

    public SeatsList(int totalRows, int totalColums) {
        this.totalRows = totalRows;
        this.totalColums = totalColums;
        this.availableSeats = new ArrayList<>();
        for (int i = 1; i < totalRows + 1; i++) {
            for (int j = 1; j < totalColums + 1; j++) {
                availableSeats.add(new Seat(i, j));
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

    public int getTotalColums() {
        return totalColums;
    }

    public void setTotalColums(int totalColims) {
        this.totalColums = totalColims;
    }
}
