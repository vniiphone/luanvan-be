package com.luanvan.b1910025.payloads.requests;
import javax.validation.constraints.*;
public class BookingRequest {

    @NotNull
    private Long user_id;
    @NotNull
    private Long tour_id;

    @NotNull(message = "Số lượng vé is required")
    @Min(value = 0, message = "Số lượng vé must be greater than or equal to 0")
    @Max(value = 15, message = "Số lượng vé must be less than or equal to 15")
    private int soLuongVeDat;

    public BookingRequest(Long user_id, Long tour_id, int soLuongVeDat) {
        this.user_id = user_id;
        this.tour_id = tour_id;
        this.soLuongVeDat = soLuongVeDat;
    }

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

    public int getSoLuongVeDat() {
        return soLuongVeDat;
    }

    public void setSoLuongVeDat(int soLuongVeDat) {
        this.soLuongVeDat = soLuongVeDat;
    }
}
