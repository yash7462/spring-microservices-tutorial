package com.sales.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sales.modal.ContactVo;
import com.sales.modal.SalesVo;

import lombok.extern.java.Log;
@Log
@RestController
@RequestMapping("/sales")
public class SalesController {
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping(value ={"","/"})
    public List<SalesVo> getSalesList() {
        List<SalesVo> salesList=new ArrayList<>();
        salesList.add(new SalesVo(1L, 001L, null, 500, "CAR Service"));
        salesList.add(new SalesVo(1L, 001L, null, 500, "Laptop Service"));
        return salesList;
    }
	
	@RequestMapping(value ="/{salesId}")
    public SalesVo getSalesDetails(@PathVariable("salesId") long salesId) {
		
        ResponseEntity<ContactVo> responseBody = restTemplate.getForEntity("http://CONTACT-SERVICE/contact/1", ContactVo.class);
        log.warning("response---status--->"+responseBody.getStatusCode());
        return new SalesVo(1L, 001L, responseBody.getBody(), 500, "AC Service");
    }
}
