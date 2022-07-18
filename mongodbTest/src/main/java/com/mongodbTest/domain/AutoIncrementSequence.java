package com.mongodbTest.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "auto_sequence")
public class AutoIncrementSequence {

	@Id
    private String id;
	
    private Long seq;
}
