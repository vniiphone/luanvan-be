package com.luanvan.b1910025.models;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;

    private String image_Url;


    public Image() {
    }

    public String getImage_url() {
        return image_Url;
    }

    public void setImage_url(String image_Url) {
        this.image_Url = image_Url;
    }

    public Image(Long id, String image_Url) {
        this.id = id;
        this.image_Url = image_Url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
