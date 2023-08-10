package com.luanvan.b1910025.payloads.responses;
import com.luanvan.b1910025.models.Booking;
import org.springframework.beans.factory.annotation.Autowired;
public class BookingResponse {

    @Autowired
    Booking booking;
    public Error error;
    public String message;

    public BookingResponse(Booking booking, Error error, String message) {
        super();
        this.booking = booking;
        this.error = error;
        this.message = message;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
