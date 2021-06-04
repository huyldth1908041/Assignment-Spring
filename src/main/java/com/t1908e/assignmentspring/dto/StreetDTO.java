package com.t1908e.assignmentspring.dto;

import com.t1908e.assignmentspring.entity.Street;
import com.t1908e.assignmentspring.util.ConvertUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Getter
@Setter
@ToString
@NoArgsConstructor
public class StreetDTO {
    private int id;
    private String name;
    private String description;
    private Date inauguratedAt;
    private int status; //1 in-use 2// under-construction 3//fixing
    private int districtId;
    public StreetDTO(Street street) {
        this.id = street.getId();
        this.description = street.getDescription();
        this.inauguratedAt = street.getInauguratedAt();
        this.status = street.getStatus();
        this.name = street.getName();
        if(street.getDistrict() != null) {
            this.districtId = street.getDistrict().getId();
        }
    }

}

