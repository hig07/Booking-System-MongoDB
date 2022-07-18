package com.mongodbTest.service;

import org.springframework.ui.Model;

public interface BoardService {

	void list(Model model, int pageNo);

}
