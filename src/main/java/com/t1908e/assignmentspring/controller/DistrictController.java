package com.t1908e.assignmentspring.controller;

import com.t1908e.assignmentspring.dto.DistrictDTO;
import com.t1908e.assignmentspring.dto.ReturnStreetDTO;
import com.t1908e.assignmentspring.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/districts")
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    @RequestMapping(method = RequestMethod.GET)
    public List<DistrictDTO> list() {
        return districtService.listAll();

    }
}
