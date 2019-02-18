package org.badgers.controller;

import java.util.List;

import org.badgers.domain.BoardVO;
import org.badgers.domain.Criteria;
import org.badgers.service.BoardServiceImpl_Yuriel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
public class BoardController_Yuriel {

	@Setter(onMethod_ = { @Autowired } )
	private BoardServiceImpl_Yuriel service;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("listGET....................");
		List<BoardVO> list = null;
		
		try {
			list = service.listAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(list);
		model.addAttribute("list", list);
		
	}
	
	@GetMapping("/register")
	public void register() {
		log.info("registerGET...................");
	}
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("registerPOST...................");
		int result = 0;
		String message = "";
		
		try {
			result = service.regist(board);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(!(result>0)) {
			message = "새로운 게시글을 등록하는데 문제가 발생했습니다.";
		} else {
			message = "성공적으로 게시글을 등록했습니다.";
		}
		
		rttr.addFlashAttribute("message", message);
		
		return "redirect:/board/list";
	}
	
}
