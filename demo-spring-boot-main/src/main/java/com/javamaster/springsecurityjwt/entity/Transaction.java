package com.javamaster.springsecurityjwt.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "`Transaction`", catalog = "demobank")
public class Transaction implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transactionId", unique = true, nullable = false)
	private Long transactionId;

	@Column(name = "transactionDate")
	private LocalDateTime transactionDate;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fromAccountId", referencedColumnName = "accountId")
	@NotNull
	private Account fromAccount;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "toAccountId", referencedColumnName = "accountId")
	@NotNull
	private Account toAccuont;

	@Column(name = "amount")
	@Length(min = 2)
	@NotNull
	private Double amount;

	@Column(name = "")
	private int status;

	@Column(name = "content")
	private String content;

	@Column(name = "errorReason")
	private String errorReason;

}
