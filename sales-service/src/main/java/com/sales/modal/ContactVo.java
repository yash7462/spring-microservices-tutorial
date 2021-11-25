package com.sales.modal;

import java.util.Date;

import lombok.Data;

@Data
public class ContactVo {

	public long contactId;
	public String firstName;
	public String lastName;
	public int age;
	public int isDeleted;
	public Date createdOn;
	public Date modifiedOn;

}
