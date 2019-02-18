package org.badgers.controller;

import org.badgers.domain.BoardVO;
import org.badgers.service.BoardServiceImpl_Yuriel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.Setter;

@Controller
public class BoardController_Yuriel {

	@Setter(onMethod_ = { @Autowired } )
	private BoardServiceImpl_Yuriel service;
	
  @RequestMapping("/insert/board")
  public String goInsert() {
     
     return "insert/board";
  }
  
  @RequestMapping("/insert/insert")
  public void insert(BoardVO board) {
     
     try {
		service.regist(board);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
}
