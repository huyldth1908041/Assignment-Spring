package com.t1908e.assignmentspring.service;

import com.t1908e.assignmentspring.dto.DistrictDTO;
import com.t1908e.assignmentspring.dto.ReturnStreetDTO;
import com.t1908e.assignmentspring.entity.District;
import com.t1908e.assignmentspring.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DistrictService {
    @Autowired
    private DistrictRepository districtRepository;

    public List<DistrictDTO> listAll() {
        List<District> all = districtRepository.findAll();
        return all.stream().map(item -> new DistrictDTO(item)).collect(Collectors.toList());
    }
}
