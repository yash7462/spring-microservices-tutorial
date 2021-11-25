package com.sales.controller;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sales.config.ApiResponse;
import com.sales.config.ServiceResponse;
import com.sales.modal.ContactVo;
import com.sales.modal.SalesVo;
import com.sales.service.SalesService;
import com.thoughtworks.xstream.mapper.Mapper;

import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping("/sales")
public class SalesController {
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	SalesService salesService;

	@RequestMapping(value = { "", "/" })
	public ResponseEntity<ApiResponse> getSalesList() {
		ApiResponse apiResponse = null;
		List<SalesVo> salesList = salesService.findByIsDeletedOrderBySalesIdDesc(0);
		if (!salesList.isEmpty()) {
			apiResponse = new ApiResponse(true, salesList.size() + " Sales Found", salesList);
		} else {
			apiResponse = new ApiResponse(false, "0 Sales Found", null);
		}
		return ResponseEntity.ok(apiResponse);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<ApiResponse> insertSales(@RequestBody SalesVo salesVo) {
		ApiResponse apiResponse = null;
		SalesVo sales = salesService.insertSales(salesVo);
		if (sales != null) {
			apiResponse = new ApiResponse(true, "Sales Inserted Successfully", sales);
		} else {
			apiResponse = new ApiResponse(false, "Something Went Wrong on saving Sales Details", null);
		}
		return ResponseEntity.ok(apiResponse);
	}

	@RequestMapping(value = "/{salesId}")
	public ResponseEntity<ApiResponse> getSalesDetails(@PathVariable("salesId") long salesId) {
		ApiResponse apiResponse = null;
		SalesVo sales = salesService.findBySalesIdAndIsDeleted(salesId, 0);
		if (sales != null) {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.set("Content-Type", "application/json");
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<String> entity = new HttpEntity<String>(null, headers);
			
				ResponseEntity<ContactVo> responseBody = restTemplate.exchange("http://CONTACT-SERVICE/contact/" + sales.getContactId(),
						HttpMethod.GET, entity,ContactVo.class);
//			ResponseEntity<ServiceResponse> responseBody = restTemplate
//					.getForEntity("http://CONTACT-SERVICE/contact/" + sales.getContactId(), ServiceResponse.class);
			ContactVo contactResponse = responseBody.getBody();
			log.warning("responseBody  contact---->"+contactResponse);
//			log.warning("contact---->"+contactResponse.getResponse());
//			ModelMapper modelMapper = new ModelMapper();
//			
//			ContactVo contact = modelMapper.map(contactResponse.getResponse(), ContactVo.class);
			sales.setContactVo(responseBody.getBody());
			apiResponse = new ApiResponse(true, "Sales Details Found", sales);
		} else {
			apiResponse = new ApiResponse(false, "OOPs Sales not found", null);
		}
		return ResponseEntity.ok(apiResponse);

	}

}
