package com.mongodbTest.security;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum MemberRole {
	
	USER("ROLE_USER", "회원"), //ordinal() : 0, name() : USER
	ADMIN("ROLE_ADMIN", "관리자");

	final String role;
	final String title;

}
