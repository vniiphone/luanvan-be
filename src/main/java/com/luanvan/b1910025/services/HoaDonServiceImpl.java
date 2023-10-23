package com.luanvan.b1910025.services;

import com.luanvan.b1910025.models.*;
import com.luanvan.b1910025.payloads.requests.HoaDonRequest;
import com.luanvan.b1910025.repository.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class HoaDonServiceImpl implements HoaDonService {

    @Autowired
    UserRepo userRepository;
    @Autowired
    HoaDonRepo invoiceRepository;
    @Autowired
    TourRepo tourRepository;
    @Autowired
    DiaChiRepo addressRepository;
    @Autowired
    BookingService cartItemService;
    @Autowired
    BookingRepo cartItemReponsitory;

    @Autowired
    ProfileRepo profileRepo;

    double totalPrice = 0;


    @Override
    public HoaDon getInvoice(long invoiceId) {
        HoaDon hoaDon = invoiceRepository.findHoaDonWithTour(invoiceId);
        double tongTien = hoaDon.getTotalPrice();
        double soVe = tongTien/hoaDon.getTour().getGiaThamKhao();
        long sv = Long.parseLong(String.valueOf(soVe));
        hoaDon.setSoLuongVeDaDat(sv);
        log.info("HoaDon: "+hoaDon);
        return hoaDon;
    }

    @Override
    public List<HoaDon> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    @Override
    public List<HoaDon> getAllUserInvoices(long userId) {
        return invoiceRepository.findByUser_Id(userId);
    }

    @Override
    public List<HoaDon> getAllInvoicesPaySuccessByUser(long userId) {
        List<HoaDon> list = invoiceRepository.findByUser_Id(userId);
        List<HoaDon> list2 = new ArrayList<>();

        for (HoaDon invoice : list) {
            if (invoice.isWasPay())
                list2.add(invoice);
        }

        return list2;
    }

    @Override
    public List<HoaDon> getAllInvoicesByUserId(long userId) {
        List<HoaDon> list = invoiceRepository.findByUser_Id(userId);
        return list;
    }

    @Override
    public HoaDon creatInvoice(HoaDonRequest invoiceRequest) {
       /* User user = userRepository.findById(invoiceRequest.getUser_id()).orElseThrow();
        DiaChi address = addressRepository.findById(invoiceRequest.getDiaChi_id()).orElseThrow();
        List<Booking> cartItems = cartItemService.getBooking(invoiceRequest.getUser_id());

//        Booking booking = cartItemService.getBookingById(invoiceRequest.getBooking_id());
        for (Booking cartItem : cartItems) {
            totalPrice += cartItem.getSoLuongVeDat() * cartItem.getTour().getGiaThamKhao();
        }
//        if(booking != null){
        HoaDon invoice = new HoaDon(
                user,
                "",
                "",
                totalPrice,
                false,
                cartItems,
                address);
        // timeCreate & paymentMethod gán "" vì chưa thanh toán thành công nên chưa thể
        // tạo.

        invoiceRepository.save(invoice);
        totalPrice = 0;

        for (Booking cartItem : cartItems) {
            cartItem.setHoaDon(invoice);
            cartItemReponsitory.save(cartItem);
        }
*/
//        return invoice;
//        } else {
        return null;
//        }


    }

    @Override
    public HoaDon creatInvoiceVerHaveProfile(HoaDonRequest invoiceRequest) {
        User user = userRepository.findById(invoiceRequest.getUser_id()).orElseThrow();
        Profile profile = profileRepo.findById(invoiceRequest.getProfile_id()).orElseThrow();
        Tour tour = tourRepository.findById(invoiceRequest.getTour_id()).orElseThrow();
        List<Booking> cartItems = cartItemService.getBooking(invoiceRequest.getUser_id());

//        Booking booking = cartItemService.getBookingById(invoiceRequest.getBooking_id());
        for (Booking cartItem : cartItems) {
            totalPrice += cartItem.getSoLuongVeDat() * cartItem.getTour().getGiaThamKhao();
        }
        log.info("totalPrice create: " + totalPrice);

//        if(booking != null){
    /*    HoaDon invoice = new HoaDon(
                user,
                "",
                "",
                totalPrice,
                false,
                cartItems,
                profile);*/
        // timeCreate & paymentMethod gán "" vì chưa thanh toán thành công nên chưa thể
        // tạo.

        long soLuongVeDaDat = (long)(totalPrice / tour.getGiaThamKhao());


        //Có TourID, SoLuongVeDaDat
        HoaDon in = new HoaDon(
                user,
                "",
                "",
                totalPrice,
                false,
                cartItems,
                tour,
                soLuongVeDaDat,
                profile
        );

        invoiceRepository.save(in);
        totalPrice = 0;

        log.info("Invoice create: " + in);
        for (Booking cartItem : cartItems) {
            cartItem.setHoaDon(in);
            cartItemReponsitory.save(cartItem);
        }

        return in;
//        } else {
//            return  null;
//        }
    }

    @Override
    public void deleteInvoiceById(Long invoiceId) {
// TODO Auto-generated method stub
        if (invoiceRepository.findById(invoiceId).get().getId().equals(invoiceId)) {
            invoiceRepository.deleteById(invoiceId);
        } else
            throw new InvalidConfigurationPropertyValueException("hoaDonId: ", invoiceId, "Not Found");

    }

    @Override
    public Optional<HoaDon> updateToursInInvoice(HoaDon invoice, long cartItemsId) {
        List<Booking> listCartItem = cartItemService.getBooking(cartItemsId);

        for (Booking cartItem : listCartItem) {
            cartItem.setHoaDon(invoice);
            totalPrice += cartItem.getSoLuongVeDat() * cartItem.getTour().getGiaThamKhao();
            cartItemReponsitory.save(cartItem);
        }
        invoice.setTotalPrice(totalPrice);
        totalPrice = 0;
        return Optional.of(invoice);
    }

    @Override
    public Optional<HoaDon> setPaymentSuccess(HoaDon hoaDon, String paymentMethod, Long userId) {
        List<Booking> listCartItem = cartItemService.getBooking(userId);

        ZoneId zoneId = ZoneId.of("Asia/Ho_Chi_Minh"); // Xác định múi giờ (Việt Nam)
        ZonedDateTime now = ZonedDateTime.now(zoneId);
//        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        int hour = now.getHour();
        int minute = now.getMinute();
        String timeString = day + "-" + month + "-" + year + " " + hour + ":" + minute;

        hoaDon.setPaymentMethod(paymentMethod);
        hoaDon.setWasPay(true);
        hoaDon.setTimeCreate(timeString);
        log.info("Debug setpayment: " + hoaDon);
        invoiceRepository.save(hoaDon);

        Tour tour = new Tour();

        for (Booking cartItem : listCartItem) {
            cartItem.setStatusDat(1);
            cartItemReponsitory.save(cartItem);

            tour = cartItem.getTour();
            tour.setSoLuongVe(tour.getSoLuongVe() - cartItem.getSoLuongVeDat());
            tourRepository.save(tour);
        }
        log.info("Debug setpayment: " + hoaDon);

        return Optional.of(hoaDon);
    }

    @Override
    public HoaDon getASingleHoaDon(Long hoaDonId) {
        return invoiceRepository.findById(hoaDonId)
                .orElseThrow(() -> new InvalidConfigurationPropertyValueException("hoaDonId", hoaDonId, "Not found"));

    }
}
