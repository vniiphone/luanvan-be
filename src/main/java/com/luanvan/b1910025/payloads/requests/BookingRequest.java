package com.luanvan.b1910025.payloads.requests;
import javax.validation.constraints.*;
public class BookingRequest {

    @NotNull
    private Long user_id;
    @NotNull
    private Long tour_id;
    @NotNull
    @Min(0)
    private int soLuongVeDat;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getTour_id() {
        return tour_id;
    }

    public void setTour_id(Long tour_id) {
        this.tour_id = tour_id;
    }

    public int getSoLuongVe() {
        return soLuongVeDat;
    }

    public void setSoLuongVe(int soLuongVe) {
        this.soLuongVeDat = soLuongVe;
    }
}
