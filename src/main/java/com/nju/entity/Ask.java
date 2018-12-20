package com.nju.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ask")
public class Ask extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String askerWeChatId;
	private Long questionId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAskerWeChatId() {
		return askerWeChatId;
	}
	public void setAskerWeChatId(String askerWeChatId) {
		this.askerWeChatId = askerWeChatId;
	}
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"id\":");
		sb.append(id);
		sb.append(",");
		sb.append("\"askerWeChatId\":");
		sb.append(askerWeChatId);
		sb.append(",");
		sb.append("\"questionId\":");
		sb.append(questionId);
		sb.append(",");
		sb.append(timeToString());
		sb.append("}");
		return sb.toString();
	}
}
