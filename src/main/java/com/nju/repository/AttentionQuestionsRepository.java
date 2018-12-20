package com.nju.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nju.entity.AttentionQuestions;
import com.nju.entity.Question;

@Repository
public interface AttentionQuestionsRepository extends JpaRepository<AttentionQuestions, Long>{
	@Query("select question from AttentionQuestions question where question.attentionWeChatId = ?1")
	List<AttentionQuestions> findQuestionsByAttentionWeChatId(String attentionWeChatId);
	
	@Query("select question from AttentionQuestions question where question.attentionWeChatId = ?1 and question.questionId = ?2")
	AttentionQuestions findAttentionQuestionByAttentionWeChatIdAndQuestionId(String attentionWeChatId,Long questionId);
}
