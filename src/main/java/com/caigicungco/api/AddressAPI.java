package com.caigicungco.api;

import com.caigicungco.entity.DistrictEntity;
import com.caigicungco.entity.ProvinceEntity;
import com.caigicungco.entity.WardEntity;
import com.caigicungco.repository.DistrictRepository;
import com.caigicungco.repository.ProvinceRepository;
import com.caigicungco.repository.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class AddressAPI {

    @Autowired
    ProvinceRepository provinceRepository;
    @Autowired
    DistrictRepository districtRepository;
    @Autowired
    WardRepository wardRepository;


    @GetMapping(value = "/api/province")
    ResponseEntity<List<ProvinceEntity>> findProvince(){
        return ResponseEntity.ok(provinceRepository.findAll());
    }

    @GetMapping(value = "/api/district/{id}")
    ResponseEntity<List<DistrictEntity>> findDistrict(@PathVariable("id") Integer provinceId){
        return ResponseEntity.ok(districtRepository.findByProvinceId(provinceId));
    }

    @GetMapping(value = "/api/ward/{id}")
    ResponseEntity<List<WardEntity>> findWard(@PathVariable("id") Integer districtId){
        return ResponseEntity.ok(wardRepository.findByDistrictId(districtId));
    }
}
