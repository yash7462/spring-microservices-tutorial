package com.sales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.modal.SalesVo;
import com.sales.repository.SalesRepository;

@Service
public class SalesServiceImpl implements SalesService {
	@Autowired
	SalesRepository salesRepository;

	@Override
	public SalesVo insertSales(SalesVo salesVo) {
		// TODO Auto-generated method stub
		return salesRepository.save(salesVo);
	}

	@Override
	public List<SalesVo> findByIsDeletedOrderBySalesIdDesc(int isDeleted) {
		// TODO Auto-generated method stub
		return salesRepository.findByIsDeletedOrderBySalesIdDesc(isDeleted);
	}

	@Override
	public SalesVo findBySalesIdAndIsDeleted(long salesId, int isDeleted) {
		// TODO Auto-generated method stub
		return salesRepository.findBySalesIdAndIsDeleted(salesId, isDeleted);
	}

}
