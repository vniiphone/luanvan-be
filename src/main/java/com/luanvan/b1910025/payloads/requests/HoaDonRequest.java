package com.luanvan.b1910025.payloads.requests;

import javax.validation.constraints.NotNull;

public class HoaDonRequest {

    @NotNull
    private Long user_id;

    @NotNull
    private Long booking_id;

    @NotNull
    private Long profile_id;

    @NotNull
    private Long tour_id;



    public Long getTour_id() {
        return tour_id;
    }

    public void setTour_id(Long tour_id) {
        this.tour_id = tour_id;
    }

    public Long getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(Long profile_id) {
        this.profile_id = profile_id;
    }

    public Long getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(Long booking_id) {
        this.booking_id = booking_id;
    }


    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

//    public Long getDiaChi_id() {
//        return diaChi_id;
//    }
//
//    public void setDiaChi_id(Long diaChi_id) {
//        this.diaChi_id = diaChi_id;
//    }

}
