package com.luanvan.b1910025.services;

import com.luanvan.b1910025.models.LoaiTour;
import com.luanvan.b1910025.payloads.requests.LoaiTourRequest;
import com.luanvan.b1910025.repository.LoaiTourRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoaiTourServiceImpl implements LoaiTourService {
    @Autowired
    LoaiTourRepo loaiTourRepo;

    @Override
    public LoaiTour createLoaiTour(LoaiTourRequest loaiTourRequest) {
        LoaiTour loaiTour = new LoaiTour();
        loaiTour.setName(loaiTourRequest.getName());
        loaiTour.setNoiDung(loaiTourRequest.getNoiDung());
        return loaiTourRepo.save(loaiTour);
    }

    @Override
    public Optional<LoaiTour> updateLoaiTour(Long loaiTourId, LoaiTourRequest loaiTourRequest) {

        // TODO Auto-generated method stub
        Optional<LoaiTour> loaiTour = loaiTourRepo.findById(loaiTourId);
        if (loaiTour.isPresent()) {

            loaiTour.get().setName(loaiTourRequest.getName());
            loaiTour.get().setNoiDung(loaiTourRequest.getNoiDung());

            loaiTourRepo.save(loaiTour.get());
            return loaiTour;
        } else {
            throw new InvalidConfigurationPropertyValueException("Loại Tour: ", loaiTourId, "Not found");
        }
    }

    @Override
    public void deleteLTour(Long loaiTourId) {
        boolean hasExist = loaiTourRepo.existsById(loaiTourId);

//		if (brandRepo.findById(brandId).get().getId().equals(brandId))
        if (hasExist) {
            loaiTourRepo.deleteById(loaiTourId);
        } else
            throw new InvalidConfigurationPropertyValueException("LoaiTour: ", loaiTourId, "Not Found");

    }

    @Override
    public LoaiTour getASingleLoaiTour(Long loaiTourId) {
        return null;
    }

    @Override
    public List<LoaiTour> getAllLoaiTours() {
        return null;
    }


}
