package com.sales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sales.modal.SalesVo;

@Repository
public interface SalesRepository extends JpaRepository<SalesVo, Long> {
	List<SalesVo> findByIsDeletedOrderBySalesIdDesc(int isDeleted);

	SalesVo findBySalesIdAndIsDeleted(long salesId, int isDeleted);

}
