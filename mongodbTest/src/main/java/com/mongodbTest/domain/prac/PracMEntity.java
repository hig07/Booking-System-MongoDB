package com.mongodbTest.domain.prac;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "prac_member")
public class PracMEntity {
	
	@Id
	private long id;

    private String email;

	private String pass;
	
	private String name; //connect prac_board writer

	@DBRef(lazy = true)
    private List<PracBEntity> pracBEntity;
}
