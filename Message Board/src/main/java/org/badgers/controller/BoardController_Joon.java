package org.badgers.controller;

import java.util.List;

import org.badgers.domain.BoardVO;
import org.badgers.domain.Criteria_Joon;
import org.badgers.domain.PageMaker_Joon;
import org.badgers.service.BoardService_Joon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Setter;

@Controller
@RequestMapping("/board")
public class BoardController_Joon {
	
	@Setter(onMethod_=@Autowired)
	private BoardService_Joon service;
	
	
	@RequestMapping("/listJoon/boardfix")
	@ResponseBody
	public String select(Integer bno, Model model) {
		
		System.out.println(bno);
		
		BoardVO board = service.read(bno);
		
		model.addAttribute("thisBoard", board);
		
		return "boardJoon/boardJoonwirtefix";
	}
	
	@RequestMapping("/listJoon/boardelete")
	@ResponseBody
	public int delete(Integer bno) {
		
		System.out.println(bno);
		
		return service.delete(bno);
	}
	
	@RequestMapping("/listJoon/boardinsert")
	@ResponseBody
	public int insert(BoardVO board) {
		
		return service.insert(board);
	}

	
	@RequestMapping("/listJoon")
	public String goBoard(Model model,@ModelAttribute("cri") Criteria_Joon cri) {
		
		List<BoardVO> list = service.getListWithPaging(cri);
		
		PageMaker_Joon pageMaker = new PageMaker_Joon();
		
		pageMaker.setCri(cri);
		Integer totalNum = service.getTotalCount(cri);
		pageMaker.setTotalCount(totalNum);
		
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("boardList", list);
		
		return "boardJoon/boardJoon";
	}
	
	@RequestMapping("/listJoon/boardJoonwrite")
	public String goWrite() {
		
		return "boardJoon/boardJoonwrite";
	}
}
