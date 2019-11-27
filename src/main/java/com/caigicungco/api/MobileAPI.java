package com.caigicungco.api;



import com.caigicungco.DTO.ElectronicDTO;
import com.caigicungco.DTO.api.ModelAPI;
import com.caigicungco.service.ElectronicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@CrossOrigin(maxAge = 3600,origins = "*")
public class MobileAPI {
    @Autowired
    ElectronicService electronicService;

    @GetMapping(value = "/api/mobile/{producer}")
    public ResponseEntity<ModelAPI> findByProducer(
            @RequestParam("page") Integer page,
            @RequestParam(value = "pageItem",defaultValue = "10") Integer pageItem,
            @PathVariable("producer") String producer){

        List<ElectronicDTO> electronics = electronicService.findByProducerName(producer,PageRequest.of(page,pageItem));
        if(electronics == null){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        ModelAPI<ElectronicDTO> modelAPI = new ModelAPI<>("ok",electronics);
        return new ResponseEntity<ModelAPI>(modelAPI, HttpStatus.OK);
    }


}
