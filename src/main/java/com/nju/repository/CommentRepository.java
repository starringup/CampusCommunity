package com.nju.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nju.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{
	@Query("select comment from Comment comment where comment.answerId = ?1")
	List<Comment> findCommentsByAnswerId(Long answerId);
}
