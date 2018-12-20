package com.nju.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "question")
public class Question extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String title;
	@Column(nullable = true)
	private String details;
	@Column(nullable = false)
	private boolean isOpen;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	public boolean isOpen() {
		return isOpen;
	}
	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"id\":");
		sb.append(id);
		sb.append(",");
		sb.append("\"title\":");
		sb.append(title);
		sb.append(",");
		sb.append("\"details\":");
		sb.append(details);
		sb.append(",");
		sb.append("\"isOpen\":");
		sb.append(isOpen);
		sb.append(",");
		sb.append(timeToString());
		sb.append("}");
		return sb.toString();
	}
}
