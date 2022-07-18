package com.mongodbTest.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BoardEntityRepository extends MongoRepository<BoardEntity, Long>{

}
