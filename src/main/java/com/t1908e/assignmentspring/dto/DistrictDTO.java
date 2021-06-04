package com.t1908e.assignmentspring.dto;

import com.t1908e.assignmentspring.entity.District;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
@Setter
@Getter
public class DistrictDTO {
    private int id;
    private String name;
    private Set<ReturnStreetDTO> streets;

    public DistrictDTO(District district) {
        this.id = district.getId();
        this.name = district.getName();
        this.streets = district.getStreets().stream().map(item -> new ReturnStreetDTO(item)).collect(Collectors.toSet());
    }
}
