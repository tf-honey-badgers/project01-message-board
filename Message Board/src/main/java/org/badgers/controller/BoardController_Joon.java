package org.badgers.controller;

import java.util.List;

import org.badgers.domain.BoardVO;
import org.badgers.domain.Criteria_Joon;
import org.badgers.domain.PageMaker_Joon;
import org.badgers.service.BoardServiceImple_Joon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Setter;

@Controller
@RequestMapping("/board")
public class BoardController_Joon {
	
	@Setter(onMethod_=@Autowired)
	private BoardServiceImple_Joon service;
	
	
	@RequestMapping("/listJoon/boardupdate")
	@ResponseBody
	public int update(BoardVO board) {
		
		try {
			return service.modify(board);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@RequestMapping("/listJoon/boardfix")
	public String select(Integer bno, Model model) {
		
		System.out.println(bno);
		
		try {
			BoardVO board = service.read(bno);
			model.addAttribute("thisBoard", board);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "boardJoon/boardJoonfix";
	}
	
	@RequestMapping("/listJoon/boardelete")
	@ResponseBody
	public int delete(Integer bno) {
		
		System.out.println(bno);
		
		try {
			return service.remove(bno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@RequestMapping("/listJoon/boardinsert")
	@ResponseBody
	public int insert(BoardVO board) {
		
		try {
			return service.regist(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	@RequestMapping("/listJoon")
	public String goBoard(Model model,Criteria_Joon cri,@RequestParam("page") int page,
			@RequestParam("perPageNum") int pageNum) {
		
		cri.setPage(page);
		cri.setPerPageNum(pageNum);

		try {
			List<BoardVO> list = service.listCriteria(cri);
			PageMaker_Joon pageMaker = new PageMaker_Joon();
			pageMaker.setCri(cri);
			Integer totalNum = service.listCount(cri);
			pageMaker.setTotalCount(totalNum);
			
			model.addAttribute("pageMaker", pageMaker);
			model.addAttribute("boardList", list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "boardJoon/boardJoon";
	}
	
	@RequestMapping("/listJoon/boardJoonwrite")
	public String goWrite() {
		
		return "boardJoon/boardJoonwrite";
	}

}
