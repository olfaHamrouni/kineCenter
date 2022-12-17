package com.kineCenter.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class User {
@Id
@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long user_id;
@Column(nullable = false, unique = true)
	private String username;
@Column(nullable = false)
	private String password;
@Column(nullable = false)
	private String nomPrenom;
@Column(nullable = false)
	private String email;
@Column(nullable = false, length = 8)
	private String tel;
@Column(nullable = false)
	private String role;
	private Boolean enabled;
}