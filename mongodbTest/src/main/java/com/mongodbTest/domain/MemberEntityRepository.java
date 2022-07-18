package com.mongodbTest.domain;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface MemberEntityRepository extends MongoRepository<MemberEntity, Long>{

	Optional<MemberEntity> findByEmail(String email);

	Optional<MemberEntity> findByEmailAndIsDeletedAndIsSocial(String username, boolean b, boolean c);

	Optional<MemberEntity> findByEmailAndIsDeleted(String username, boolean b);
}
