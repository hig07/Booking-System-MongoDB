package com.mongodbTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mongodbTest.service.BoardService;


@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board/list")
	public String list(Model model, @RequestParam(defaultValue = "1")  int pageNo) {
		
		boardService.list(model, pageNo);
		return "/board/list";
	}
	
	@PostMapping("/board/write")
	public String write() {
		return "/board/write";
	}
}
