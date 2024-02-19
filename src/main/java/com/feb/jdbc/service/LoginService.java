package com.feb.jdbc.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.feb.jdbc.dao.LoginDao;
import com.feb.jdbc.entity.Member;
import com.feb.jdbc.util.Sha512Encoder;

@Service
public class LoginService {
	
	
	@Autowired
	LoginDao loginDao;
	
	public boolean login(HashMap<String , String> params) {
		String memberId = params.get("memberId");
		Member member = loginDao.login(memberId);
		
		if(ObjectUtils.isEmpty(member)) {
			return false;
		}
		String memberPw = member.getPasswd();
		
		Sha512Encoder encoder = Sha512Encoder.getInstance();
		String passwd = params.get("passwd");
		String encodeTxt = encoder.getSecurePassword(passwd);
		
		System.out.println(member);
		return StringUtils.pathEquals(memberPw, encodeTxt);
	}
	

	

}
