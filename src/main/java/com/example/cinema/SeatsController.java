package com.example.cinema;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SeatsController {

    private int currentIncome = 0;
    private final SeatsList seats = new SeatsList(9, 9);
    private final List <Token> soldTicket = new ArrayList<>();

    @GetMapping("/seats")
        public SeatsList getSeatList () {
            return seats;
        }

    @PostMapping("/purchase")
    public Object postPurchase(@RequestBody SeatInfo seatInfo) {
        for(Ticket ticket: seats.availableSeats) {
            if (ticket.getRow() == seatInfo.getRow() && ticket.getColumn() == seatInfo.getColumn()) {
               if (ticket.isPurchase()) {
                   return new ResponseEntity<>(new ErrorResponse("The ticket has been already purchased!"), HttpStatus.BAD_REQUEST);
               }else {
                   Token token = new Token(ticket);
                   currentIncome += ticket.getPrice();
                   soldTicket.add(token);
                   return token;
               }
            }
        }
       return new ResponseEntity<>(new ErrorResponse("The number of a row or a column is out of bounds!"), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/return")
    public Object postReturn(@RequestBody TokenInfo tokenInfo) {
        for(Token token: soldTicket) {
            if (token.getToken().equals(tokenInfo.getToken())) {
                token.getTicket().setPurchase(false);
                currentIncome -= token.getTicket().getPrice();
                soldTicket.remove(token);
                return new ReturnedTicket(token.getTicket()) ;
            }
        }
        return new ResponseEntity<>(new ErrorResponse("Wrong token!"), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/stats")
    public Object postStats(@RequestParam (value = "password", required = false) String password) {
        if (password.equals(Stats.getPassword())) {
            return new Stats( currentIncome, seats.availableSeats.size(), soldTicket.size());
        }
        return new ResponseEntity<>(new ErrorResponse("The password is wrong!"), HttpStatus.UNAUTHORIZED);
    }
}
