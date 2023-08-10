package com.luanvan.b1910025.payloads.requests;
import javax.validation.constraints.NotNull;

public class HoaDonRequest {

    @NotNull
    private Long user_id;

    // @NotNull
    // private Long cart_id;

    @NotNull
    private Long diaChi_id;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getDiaChi_id() {
        return diaChi_id;
    }

    public void setDiaChi_id(Long diaChi_id) {
        this.diaChi_id = diaChi_id;
    }
}
