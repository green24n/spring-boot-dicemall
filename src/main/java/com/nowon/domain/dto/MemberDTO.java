package com.nowon.domain.dto;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.nowon.domain.entity.MemberEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class MemberDTO {

	private String email;
	private String pass;
	private String name;
	private String phone;
	
	public MemberEntity getDTO(PasswordEncoder pe) {
		return MemberEntity.builder()
				.email(email)
				.pass(pe.encode(pass))
				.name(name)
				.phone(phone)
				.build();
	}
}
