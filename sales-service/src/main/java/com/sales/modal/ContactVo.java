package com.sales.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactVo {
	public long contactId;
	public String firstName;
	public String lastName;
	public int age;

}
