package com.luanvan.b1910025.controllers;

import com.luanvan.b1910025.models.HoaDon;
import com.luanvan.b1910025.payloads.requests.HoaDonRequest;
import com.luanvan.b1910025.repository.DiaChiRepo;
import com.luanvan.b1910025.repository.HoaDonRepo;
import com.luanvan.b1910025.repository.ProfileRepo;
import com.luanvan.b1910025.services.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8088")
@RestController
@RequestMapping("/api/hoa-don")
public class HoaDonController {

    @Autowired
    HoaDonService invoiceService;
    @Autowired
    HoaDonRepo invoiceRepository;
    @Autowired
    DiaChiRepo addressRepository;

    @Autowired
    ProfileRepo profileRepo;

    @Autowired
    AuthenticationManager authenticationManager;

    // Lấy ra toàn bộ hóa đơn để Admin xem
    @GetMapping("/getAllInvoices")
    // @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<HoaDon>> getAllInvoices() {
        try {
            List<HoaDon> lstInvoices = invoiceService.getAllInvoices();
            return new ResponseEntity<>(lstInvoices, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getInvoiceByHoaDonId/{hoaDonId}")
    public ResponseEntity<HoaDon> getInvoiceByHoaDonId(@PathVariable("hoaDonId") long hoaDonId) {
        try {
            HoaDon hoaDon = invoiceService.getInvoice(hoaDonId);
            return new ResponseEntity<>(hoaDon, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping(value = "/create", consumes = {"*/*"})
    public ResponseEntity<HoaDon> creatInvoice(@Valid @RequestBody HoaDonRequest invoiceRequest) {
        return new ResponseEntity<>(invoiceService.creatInvoiceVerHaveProfile(invoiceRequest), HttpStatus.CREATED);
    }

    // Lấy ra toàn bộ hóa đơn của người dùng A đã thanh toán thành công
    @GetMapping("/getAllInvoicesPaySuccessByUser/{userId}")
    // @PreAuthorize("hasRole('USER'))
    public ResponseEntity<List<HoaDon>> getInvoicesPaySuccessByUser(@PathVariable("userId") Long userId) {
        try {
            List<HoaDon> lstInvoices = invoiceService.getAllInvoicesPaySuccessByUser(userId);
            return new ResponseEntity<>(lstInvoices, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Lấy ra tất cả hóa đơn của người dùng bằng user_id
    @GetMapping("/getAllInvoicesByUser/{userId}")
    // @PreAuthorize("hasRole('USER'))
    public ResponseEntity<List<HoaDon>> getInvoicesByUser(@PathVariable("userId") Long userId) {
        try {
            List<HoaDon> lstInvoices = invoiceService.getAllInvoicesByUserId(userId);
            return new ResponseEntity<>(lstInvoices, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Lấy ra chỉ 1 hóa đơn của người dùng A (khi người dùng bấm từ giỏ hàng vào
    // thanh toán hoặc khi bấm vào xem chi tiết 1 hóa đơn đã thành công nào đó)
    @GetMapping("/getHoaDon/{userId}/{invoiceId}")
    public ResponseEntity<HoaDon> getInvoice(@PathVariable("userId") Long userId, @PathVariable("invoiceId") Long invoiceId) {

        try {
            boolean check = false;
            List<HoaDon> listInvoices = invoiceService.getAllUserInvoices(userId);
            HoaDon invoice = new HoaDon(); // invoiceService.getInvoice(invoiceId);

            for (HoaDon invoice0 : listInvoices) {
                if (invoiceId == invoice0.getId()) {
                    invoice = invoice0;
                    check = true;
                }
            }
            if (check)
                return new ResponseEntity<>(invoice, HttpStatus.OK);
            else
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Cập nhật lại các sản phẩm khi đã chỉnh, thêm, xóa trong giỏ hàng
    @PutMapping(value = "/updateToursInInvoice/{invoiceId}", consumes = {"*/*"})
    public ResponseEntity<Optional<HoaDon>> updateProductsInInvoice(
            @PathVariable("invoiceId") Long invoiceId,
            @Valid @RequestBody HoaDonRequest invoiceRequest) {

        HoaDon invoice = invoiceRepository.findById(invoiceId).orElseThrow();
        if (invoice.isWasPay() == false)
            return new ResponseEntity<>(invoiceService.updateToursInInvoice(invoice, invoiceRequest.getUser_id()),
                    HttpStatus.OK);
        else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
