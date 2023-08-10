package com.luanvan.b1910025.payloads.requests;

import javax.validation.constraints.NotBlank;

public class LoaiTourRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "noiDung is required")
    private String noiDung;


//	@NotNull
//	private Long id;

//    @NotNull
//	private Long tour_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
