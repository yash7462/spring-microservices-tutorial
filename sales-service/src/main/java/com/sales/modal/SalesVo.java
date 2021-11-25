package com.sales.modal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sales")
public class SalesVo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sales_id")
	public long salesId;

	@Column(name = "prefix")
	public String prefix;

	@Column(name = "sales_no", columnDefinition = "bigint default 0")
	public long salesNo;

	@Column(name = "contact_id", columnDefinition = "bigint default 0")
	public long contactId;

	@Transient
	public ContactVo contactVo;

	@Column(name = "total", columnDefinition = "double precision default 0")
	public double total;

	@Column(name = "service_name")
	public String serviceName;

	@Column(name = "is_deleted", length = 1, columnDefinition = "int default 0")
	public int isDeleted;

	@CreationTimestamp
	@Column(name = "created_on", updatable = false)
	public Date createdOn;

	@UpdateTimestamp
	@Column(name = "modified_on", updatable = false)
	public Date modifiedOn;

}
