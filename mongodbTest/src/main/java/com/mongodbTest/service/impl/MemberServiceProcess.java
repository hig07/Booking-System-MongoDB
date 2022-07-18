package com.mongodbTest.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mongodbTest.domain.MemberEntityRepository;
import com.mongodbTest.domain.dto.MemberInsertDTO;
import com.mongodbTest.security.MemberRole;
import com.mongodbTest.service.MemberService;



@Service
public class MemberServiceProcess implements MemberService{

	@Autowired
	private MemberEntityRepository repository;
	
	@Autowired
	PasswordEncoder pe;
	
	@Override
	public String save(MemberInsertDTO dto, HttpServletRequest request) {
		dto.passEncode(pe);
		dto.setUserIp(request.getRemoteAddr());//프록시서버(카페24) 또는 로드 밸런스를 통해 서버에 접속한경우 127.0.0.1
		
		//user롤 적용회원가입
		repository.save(dto.toMember().addRole(MemberRole.USER));
		return "redirect:/sign/signin";
	}

}
