package com.nju.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
	@CreatedDate
	@Column(name = "create_time")
	private Date createTime;
	
	@LastModifiedDate
	@Column(name = "modify_time")
	private Date modifyTime;
	
	protected String timeToString(){
		return "\"create_time\":\"" + createTime + "\",\"modifyTime\":\"" + modifyTime + "\"";
	}
}
