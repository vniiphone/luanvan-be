package com.luanvan.b1910025.services;

import com.luanvan.b1910025.models.Booking;
import com.luanvan.b1910025.payloads.requests.BookingRequest;
import com.luanvan.b1910025.payloads.responses.BookingResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface BookingService {
    Booking createBooking(BookingRequest bookingRequest);

    BookingResponse createBooking2(BookingRequest bookingRequest);


    Optional<Booking> updateBooking(long bookingId, BookingRequest bookingRequest);

    void deteleBooking(long bookingId);

    List<Booking> getBooking(long userId);



    Booking getASingleBooking(Long bookingId);
}
