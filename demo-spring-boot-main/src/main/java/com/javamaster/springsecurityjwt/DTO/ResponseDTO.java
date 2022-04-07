package com.javamaster.springsecurityjwt.DTO;

import lombok.Data;

@Data
public class ResponseDTO {
	private String code;
	private String massage;
	private Object data;

}
