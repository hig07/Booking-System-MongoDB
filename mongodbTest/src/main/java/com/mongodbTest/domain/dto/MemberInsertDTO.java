package com.mongodbTest.domain.dto;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.mongodbTest.domain.MemberEntity;

import lombok.Setter;

@Setter
public class MemberInsertDTO {

	private String email;
	private String name;
	private String pass;
	private String userIp;
	
	public MemberInsertDTO passEncode(PasswordEncoder pe) {
		this.pass=pe.encode(pass);
		return this;
	}
	
	//입력받은 dto-> Member 엔티티에 매핑: Member 객체생성
	public MemberEntity toMember() {
		return MemberEntity.builder()
				.email(email).name(name).pass(pass).userIp(userIp)
				.build();
	}
}
