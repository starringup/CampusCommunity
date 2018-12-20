package com.nju.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nju.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{
	@Query("select q from Question q where q.id = ?1")
	Question findQuestionById(Long id);
	
}
