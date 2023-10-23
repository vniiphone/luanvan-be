package com.luanvan.b1910025.services;


import com.luanvan.b1910025.models.DiemDen;
import com.luanvan.b1910025.models.HanhKhach;
import com.luanvan.b1910025.payloads.requests.DiemDenRequest;
import com.luanvan.b1910025.payloads.requests.HanhKhachRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface HanhKhachService {

    HanhKhach createHanhKhach(HanhKhachRequest hanhKhachRequest);

    Optional<HanhKhach> updateHanhKhach(Long hanhKhachId, HanhKhachRequest hanhKhachRequest);

    void deleteHanhKhach(Long hanhKhachId);

    HanhKhach getASingleHanhKhach(Long hanhKhachId);

    List<HanhKhach> getAllHanhKhach();

}
