package com.nju.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nju.entity.AttentionUsers;

@Repository
public interface AttentionUsersRepository extends JpaRepository<AttentionUsers, Long>{
	
	@Query("select attentions from AttentionUsers attentions where attentions.attentionWeChatId = ?1")
	List<AttentionUsers> findAttentionsByWeChatId(String weChatId);
	
	@Query("select attention from AttentionUsers attention where attention.attentionWeChatId = ?1 and attention.attentionedWeChatId = ?2")
	AttentionUsers findOneByAttentionWeChatIdAndAttentionedWeChatId(String attentionWeChatId,String attentionedWeChatId);
}
