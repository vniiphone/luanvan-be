package com.luanvan.b1910025.controllers;

import com.luanvan.b1910025.models.Booking;
import com.luanvan.b1910025.models.HoaDon;
import com.luanvan.b1910025.payloads.requests.BookingRequest;
import com.luanvan.b1910025.payloads.responses.BookingResponse;
import com.luanvan.b1910025.payloads.responses.MsgResponse;
import com.luanvan.b1910025.repository.BookingRepo;
import com.luanvan.b1910025.repository.HanhKhachRepo;
import com.luanvan.b1910025.repository.TourRepo;
import com.luanvan.b1910025.repository.UserRepo;
import com.luanvan.b1910025.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:8088")
@RestController
@CrossOrigin(origins = "http://127.0.0.1:5173/", methods = {RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/Booking")
public class BookingController {

    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    BookingService bookingService;

    @Autowired
    UserRepo userRepo;

    @Autowired
    TourRepo tourRepo;
    @Autowired
    HanhKhachRepo hanhKhachRepo;


    /* get list of item in cart of user */
    @GetMapping("/getBooking/{id}")
    public ResponseEntity<List<Booking>> getBooking(@PathVariable("id") Long id) {
        try {
            List<Booking> bookingItems = bookingService.getBooking(id);
            return new ResponseEntity<>(bookingItems, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /* create cart item */
/*    @PostMapping(value = "/create")
    public ResponseEntity<?> creatBookingItem(@RequestBody BookingRequest bookingRequest) {
        try{

            Booking book = bookingService.createBooking(bookingRequest);
            return ResponseEntity.ok(book);
        }
        catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().body("Error creating tour: " + e.getMessage());
        }
//        return bookingService.createBooking(bookingRequest);
    }*/

    @PostMapping(value = "/create")
    public BookingResponse creatBookingItem(
            @RequestParam("user_id") Long user_id,
            @RequestParam("tour_id") Long tour_id,
            @RequestParam("soLuongVeDat") int quantity) {
        BookingRequest bookingRequest = new BookingRequest(user_id, tour_id, quantity);
        return bookingService.createBooking2(bookingRequest);
    }
    @PutMapping(value = "/{id}", consumes = {"*/*"})
    public ResponseEntity<Optional<Booking>> updateBookingItem(
            @PathVariable("id") Long id,
            @RequestParam("user_id") Long user_id,
            @RequestParam("tour_id") Long tour_id,
            @RequestParam("soLuongVeDat") int quantity
    ) {
        BookingRequest bookingRequest = new BookingRequest(user_id, tour_id, quantity);
        return new ResponseEntity<>(bookingService.updateBooking(id, bookingRequest), HttpStatus.OK);
    }

    /* delete cart item with id */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<MsgResponse> deleteCartItem(@PathVariable("id") Long id) {
        try {
            bookingService.deteleBooking(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/getBookingByItemId/{bookingId}")
    public ResponseEntity<Booking> getInvoiceByHoaDonId(@PathVariable("bookingId") long bookingId) {
        try {
            Booking booking = bookingService.getASingleBooking(bookingId);
            return new ResponseEntity<>(booking, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /* update cart item with id */



}
