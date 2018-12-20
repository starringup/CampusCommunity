package com.nju.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nju.entity.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long>{
	
	@Query(value = "select * from answer where answer.answerer_id = ?1 order by answer.modify_time desc limit 0,1",nativeQuery = true)
	Answer findRecentAnswerByAnswererId(String answererId);
	
	@Query("select answer from Answer answer where answer.answererId = ?1")
	List<Answer> findAnswersByAnswererId(String answererId);
}
