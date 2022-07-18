package com.mongodbTest.domain.prac;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface PracMEntityRepository extends MongoRepository<PracMEntity, String>{

	PracMEntity findByName(String name);
}
