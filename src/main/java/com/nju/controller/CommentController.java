package com.nju.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nju.entity.Comment;
import com.nju.service.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value = "/publishComment",method = RequestMethod.POST)
	public String publishComment(@RequestParam(value = "answerId",required = true) Long answerId,
								@RequestParam(value = "content",required = true) String content,
								@RequestParam(value = "parentCommentId",required = true) Long parentCommentId){
		Comment comment = new Comment();
		comment.setAnswerId(answerId);
		comment.setContent(content);
		comment.setParentCommentId(parentCommentId);
		if(commentService.save(comment)){
			return "successful";
		}else{
			return "false";
		}
	}
}
