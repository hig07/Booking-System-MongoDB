package com.mongodbTest.listener;

import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.mongodbTest.domain.BoardEntity;
import com.mongodbTest.service.SequenceGeneratorService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class BoardListener extends AbstractMongoEventListener<BoardEntity>{

	private final SequenceGeneratorService generatorService;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<BoardEntity> event) {
        event.getSource().setId(generatorService.generateSequence(BoardEntity.SEQUENCE_NAME));
    }
}
