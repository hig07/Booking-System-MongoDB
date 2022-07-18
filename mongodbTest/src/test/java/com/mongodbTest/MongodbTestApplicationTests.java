package com.mongodbTest;

import java.util.Date;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mongodbTest.domain.BoardEntity;
import com.mongodbTest.domain.BoardEntityRepository;
import com.mongodbTest.domain.MemberEntity;
import com.mongodbTest.domain.MemberEntityRepository;
import com.mongodbTest.domain.TimeZone;
import com.mongodbTest.domain.TimeZoneRepository;
import com.mongodbTest.domain.prac.PracBEntity;
import com.mongodbTest.domain.prac.PracBEntityRepository;
import com.mongodbTest.domain.prac.PracMEntity;
import com.mongodbTest.domain.prac.PracMEntityRepository;

@SpringBootTest
class MongodbTestApplicationTests {
	
	@Autowired
	MemberEntityRepository memberEntityRepository;
	
	@Autowired
	BoardEntityRepository boardEntityRepository;
	
	@Autowired
	TimeZoneRepository timeZoneRepository;
	
	//@Test
	void date데이터저장() {
		TimeZone timeZone = new TimeZone();
		
		timeZone.setTitle("today is : ");
		timeZone.setCreatedDate(new Date());
		
		timeZoneRepository.save(timeZone);
	}
		
	//@Test
	void 시퀀스데이터저장() {
		MemberEntity memberEntity = new MemberEntity();
		
		memberEntity.setEmail("이메일!");
		
		memberEntityRepository.save(memberEntity);
	}

	//@Test
	void 더미데이터입력테스트() {
		IntStream.rangeClosed(1, 10).forEach(i->{
			MemberEntity memberEntity=MemberEntity.builder()
					.email("test"+i+"@test.com")
					.build();
			memberEntityRepository.save(memberEntity);
		});
	}
	
	//@Test
	void board더미데이터입력테스트() {
		IntStream.rangeClosed(1, 5).forEach(i->{
			BoardEntity boardEntity = BoardEntity.builder()
					.title("게시글-"+i)
					.content("내용-"+i)
					.writer("작성자-"+i)					
					.build();
			boardEntityRepository.save(boardEntity);
		});
	}
	
	@Autowired
	PracMEntityRepository pracMEntityRepository;
	
	//@Test
	void prac_member더미데이터입력테스트() {
		IntStream.rangeClosed(1, 5).forEach(i->{
			PracMEntity pracMEntity = PracMEntity.builder()
					.id(i)
					.email("이메일-"+i)
					.pass("비번-"+i)
					.name("이름 -" + i)
					.build();
			pracMEntityRepository.save(pracMEntity);
		});
	}
	
	@Autowired
	PracBEntityRepository pracBEntityRepository;
	
	@Test
	void prac_board더미데이터입력테스트() {
		IntStream.rangeClosed(1, 3).forEach(i->{
			PracBEntity pracBEntity = PracBEntity.builder()
					.id(i)
					.title("게시글-"+i)
					.content("내용-"+i)
					.writer("이름-"+i)	
					.createdDate(new Date())
					.updatedDate(new Date())
					.build();
			pracBEntityRepository.save(pracBEntity);
		});
	}
}
