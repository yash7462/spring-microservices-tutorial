package com.contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contact.modal.ContactVo;
import com.contact.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	ContactRepository contactRepository;

	@Override
	public ContactVo insertContact(ContactVo contactVo) {
		return contactRepository.saveAndFlush(contactVo);
	}

	@Override
	public List<ContactVo> findByIsDeletedOrderByContactIdDesc(int isDeleted) {
		return contactRepository.findByIsDeletedOrderByContactIdDesc(isDeleted);
	}

	@Override
	public ContactVo findByContactIdAndIsDeletedOrderByContactIdDesc(long contactId, int isDeleted) {
		return contactRepository.findByContactIdAndIsDeletedOrderByContactIdDesc(contactId, isDeleted);
	}

}
