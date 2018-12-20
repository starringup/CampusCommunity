package com.nju.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "user")
public class User extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(length = 128,unique = true)
	private String weChatId;
	@Column(length = 1024)
	private String name;
	@Column(length = 10240)
	private String headPortraitUrl;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getWeChatId() {
		return weChatId;
	}
	public void setWeChatId(String weChatId) {
		this.weChatId = weChatId;
	}
	public String getHeadPortraitUrl() {
		return headPortraitUrl;
	}
	public void setHeadPortraitUrl(String headPortraitUrl) {
		this.headPortraitUrl = headPortraitUrl;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"id\":");
		sb.append(id);
		sb.append(",");
		sb.append("\"weChatId\":");
		sb.append(weChatId);
		sb.append(",");
		sb.append("\"name\":");
		sb.append(name);
		sb.append(",");
		sb.append("\"headPortraitUrl\":");
		sb.append(headPortraitUrl);
		sb.append(",");
		sb.append(timeToString());
		sb.append("}");
		return sb.toString();
	}
}
