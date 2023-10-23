package com.luanvan.b1910025.services;

import com.luanvan.b1910025.models.Booking;
import com.luanvan.b1910025.models.HanhKhach;
import com.luanvan.b1910025.payloads.requests.HanhKhachRequest;
import com.luanvan.b1910025.repository.BookingRepo;
import com.luanvan.b1910025.repository.HanhKhachRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HanhKhachServiceImpl implements  HanhKhachService{

    @Autowired
    HanhKhachRepo hanhKhachRepo;

    @Autowired
    BookingRepo bookingRepo;


    @Override
    public HanhKhach createHanhKhach(HanhKhachRequest hanhKhachRequest) {

        Booking booking = bookingRepo.findById(hanhKhachRequest.getBookingId()).orElseThrow();

        HanhKhach hk = new HanhKhach(
                hanhKhachRequest.getHoTenHK(),
                hanhKhachRequest.getSdtHK(),
                hanhKhachRequest.getDoTuoiHK(),
                hanhKhachRequest.getDiaChiHK(),
                booking
        );

        return hanhKhachRepo.save(hk);
    }

    @Override
    public Optional<HanhKhach> updateHanhKhach(Long hanhKhachId, HanhKhachRequest hanhKhachRequest) {
        return Optional.empty();
    }

    @Override
    public void deleteHanhKhach(Long hanhKhachId) {

    }

    @Override
    public HanhKhach getASingleHanhKhach(Long hanhKhachId) {
        return hanhKhachRepo.findById(hanhKhachId)
                .orElseThrow(() -> new InvalidConfigurationPropertyValueException("hanhKhachId: ", hanhKhachId, "Not found"));

    }

    @Override
    public List<HanhKhach> getAllHanhKhach() {
        return hanhKhachRepo.findAll();
    }
}
