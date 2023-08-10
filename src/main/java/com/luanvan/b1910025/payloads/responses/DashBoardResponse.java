package com.luanvan.b1910025.payloads.responses;

public class DashBoardResponse {

    public long tongNguoiDung;
    public long tongTour;
    public long tongSoHoaDon;
    public double tongDoanhThu;


    public long getTongNguoiDung() {
        return tongNguoiDung;
    }

    public void setTongNguoiDung(long tongNguoiDung) {
        this.tongNguoiDung = tongNguoiDung;
    }

    public long getTongTour() {
        return tongTour;
    }

    public void setTongTour(long tongTour) {
        this.tongTour = tongTour;
    }

    public long getTongSoHoaDon() {
        return tongSoHoaDon;
    }

    public void setTongSoHoaDon(long tongSoHoaDon) {
        this.tongSoHoaDon = tongSoHoaDon;
    }

    public double getTongDoanhThu() {
        return tongDoanhThu;
    }

    public void setTongDoanhThu(double tongDoanhThu) {
        this.tongDoanhThu = tongDoanhThu;
    }

    public DashBoardResponse(long tongNguoiDung, long tongTour, long tongSoHoaDon, double tongDoanhThu) {
        this.tongNguoiDung = tongNguoiDung;
        this.tongTour = tongTour;
        this.tongSoHoaDon = tongSoHoaDon;
        this.tongDoanhThu = tongDoanhThu;
    }
}
