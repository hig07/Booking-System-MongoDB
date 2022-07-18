package com.mongodbTest.service.impl;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.mongodbTest.domain.BoardEntity;
import com.mongodbTest.domain.BoardEntityRepository;
import com.mongodbTest.domain.dto.BoardListDTO;
import com.mongodbTest.service.BoardService;
import com.mongodbTest.util.PageInfo;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardEntityRepository boardEntityRepository;

	@Override
	public void list(Model model, int pageNo) {
		int page = pageNo - 1;//zero-based page index
		int size = 10;//the size of the page to be returned
		
		Sort sort = Sort.by(Direction.DESC, "id");
		Pageable pageable = PageRequest.of(page, size, sort);

		Page<BoardEntity> pageObj = boardEntityRepository.findAll(pageable);
		
		int pageTotal = pageObj.getTotalPages();
		
		System.out.println(">>>>>>>>>>");
		
		PageInfo pageInfo = PageInfo.getInstance(pageNo, pageTotal);
		model.addAttribute("pi", pageInfo);
		model.addAttribute("list", pageObj.getContent().stream().map(BoardListDTO::new).collect(Collectors.toList()));		
	}

}
