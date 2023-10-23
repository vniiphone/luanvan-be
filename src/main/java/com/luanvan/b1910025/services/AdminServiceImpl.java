package com.luanvan.b1910025.services;

import com.luanvan.b1910025.payloads.responses.DashbroadResponse;
import com.luanvan.b1910025.repository.HoaDonRepo;
import com.luanvan.b1910025.repository.TourRepo;
import com.luanvan.b1910025.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    UserRepo userRepo;
    @Autowired
    TourRepo tourRepo;
    @Autowired
    HoaDonRepo hoaDonRepo;
    @Override
    public DashbroadResponse getDashBroad() {
        long totalUser = userRepo.count();
        long totalTour = tourRepo.count();
        long totalHoaDon = hoaDonRepo.count();
        double totalDoanhThu = hoaDonRepo.tongDoanhThu();

        return new DashbroadResponse(totalUser, totalTour, totalHoaDon, totalDoanhThu);

    }
}
