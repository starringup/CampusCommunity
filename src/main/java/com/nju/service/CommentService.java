package com.nju.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nju.entity.Comment;
import com.nju.repository.CommentRepository;

@Service
public class CommentService {
	@Autowired
	private CommentRepository commentRepository;
	
	public boolean save(Comment comment){
		try{
			commentRepository.save(comment);
			return true;
		}catch(Exception exception){
			exception.printStackTrace();
			return false;
		}
	}
	
	public List<Comment> findCommentsByAnswerId(Long answerId){
		try{
			return commentRepository.findCommentsByAnswerId(answerId);
		}catch(Exception exception){
			exception.printStackTrace();
			return new ArrayList<Comment>();
		}
	}
}
