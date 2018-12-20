package com.nju.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "attentionquestions")
public class AttentionQuestions extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String attentionWeChatId;
	private Long questionId;
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getAttentionWeChatId() {
		return attentionWeChatId;
	}


	public void setAttentionWeChatId(String attentionWeChatId) {
		this.attentionWeChatId = attentionWeChatId;
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
		sb.append("\"attentionWeChatId\":");
		sb.append(attentionWeChatId);
		sb.append(",");
		sb.append("\"questionId\":");
		sb.append(questionId);
		sb.append(",");
		sb.append(timeToString());
		sb.append("}");
		return sb.toString();
	}
}
