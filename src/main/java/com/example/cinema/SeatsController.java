package com.example.cinema;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class SeatsController {

    private final SeatsList seats = new SeatsList(9, 9);

        @GetMapping("/seats")
        public SeatsList getSeatList () {
            return seats;
        }
}
