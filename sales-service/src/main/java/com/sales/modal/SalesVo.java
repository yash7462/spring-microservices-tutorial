package com.sales.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalesVo {
	public long salesId;
	public long salesNo;
	public ContactVo contactVo;
	public double total;
	public String serviceName;
}
