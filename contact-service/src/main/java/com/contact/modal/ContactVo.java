package com.contact.modal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contact")
public class ContactVo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contact_id")
	public long contactId;

	@Column(name = "first_name")
	public String firstName;

	@Column(name = "last_name")
	public String lastName;

	@Column(name = "age", columnDefinition = "int default 0")
	public int age;

	@Column(name = "is_deleted", length = 1, columnDefinition = "int default 0")
	public int isDeleted;

	@CreationTimestamp
	@Column(name = "created_on", updatable = false)
	public Date createdOn;

	@UpdateTimestamp
	@Column(name = "modified_on", updatable = false)
	public Date modifiedOn;

}
