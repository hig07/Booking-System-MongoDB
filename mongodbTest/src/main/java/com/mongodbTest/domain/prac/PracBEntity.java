package com.mongodbTest.domain.prac;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "prac_board")
public class PracBEntity {
	
	@Id
	private long id;

    private String title;

	private String content;
	
	private String writer; //connect prac_member name

	private Date createdDate;
	
	private Date updatedDate;
}
