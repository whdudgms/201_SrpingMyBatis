package com.feb.jdbc.dao;

import org.springframework.stereotype.Repository;

import com.feb.jdbc.entity.Member;

@Repository
public interface LoginDao {

	// 로그인하는 메서드 
	public Member login(String memberId) ;
}
