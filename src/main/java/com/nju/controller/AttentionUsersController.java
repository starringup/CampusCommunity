package com.nju.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nju.entity.AttentionUsers;
import com.nju.service.AttentionUsersService;

@RestController
@RequestMapping("/attentionUsers")
public class AttentionUsersController {
	@Autowired
	private AttentionUsersService attentionUsersService;
	
	@RequestMapping("/{attentionWeChatId}/{attentionedWeChatId}")
	public String attention(@PathVariable String attentionWeChatId,@PathVariable String attentionedWeChatId){
		if(attentionUsersService.findOneByAttentionWeChatIdAndAttentionedWeChatId(attentionWeChatId, attentionedWeChatId) != null){
			return "successful";
		}
		AttentionUsers attentionUsers = new AttentionUsers();
		attentionUsers.setAttentionWeChatId(attentionWeChatId);
		attentionUsers.setAttentionedWeChatId(attentionedWeChatId);
		if(attentionUsersService.save(attentionUsers)){
			return "successful";
		}else{
			return "failed";
		}
	}
}
