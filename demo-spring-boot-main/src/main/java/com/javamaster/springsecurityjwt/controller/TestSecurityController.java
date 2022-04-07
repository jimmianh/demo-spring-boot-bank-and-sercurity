package com.javamaster.springsecurityjwt.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestSecurityController {
//	 Cái này Ngọc Anh viết vào để test thôi
//	ai lấy bài nhớ xóa đi nhaaaa :>>

	@GetMapping("/admin/get")
	public String getAdmin() {
		return "Hi admin";
	}

	@GetMapping("/user/get")
	public String getUser() {
		return "Hi user";
	}

	@GetMapping("/user")
	@PreAuthorize("hasRole('ROLE_USER')")
	public String test() {
		return "trang user";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String adminTest() {
		return "trang admin";
	}
}
