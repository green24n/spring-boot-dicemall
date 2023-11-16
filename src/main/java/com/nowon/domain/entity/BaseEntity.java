package com.nowon.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;

@Getter
@MappedSuperclass
public abstract class BaseEntity {

	@CreationTimestamp
	private LocalDateTime createDate; // 생성일
	@UpdateTimestamp
	private LocalDateTime updatedDate; // 수정일
}
