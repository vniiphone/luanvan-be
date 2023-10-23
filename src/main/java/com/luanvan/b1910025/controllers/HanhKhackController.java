package com.luanvan.b1910025.controllers;

import com.luanvan.b1910025.repository.BookingRepo;
import com.luanvan.b1910025.repository.HanhKhachRepo;
import com.luanvan.b1910025.services.HanhKhachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8088")
@RestController
@RequestMapping("/api/Hanh-Khach")
public class HanhKhackController {

    @Autowired
    HanhKhachRepo hanhKhachRepo;

    @Autowired
    HanhKhachService hanhKhachService;

    @Autowired
    BookingRepo bookingRepo;







}
