package com.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

	@GetMapping("contact-service-down")
	public String contactServiceDown() {
		return "Currently Contact Service Is Down!";
	}

	@GetMapping("sales-service-down")
	public String salesServiceDown() {
		return "Currently Sales Service Is Down!";
	}
}
