package com.javamaster.springsecurityjwt.DTO;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter

public class TransactionDTO {
	@NotBlank(message = "")
	private LocalDate transactionDate=LocalDate.now();
	@NotBlank
	private Long fromAccount;
	@NotBlank
	private Long toAccount;
	@NotBlank
	private Double amount;
	private int status;
	@Length(max =100,min = 15, message = "Nội dung giao dịch không vượt quá 100 ký tự!")
	private String content;
	private String errorReason;

}
