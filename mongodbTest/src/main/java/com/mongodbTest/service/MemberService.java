package com.mongodbTest.service;

import javax.servlet.http.HttpServletRequest;

import com.mongodbTest.domain.dto.MemberInsertDTO;

public interface MemberService {

	String save(MemberInsertDTO dto, HttpServletRequest request);

}
