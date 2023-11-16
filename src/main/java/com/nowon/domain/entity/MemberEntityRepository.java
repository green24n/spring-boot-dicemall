package com.nowon.domain.entity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nowon.domain.dto.MemberDTO;

public interface MemberEntityRepository extends JpaRepository<MemberEntity, Long>{

	Optional<MemberEntity> findByEmail(String email);



}
