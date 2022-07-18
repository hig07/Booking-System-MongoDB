package com.mongodbTest.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

@Getter
public class MyUserDetails extends User{
	
	private String email;//User.username == email
	private String name; 
	/**
	 * 
	 * @param username : 로그인시 입력한 eamil 
	 * @param password : 비밀번호
	 * @param name     : 이름
	 * @param authorities : 권한
	 */
	public MyUserDetails(String username, String password,String name, Collection<? extends GrantedAuthority> authorities) {
		/*
		'Authentication(인증)' 개체에 부여된 권한을 나타냅니다. 'GrantedAuthority'은 스스로를 String으로 나타내거나 'AccessDecisionManager'가 특별히 지원해야 합니다.
		'GrantedAuthority(부여된 권한)'이 String으로 표현될 수 있고 String이 'AccessDecisionManager(접근의사 결정관리자)'(또는 위임자)의 접근 제어 결정에 의존하기에 충분한 정밀도인 경우, 
		이 방법은 이러한 String을 반환해야 한다. 'GrantedAuthority'를 String으로 충분히 정확하게 표현할 수 없는 경우 'null'을 반환해야 합니다. 
		'null'을 반환하려면 'AccessDecisionManager'(또는 대리자)가 'GrantedAuthority' 구현을 구체적으로 지원해야 하므로 실제로 필요하지 않은 한 'null'을 반환하지 않아야 합니다.
		return: 부여된 권한의 표현(또는 부여된 권한을 충분한 정밀도로 'String'으로 표현할 수 없는 경우 'null').
		*/
		super(username, password, authorities);
		email=username;
		this.name=name;
	}
}
