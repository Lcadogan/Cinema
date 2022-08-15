package com.example.cinema;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SeatsController {

    private final SeatsList seats = new SeatsList(9, 9);

        @GetMapping("/seats")
        public SeatsList getSeatList () {
            return seats;
        }

        @PostMapping("/purchase")
        public Object postPurchase(@RequestBody SeatInfo seatInfo) {
            for(Token token: seats.availableSeats) {
                if (token.getTicket().getRow() == seatInfo.getRow() && token.getTicket().getColumn() == seatInfo.getColumn()) {
                   if (token.getTicket().isPurchase()) {
                       return new ResponseEntity<>(new ErrorResponse("The ticket has been already purchased!"), HttpStatus.BAD_REQUEST);
                   }else {
                       token.getTicket().setPurchase(true);
                       return token;
                   }
                }
            }
           return new ResponseEntity<>(new ErrorResponse("The number of a row or a column is out of bounds!"), HttpStatus.BAD_REQUEST);
        }

        @PostMapping("/return")
    public Object postReturn(@RequestBody TokenInfo tokenInfo) {
            for(Token token: seats.availableSeats) {
                if (token.getToken().equals(tokenInfo.getToken())) {
                    token.getTicket().setPurchase(false);
                    return new ReturnedTicket(token.getTicket()) ;
                }
            }
            return new ResponseEntity<>(new ErrorResponse("Wrong token!"), HttpStatus.BAD_REQUEST);
    }
}
