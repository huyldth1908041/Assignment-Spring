package com.t1908e.assignmentspring.controller;

import com.t1908e.assignmentspring.dto.ReturnStreetDTO;
import com.t1908e.assignmentspring.dto.StreetDTO;
import com.t1908e.assignmentspring.entity.Street;
import com.t1908e.assignmentspring.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/streets")
public class StreetController {
    @Autowired
    private StreetService streetService;

    @RequestMapping(method = RequestMethod.POST)
    public ReturnStreetDTO createStreet(@RequestBody StreetDTO streetDTO) {
        ReturnStreetDTO res = streetService.createStreet(streetDTO);
        if(res == null) {
            return null;
        }
        return res;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ReturnStreetDTO> list() {
        return streetService.listAll();

    }

    @RequestMapping(method = RequestMethod.GET, value = "/filter")
    public List<ReturnStreetDTO> filter(@RequestParam(value = "name") String name, @RequestParam(value = "district") int district) {
        return streetService.filterByNameAndDistrict(name, district);

    }
}