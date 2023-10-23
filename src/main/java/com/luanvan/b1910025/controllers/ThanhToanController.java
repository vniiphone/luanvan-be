package com.luanvan.b1910025.controllers;


import com.luanvan.b1910025.models.HoaDon;
import com.luanvan.b1910025.payloads.requests.PaymentRequest;
import com.luanvan.b1910025.repository.HoaDonRepo;
import com.luanvan.b1910025.services.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/payment")
public class ThanhToanController {

    @Autowired
    HoaDonRepo invoiceRepo;
    @Autowired
    HoaDonService invoiceService;

    HoaDon invoice0 = new HoaDon();
    Long userId0 = 0L;

    //     Sau khi đã chọn phương thức thanh toán => setPaySuccess để gán hóa đơn này
//     đã thanh toán thành công + xóa các sản phẩm trong giỏ hàng hiện tại
    @PutMapping(value = "/setPaySuccess/{invoiceId}", consumes = {"*/*"})
//    @PreAuthorize("hasRole('USER'))
    public ResponseEntity<HoaDon> setPaySuccess(
            @PathVariable("invoiceId")   Long invoiceId,
            @Valid @RequestBody PaymentRequest paymentRequest) {
        HoaDon invoice = invoiceRepo.findById(invoiceId).orElseThrow();
        try {
            invoiceService.setPaymentSuccess(invoice, paymentRequest.getPaymentMethod(), paymentRequest.getUser_id());
            return new ResponseEntity<>(invoice, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
