package com.nowon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nowon.domain.dto.MemberDTO;
import com.nowon.domain.entity.MemberEntity;
import com.nowon.domain.entity.MemberEntityRepository;
import com.nowon.security.MyRole;
import com.nowon.service.MemberService;

@Service
public class MemberServiceProsess implements MemberService {

	@Autowired
	MemberEntityRepository memRepo;
	
	@Autowired
	PasswordEncoder pe;
	
	@Override
	public void save(MemberDTO memberDTO) {
		memRepo.save(memberDTO.getDTO(pe)
				.addRole(MyRole.USER));
	}

	
}
