package com.contact.service;

import java.util.List;

import com.contact.modal.ContactVo;

public interface ContactService {
	public ContactVo insertContact(ContactVo contactVo);

	public List<ContactVo> findByIsDeletedOrderByContactIdDesc(int isDeleted);

	public ContactVo findByContactIdAndIsDeletedOrderByContactIdDesc(long contactId, int isDeleted);
}
