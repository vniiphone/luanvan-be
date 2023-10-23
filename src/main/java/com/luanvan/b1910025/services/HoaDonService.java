package com.luanvan.b1910025.services;


import com.luanvan.b1910025.models.Booking;
import com.luanvan.b1910025.models.HoaDon;
import com.luanvan.b1910025.payloads.requests.HoaDonRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface HoaDonService {

    HoaDon getInvoice(long invoiceId);

    List<HoaDon> getAllInvoices();

    List<HoaDon> getAllUserInvoices(long userId);

    List<HoaDon> getAllInvoicesPaySuccessByUser(long userId);

    List<HoaDon> getAllInvoicesByUserId(long userId);

    HoaDon creatInvoice(HoaDonRequest invoiceRequest);

    HoaDon creatInvoiceVerHaveProfile(HoaDonRequest invoiceRequest);

    void deleteInvoiceById(Long invoiceId);

    Optional<HoaDon> updateToursInInvoice(HoaDon invoice, long cartItemsId);

    Optional<HoaDon> setPaymentSuccess(HoaDon invoice, String paymentMethod, Long userId);

    HoaDon getASingleHoaDon(Long hoaDonId);

}
