package com.nju.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nju.entity.Ask;

@Repository
public interface AskRepository extends JpaRepository<Ask, Long>{
	@Query("select ask from Ask ask where ask.askerWeChatId = ?1 and ask.questionId = ?2")
	Ask findAskByAskerWeChatIdAndQuestionId(String askerWeChatId,Long questionId);
}
