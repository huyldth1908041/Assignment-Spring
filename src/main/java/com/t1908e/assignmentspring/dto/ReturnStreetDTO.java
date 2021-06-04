package com.t1908e.assignmentspring.dto;

import com.t1908e.assignmentspring.entity.Street;
import com.t1908e.assignmentspring.util.ConvertUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ReturnStreetDTO {
    private int id;
    private String name;
    private String description;
    private String inauguratedAt;
    private String status; //1 in-use 2// under-construction 3//fixing
    private String district;
    public ReturnStreetDTO(Street street) {
        this.id = street.getId();
        this.name = street.getName();
        this.description = street.getDescription();
        this.inauguratedAt = ConvertUtil.convertJavaDateToString(street.getInauguratedAt());
        this.status = street.getStatusString();
        this.district = street.getDistrict().getName();
    }

}
