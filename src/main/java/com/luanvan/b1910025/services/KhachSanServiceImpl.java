/*
package com.luanvan.b1910025.services;

import com.luanvan.b1910025.models.KhachSan;
import com.luanvan.b1910025.models.LichTrinhTour;
import com.luanvan.b1910025.payloads.requests.KhachSanRequest;
import com.luanvan.b1910025.repository.KhachSanRepo;
import com.luanvan.b1910025.repository.LichTrinhTourRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Log4j2
public class KhachSanServiceImpl implements KhachSanService {

    @Autowired
    KhachSanRepo repo;

    @Autowired
    LichTrinhTourRepo lttRepo;


    @Override
    public KhachSan createKhachSan(KhachSanRequest khachSanRequest) {

        LichTrinhTour lichTrinhTour = lttRepo.findById(khachSanRequest.getLichTrinhTour_id()).orElseThrow();

        KhachSan khachSan = new KhachSan(
                khachSanRequest.getName(),
                khachSanRequest.getPhone(),
                khachSanRequest.getDiaChiKsan(),
                khachSanRequest.getGiaPhong(),
                lichTrinhTour);

        return repo.save(khachSan);
    }

    @Override
    public List<KhachSan> listAllKhachSan() {
        return null;
    }

    @Override
    public Optional<KhachSan> updateKsan(Long khachSanID, KhachSanRequest khachSanRequest) {
        return Optional.empty();
    }

    @Override
    public void deleteKsan(Long ksanID) {

        boolean hasExist = repo.existsById(ksanID);
        if (hasExist) {
            repo.deleteById(ksanID);
            log.error("Delete ksanID: " + ksanID);
        } else throw new InvalidConfigurationPropertyValueException("ksanID", ksanID, "Not Found");


    }

    @Override
    public KhachSan getASingleKhachSan(Long ksanID) {
        return null;
    }

    @Override
    public KhachSan getKhachSanbyLichTrinhTour(Long lttId) {
        return null;
    }
}
*/
