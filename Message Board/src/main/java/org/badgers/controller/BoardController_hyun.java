package org.badgers.controller;

import javax.inject.Inject;

import org.badgers.domain.BoardVO;
import org.badgers.service.BoardServiceImpl_hyun;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board/*")
public class BoardController_hyun {
	
	@Inject
	private BoardServiceImpl_hyun service;
	
	// 리스트 보여주기 
	@GetMapping("list_hyun")
	public String list(Model model) throws Exception {
		model.addAttribute("list", service.listAll());
		return "/board/list_hyun";
	}
	//
	@GetMapping("get_hyun")
	public String get(@RequestParam("bno")int bno , Model model) throws Exception {
		
		model.addAttribute("board", service.read(bno));
		return "/board/get_hyun";
	}
	
	
	@RequestMapping(value="/register_hyun", method=RequestMethod.GET)
	public String register() {
		return "/board/register_hyun";
	}
	
	@PostMapping("/register_hyun")
	public String register(BoardVO board, RedirectAttributes rttr) {
		try {
			service.regist(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/board/list_hyun";
	}
	
}
