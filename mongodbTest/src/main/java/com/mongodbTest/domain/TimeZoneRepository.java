package com.mongodbTest.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TimeZoneRepository extends MongoRepository<TimeZone, String> {

}
