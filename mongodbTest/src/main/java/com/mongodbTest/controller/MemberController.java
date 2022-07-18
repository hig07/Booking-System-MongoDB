package com.mongodbTest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mongodbTest.domain.dto.MemberInsertDTO;
import com.mongodbTest.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MemberController {

	private final MemberService service;
	
	@GetMapping("/sign/signup")
	public String signup() {
		return "/sign/signup";
	}
	
	@PostMapping("/sign/signup")
	public String signup(MemberInsertDTO dto, HttpServletRequest request) {
		return service.save(dto, request);
	}
	
	@GetMapping("/sign/signin")
	public String signin() {
		return "/sign/signin";
	}
}
/*
클라이언트에서 서버로 필요한 데이터를 요청하기 위해 JSON 데이터를 요청 본문에 담아서 서버로 보내면, 
서버에서는 @RequestBody 어노테이션을 사용하여 HTTP 요청 본문에 담긴 값들을 자바객체로 변환시켜, 
객체에 저장한다.
 
서버에서 클라이언트로 응답 데이터를 전송하기 위해 
@ResponseBody 어노테이션을 사용하여 자바 객체를 HTTP 응답 본문의 객체로 변환하여 클라이언트로 전송한다. 

*/