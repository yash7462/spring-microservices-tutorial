package com.sales.service;

import java.util.List;

import com.sales.modal.SalesVo;

public interface SalesService {
	SalesVo insertSales(SalesVo salesVo);

	List<SalesVo> findByIsDeletedOrderBySalesIdDesc(int isDeleted);

	SalesVo findBySalesIdAndIsDeleted(long salesId, int isDeleted);
}
