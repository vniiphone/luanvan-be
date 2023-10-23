package com.luanvan.b1910025.payloads.responses;

import com.luanvan.b1910025.models.LichTrinhTour;
import com.luanvan.b1910025.models.Tour;
import org.springframework.beans.factory.annotation.Autowired;

public class LichTrinhTourResponse {
    @Autowired
    LichTrinhTour lichTrinhTour;
    public Error error;
    public String message;
    public LichTrinhTourResponse(){
    super();
}
    public LichTrinhTourResponse(LichTrinhTour lichTrinhTour, Error error, String message) {
        this.lichTrinhTour = lichTrinhTour;
        this.error = error;
        this.message = message;
    }

    public LichTrinhTour getLichTrinhTour() {
        return lichTrinhTour;
    }

    public void setLichTrinhTour(LichTrinhTour lichTrinhTour) {
        this.lichTrinhTour = lichTrinhTour;
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
