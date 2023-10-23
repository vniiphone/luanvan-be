package com.luanvan.b1910025.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoaiTour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
//    @NotBlank(message="Noi dung trống")
    private String noiDung;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "loaiTour", orphanRemoval = true)
    private List<Tour> tours = new ArrayList<>();


//getter methods
    //setter methods
    //constructor methods
}
