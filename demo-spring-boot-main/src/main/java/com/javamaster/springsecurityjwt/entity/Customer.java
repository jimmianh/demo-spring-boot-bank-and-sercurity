package com.javamaster.springsecurityjwt.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Customer", catalog = "demobank")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customerId", unique = true, nullable = false)
	private Long customerId;

	@Column(name = "customerName", nullable = false, length = 50, unique = true)
	@Length(max = 100, min = 6)
	private String customerName;

	@Column(name = "birthday")
	private LocalDateTime birthday;

	@Column(name = "address", length = 10, unique = true)
	private String address;

	@Column(name = "identityNo" ,unique = true)
	@Length(max = 10,min = 9)
	private String identityNo;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "`customertype`", nullable = false)
	private CustomerType customertype = CustomerType.CORPORATE;

	@Column(name = "status")
	private int status;

	@Column(name = "createDatetime")
	private LocalDateTime createDatetime=LocalDateTime.now();

	@Column(name = "updateDatetime")
	private LocalDateTime updateDatetime=LocalDateTime.now();
	
	

}
