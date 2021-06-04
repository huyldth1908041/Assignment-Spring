package com.t1908e.assignmentspring.service;

import com.t1908e.assignmentspring.dto.ReturnStreetDTO;
import com.t1908e.assignmentspring.dto.StreetDTO;
import com.t1908e.assignmentspring.entity.District;
import com.t1908e.assignmentspring.entity.Street;
import com.t1908e.assignmentspring.repository.DistrictRepository;
import com.t1908e.assignmentspring.repository.StreetRepository;
import com.t1908e.assignmentspring.util.ConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StreetService {
    @Autowired
    private StreetRepository streetRepository;

    @Autowired
    private DistrictRepository districtRepository;


    public ReturnStreetDTO createStreet(StreetDTO streetDto) {
        //get district in db
        Optional<District> districtOptional = districtRepository.findById(streetDto.getDistrictId());
        District currentDistrict = districtOptional.orElse(null);
        if(currentDistrict == null) {
            return null;
        }
        //convert to street
        Street street = ConvertUtil.convertStreetDTOtoStreet(streetDto, currentDistrict);
        Street saved = streetRepository.save(street);
        if(saved == null) {
            return null;
        }
        //covert to dto to return
        return new ReturnStreetDTO(saved);
    }

    public List<ReturnStreetDTO> listAll() {
        List<Street> all = streetRepository.findAll();
        //covert to dto
        return all.stream().map(item -> new ReturnStreetDTO(item)).collect(Collectors.toList());
    }

    public List<ReturnStreetDTO> filterByNameAndDistrict(String name, int district) {
        List<Street> streets = streetRepository.filterStreet(name, district);
        return streets.stream().map(item -> new ReturnStreetDTO(item)).collect(Collectors.toList());
    }
}
