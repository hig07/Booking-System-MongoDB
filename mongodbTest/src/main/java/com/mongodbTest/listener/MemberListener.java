package com.mongodbTest.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.mongodbTest.domain.BoardEntity;
import com.mongodbTest.domain.MemberEntity;
import com.mongodbTest.service.SequenceGeneratorService;

@RequiredArgsConstructor
@Component
public class MemberListener extends AbstractMongoEventListener<MemberEntity> {

    private final SequenceGeneratorService generatorService;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<MemberEntity> event) {
        event.getSource().setId(generatorService.generateSequence(MemberEntity.SEQUENCE_NAME));
    }
    
}
