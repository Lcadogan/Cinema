package com.example.cinema;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
public class SeatsController {

    private final SeatsList seats = new SeatsList(9, 9);

        @GetMapping("/seats")
        public SeatsList getSeatList () {
            return seats;
        }

        @PostMapping("/purchase")
        public Object postPurchase(@RequestBody SeatInfo seatInfo) {
            for(Seat seat: seats.availableSeats) {
                if (seat.getRow() == seatInfo.getRow() && seat.getColumn() == seatInfo.getColumn()) {
                   if (seat.isPurchase()) {
                       return new ResponseEntity<>(new ErrorResponse("The ticket has been already purchased!"), HttpStatus.BAD_REQUEST);
                   }else {
                       seat.setPurchase(true);
                       return seat;
                   }
                }
            }
           return new ResponseEntity<>(new ErrorResponse("The number of a row or a column is out of bounds!"), HttpStatus.BAD_REQUEST);
        }
}
