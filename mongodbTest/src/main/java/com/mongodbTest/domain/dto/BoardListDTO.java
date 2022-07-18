package com.mongodbTest.domain.dto;

import java.time.LocalDateTime;

import com.mongodbTest.domain.BoardEntity;

import lombok.Getter;

@Getter
public class BoardListDTO {

	private long id;
	private String title;
	private int readCount;
//	private LocalDateTime updatedDate;
	
	public BoardListDTO(BoardEntity e) {
		id = e.getId();
		title = e.getTitle();
		readCount = e.getReadCount();
//		updatedDate = e.getUpdatedDate();
	}
}
