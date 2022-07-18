package com.mongodbTest.util;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PageInfo {
	private int start;
	private int end;
	private int total;
	
	private void calcPage(int pageNo) {
		int pageBlock=5;//한번에 보이는 페이지번호 개수
		
		int blockNo=pageNo/pageBlock;
		if(pageNo%pageBlock != 0) blockNo++;
		//1/5,2/5,3/5,4/5,5/5
		// 0 ,0  ,0  , 0 , 1 : 1
		end=pageBlock*blockNo;
		start=end-pageBlock+1;
		
		if(end > total) end=total;
	}
	
	/**
	 * Mybatis인 경우 사용하세요
	 * @param pageNo 현실페이지번호 입력
	 * @param rowTotal DB의 총 레코드 수를 넣어 주세요. select count(*) from 테이블명
	 * @param limit 한 화면에 보여질 레코드 개수 지정하세요.
	 * @return PageInfo 객체생성됩니다.
	 */
	public static PageInfo getInstance(int pageNo, int rowTotal, int limit) {
		return new PageInfo(pageNo, rowTotal, limit);
	}
	private PageInfo(int pageNo, int rowTotal, int limit) {
		total=rowTotal/limit;
		if(rowTotal%limit > 0) total++;
		calcPage(pageNo);
	}
	
	/**
	 * JPA인 경우 사용하세요
	 * @param pageNo 현실페이지번호 입력
	 * @param pageTotal Page객체에서 계산된 결과 입력<br>
	 * 	<br>
	 * 	ex)<br>
	 * 	Page<JpaBoardEntity> pageObj=repository.findAll(pageable);<br>
	 *  int pageTotal=pageObj.getTotalPages();<br>
	 *  <br>
	 * @return PageInfo 객체생성됩니다.
	 */
	public static PageInfo getInstance(int pageNo, int pageTotal) {
		return new PageInfo(pageNo, pageTotal);
	}
	private PageInfo(int pageNo, int pageTotal) {
		total=pageTotal;
		calcPage(pageNo);		
	}
}
