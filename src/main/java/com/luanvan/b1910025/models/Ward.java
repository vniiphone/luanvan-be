package com.luanvan.b1910025.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.tomcat.jni.Address;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JoinColumn(name = "district_id")
    @ManyToOne
    private District district;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ward", orphanRemoval = true)
    private List<DiaChi> diaChiList = new ArrayList<>();

    public Ward(Long id, String name, District district, List<DiaChi> diaChiList) {
        this.id = id;
        this.name = name;
        this.district = district;
        this.diaChiList = diaChiList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Ward() {
    }



    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public List<DiaChi> getDiaChiList() {
        return diaChiList;
    }

    public void setDiaChiList(List<DiaChi> diaChiList) {
        this.diaChiList = diaChiList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
