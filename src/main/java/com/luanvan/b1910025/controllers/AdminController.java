package com.luanvan.b1910025.controllers;

import com.luanvan.b1910025.payloads.responses.DashbroadResponse;
import com.luanvan.b1910025.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "http://127.0.0.1:5173", maxAge = 3600)
@RestController
@RequestMapping("/api/admin")
public class AdminController {
	@Autowired
    AdminService adminService;

	/* get dash broad data */
	@GetMapping("/dashboard")
	public DashbroadResponse dashBroad() {
		return adminService.getDashBroad();
	}
}