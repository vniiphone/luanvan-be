package com.luanvan.b1910025.services;

import com.luanvan.b1910025.payloads.responses.DashbroadResponse;
import org.springframework.stereotype.Component;

@Component
public interface AdminService {
    DashbroadResponse getDashBroad();

}
