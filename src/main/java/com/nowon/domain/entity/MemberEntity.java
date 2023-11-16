package com.nowon.domain.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.nowon.domain.dto.MemberDTO;
import com.nowon.domain.entity.MemberEntity;
import com.nowon.security.MyRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@SequenceGenerator(name = "gen_seq_memb", sequenceName = "seq_memb", initialValue = 1, allocationSize = 1)
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dicemall_member")

public class MemberEntity {
	
	@Id @GeneratedValue(generator = "gen_seq_memb", strategy = GenerationType.SEQUENCE)
	private long no;

	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String pass;
	
	@Column(nullable = false)
	private String phone;
	
	@Column(nullable = false)
	private String name;
	
	@Builder.Default
	@Enumerated(EnumType.STRING) 
	@CollectionTable(name = "role")
	@ElementCollection(fetch = FetchType.EAGER) 
	private Set<MyRole> roles=new HashSet<>();
	public MemberEntity addRole(MyRole role) {
		roles.add(role);
		return this;
	}
	
	public MemberEntity saveSignup(MemberDTO memberDTO) {
		this.email = memberDTO.getEmail();
		this.pass = memberDTO.getPass();
		this.name = memberDTO.getName();
		this.phone = memberDTO.getPhone();
		return this;
	}
	
	
}
