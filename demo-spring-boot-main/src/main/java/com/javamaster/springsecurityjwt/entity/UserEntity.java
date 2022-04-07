package com.javamaster.springsecurityjwt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "user_table")
@Data
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "login", nullable = false, unique = true)
	@Length(max = 100, min = 6)
	private String login;

	@Column
	private String password;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private RoleEntity roleEntity;
}
