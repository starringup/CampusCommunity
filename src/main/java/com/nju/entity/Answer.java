package com.nju.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "answer")
public class Answer extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long questionId;
	private String answererId;
	private String content;
	private boolean anonymous;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	public String getAnswererId() {
		return answererId;
	}
	public void setAnswererId(String answererId) {
		this.answererId = answererId;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public boolean isAnonymous() {
		return anonymous;
	}
	public void setAnonymous(boolean anonymous) {
		this.anonymous = anonymous;
	}
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"id\":");
		sb.append(id);
		sb.append(",");
		sb.append("\"questionId\":");
		sb.append(questionId);
		sb.append(",");
		sb.append("\"answererId\":");
		sb.append(answererId);
		sb.append(",");
		sb.append("\"content\":\"");
		sb.append(content);
		sb.append("\",");
		sb.append("\"anonymous\":");
		sb.append(anonymous);
		sb.append(",");
		sb.append(timeToString());
		sb.append("}");
		return sb.toString();
	}
}
