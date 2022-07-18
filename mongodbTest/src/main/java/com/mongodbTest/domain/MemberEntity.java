package com.mongodbTest.domain;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodbTest.security.MemberRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "member")
public class MemberEntity {
	
	@Transient
	public static final String SEQUENCE_NAME = "member_sequence";
	
	@Id
	private long id;

    private String email;

	private String pass;

	private String name;
	
	private String userIp;

	private boolean isDeleted;//default:false 탈퇴여부 //true:탈퇴신청한회원
	
	private boolean isSocial;

    @Builder.Default
	private Set<MemberRole> roleSet=new HashSet<>();
    
    public MemberEntity addRole(MemberRole role) {
		roleSet.add(role);
		return this;
	}
	public MemberEntity removeRole(MemberRole role) {
		roleSet.remove(role);
		return this;
	}
}
