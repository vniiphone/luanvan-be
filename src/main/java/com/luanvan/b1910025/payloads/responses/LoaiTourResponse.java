package com.luanvan.b1910025.payloads.responses;

import com.luanvan.b1910025.models.LoaiTour;
import org.springframework.beans.factory.annotation.Autowired;

public class LoaiTourResponse {

    @Autowired LoaiTour loaiTour;
    public Error error;
    public String message;

    public LoaiTourResponse(LoaiTour loaiTour, Error error, String message) {
        super();
        this.loaiTour = loaiTour;
        this.error = error;
        this.message = message;
    }

    public LoaiTour getLoaiTour() {
        return loaiTour;
    }

    public void setLoaiTour(LoaiTour loaiTour) {
        this.loaiTour = loaiTour;
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
