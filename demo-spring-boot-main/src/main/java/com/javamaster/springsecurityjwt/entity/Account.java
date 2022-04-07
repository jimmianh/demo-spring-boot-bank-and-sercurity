package com.javamaster.springsecurityjwt.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Account", catalog = "demobank")
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "accountId", unique = true, nullable = false)
	private Long accountId;

	@Column(name = "accountNumber", nullable = false, unique = true)
	@NotNull
	private String accountNumber;

	@ManyToOne
	@JoinColumn(name = "customerId", referencedColumnName = "customerId")
	private Customer customer;

	@Column(name = "balance")
	private Double balance;

	@Column(name = "status")
	@NotNull
	private int status;

	@Column(name = "create_datetime")
	private LocalDateTime create_datetime = LocalDateTime.now();

	@Column(name = "update_datetime")
	private LocalDateTime update_datetime = LocalDateTime.now();

}
