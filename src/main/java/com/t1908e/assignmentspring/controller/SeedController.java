package com.t1908e.assignmentspring.controller;

import com.t1908e.assignmentspring.entity.District;
import com.t1908e.assignmentspring.entity.Street;
import com.t1908e.assignmentspring.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(value = "/seed/generate")
public class SeedController {
    @Autowired
    private DistrictRepository districtRepository;

    private static ArrayList<District> listDistrict = new ArrayList<>();
    @RequestMapping(method = RequestMethod.GET)
    public String runSeed() {
        //reset db
        districtRepository.deleteAll();
        //add
        District district1 = new District("Quận Cầu Giấy");
        district1.addStreet(new Street("Đường Bưởi", "Đường Bưởi", new Date(), 1, district1));
        district1.addStreet(new Street("Đường Xuân Thủy", "Đường Xuân Thủy", new Date(), 1, district1));
        listDistrict.add(district1);
        District district2 = new District("Quận Hoàn Kiếm");
        district2.addStreet(new Street("Đường Cầu Long Biên", "Đường Cầu Long Biên", new Date(), 1, district2));
        district2.addStreet(new Street("Phố Lý Thái Tổ", "Phố Lý Thái Tổ", new Date(), 2, district2));
        listDistrict.add(district2);
        District district3 = new District("Quận Hà Đông");
        district3.addStreet(new Street("Đường Nguyễn Khuyến", "Đường Nguyễn Khuyến", new Date(), 1, district3));
        district3.addStreet(new Street("Đường Chiến Thắng", "Đường Chiến Thắng", new Date(), 2, district3));
        listDistrict.add(district3);
        District district4 = new District("Quận Đống Đa");
        district4.addStreet(new Street("Đường An Trạch", "Đường An Trạch", new Date(), 1, district4));
        district4.addStreet(new Street("Đường Trịnh Hoài Đức", "Đường Trịnh Hoài Đức", new Date(), 2, district4));
        listDistrict.add(district4);
        District district5 = new District("Quận Thanh Xuân");
        district5.addStreet(new Street("Đường Nguyễn Huy Tưởng", "Đường Nguyễn Huy Tưởng", new Date(), 1, district5));
        district5.addStreet(new Street("Đường Vũ Trọng Phụng", "Đường Vũ Trọng Phụng", new Date(), 2, district5));
        listDistrict.add(district5);
        for (District dis :
                listDistrict) {
            districtRepository.save(dis);
        }
        return "Applied seed method";
    }
}
