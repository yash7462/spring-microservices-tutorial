package com.contact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.contact.config.ApiResponse;
import com.contact.modal.ContactVo;
import com.contact.service.ContactService;

import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	ContactService contactService;

	@RequestMapping(value = { "", "/" })
	public ResponseEntity<ApiResponse> getAllContact() {
		ApiResponse apiResponse = null;
		List<ContactVo> contactList = contactService.findByIsDeletedOrderByContactIdDesc(0);
		if (!contactList.isEmpty()) {
			apiResponse = new ApiResponse(true, contactList.size() + " Contacts Found", contactList);
		} else {
			apiResponse = new ApiResponse(false, "0 Contacts Found", null);
		}
		return ResponseEntity.ok(apiResponse);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<ApiResponse> insertContact(@RequestBody ContactVo contactVo) {
		ApiResponse apiResponse = null;
		ContactVo contact = contactService.insertContact(contactVo);
		if (contact != null) {
			apiResponse = new ApiResponse(true, "Contacts Inserted Successfully", contact);
		} else {
			apiResponse = new ApiResponse(false, "Something Went Wrong on saving Contact Details", null);
		}
		return ResponseEntity.ok(apiResponse);
	}

	/**
	 * 
	 * @param contactId
	 * @return
	 */
	@RequestMapping(value = "/{contactId}")
	public ContactVo getContactDetails(@PathVariable("contactId") long contactId) {
		ApiResponse apiResponse = null;
		ContactVo contact = contactService.findByContactIdAndIsDeletedOrderByContactIdDesc(contactId, 0);
		return contact;
//		if (contact != null) {
//			apiResponse = new ApiResponse(true, "Contact Details Found", contact);
//		} else {
//			apiResponse = new ApiResponse(false, "OOPs Contact not found", null);
//		}
//		return ResponseEntity.ok(apiResponse);

	}

	@RequestMapping(value = "/getSales")
	public Object getSalesDetails() {
		ResponseEntity<String> responseBody = restTemplate.getForEntity("http://SALES-SERVICE/sales", String.class);
		log.warning("response---status--->" + responseBody.getStatusCode());
		return responseBody.getBody();
	}
}
