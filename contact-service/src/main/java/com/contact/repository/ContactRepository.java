package com.contact.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contact.modal.ContactVo;

@Repository
public interface ContactRepository extends JpaRepository<ContactVo, Long>{

	List<ContactVo> findByIsDeletedOrderByContactIdDesc(int isDeleted);

	ContactVo findByContactIdAndIsDeletedOrderByContactIdDesc(long contactId, int isDeleted);

}
