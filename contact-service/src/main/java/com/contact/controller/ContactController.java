package com.contact.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.contact.modal.ContactVo;

import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = { "", "/" })
	public List<ContactVo> getAllContact() {
		List<ContactVo> contactList = new ArrayList<>();
		contactList.add(new ContactVo(1L, "YASH", "PATEL", 22));
		contactList.add(new ContactVo(2L, "ABHISHEK", "CHAUHAN", 23));
		contactList.add(new ContactVo(3L, "DEVAND", "PRAJAPATI", 23));
		contactList.add(new ContactVo(4L, "BHARGAV", "PRAJAPATI", 23));
		contactList.add(new ContactVo(5L, "URVICH", "MEVADA", 25));
		contactList.add(new ContactVo(6L, "HARSH", "PITHADIYA", 22));
		return contactList;
	}

	@RequestMapping(value = "/{contactId}")
	public ContactVo getContactDetails(@PathVariable("contactId") long contactId) {
		return new ContactVo(1L, "YASH", "PATEL", 22);
	}

	@RequestMapping(value = "/getSales")
	public Object getSalesDetails() {
		ResponseEntity<String> responseBody = restTemplate.getForEntity("http://SALES-SERVICE/sales",
				String.class);
		log.warning("response---status--->" + responseBody.getStatusCode());
		return responseBody.getBody();
	}
}
