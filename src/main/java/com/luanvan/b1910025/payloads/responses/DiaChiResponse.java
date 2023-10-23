package com.luanvan.b1910025.payloads.responses;

import com.luanvan.b1910025.models.DiaChi;
import org.springframework.beans.factory.annotation.Autowired;

public class DiaChiResponse {

    @Autowired
    DiaChi diaChi;
    public Error error;
    public String message;

    public DiaChi getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(DiaChi diaChi) {
        this.diaChi = diaChi;
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

    public  DiaChiResponse(){
        super();
    }
    public DiaChiResponse(DiaChi diaChi, Error error, String message) {
        super();
        this.diaChi = diaChi;
        this.error = error;
        this.message = message;
    }
}
