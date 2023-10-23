package com.luanvan.b1910025.payloads.responses;

import com.luanvan.b1910025.models.LoaiTour;
import com.luanvan.b1910025.models.Tour;
import org.springframework.beans.factory.annotation.Autowired;

public class TourResponse {
    @Autowired
    Tour tour;
    public Error error;
    public String message;

    public  TourResponse(){
        super();
    }
    public TourResponse(Tour tour, Error error, String message) {
        super();
        this.tour = tour;
        this.error = error;
        this.message = message;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
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
