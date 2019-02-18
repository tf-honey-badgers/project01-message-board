package org.badgers.controller;

import java.util.List;

import javax.inject.Inject;

import org.badgers.domain.BoardVO;
import org.badgers.domain.Criteria;
import org.badgers.service.BoardServiceTJ;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board/tj")
public class BoardController_TJ {
	
	@Inject
	private BoardServiceTJ bs;
	
	

	@GetMapping("/list")
	public void BoardList( Model model) {
//		Criteria cri,
		List<BoardVO> list = null;
		
		try {
			list = bs.listAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("list", list);
	}
	
	@GetMapping("/register")
	public void register() {
		
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		try {
			bs.regist(board);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/board/tj/list";
	}
	
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("bno") Integer bno, @ModelAttribute("cri") Criteria cri, Model model) {
		
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		return null;
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Integer bno, @ModelAttribute("cri") Criteria cri, Model model) {
		
		return null;
	}
	
}
