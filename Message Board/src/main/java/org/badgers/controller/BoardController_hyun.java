package org.badgers.controller;

import java.util.List;

import org.badgers.domain.BoardVO;
import org.badgers.domain.CriteriaImpl_hyun;
import org.badgers.domain.PageDTO_hyun;
import org.badgers.service.BoardServiceImpl_hyun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
public class BoardController_hyun {

	@Setter(onMethod_ = { @Autowired })
	private BoardServiceImpl_hyun service;

	/*
	 * @GetMapping("/list_hyun") public String list(Model model) throws Exception {
	 * model.addAttribute("list", service.listAll()); return "/board/list_hyun"; }
	 */

	@GetMapping("/list_hyun") // 게시판 리스트로 이동하기
	public void list(CriteriaImpl_hyun cri, Model model) {
		 log.info("listGET....................");
		List<BoardVO> list = null;
		try {
			list = service.listCriteria(cri);
			model.addAttribute("list", list);

			PageDTO_hyun paging = new PageDTO_hyun();
			paging.setCri(cri);
			paging.setTotalCount(service.listCount(cri));
			model.addAttribute("paging", paging);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "낚 낚 ~~~~~~~~~~~~~~~~~~~~~~~.");
		}
	}


	// 이동
	@RequestMapping(value = "/register_hyun", method = RequestMethod.GET)
	public String register() {
		return "/board/register_hyun";
	}
	// 게시글 처리 
	@PostMapping("/register_hyun")
	public String register(BoardVO board, RedirectAttributes rttr) {
		try {
			service.regist(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/board/list_hyun";
	}

	// 읽어주기
	@GetMapping( {"/get_hyun", "/modify_hyun" } )
	public void get(
				@RequestParam("bno") Integer bno, 
				@ModelAttribute("cri") CriteriaImpl_hyun cri, 
				Model model
			) {
		BoardVO readVo = null;
		
		try {
			readVo = service.read(bno);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("read", readVo);
	}

	
		// 수정하기 
	@PostMapping("/modify_hyun")
	public String modify (
				BoardVO board, 
				@ModelAttribute("cri") CriteriaImpl_hyun cri, 
				RedirectAttributes rttr
			) {
		int result = 0;
		List<BoardVO> list = null;
		
		try {
			result = service.modify(board);
			
			if(result == 1) {
				list = service.listCriteria(cri);		
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		rttr.addFlashAttribute("list", list);	
		
		return "redirect:/board/list_hyun";
	}
	
	@PostMapping("/remove")
	public String remove(
				@RequestParam("bno") Integer bno,
				@ModelAttribute("cri") CriteriaImpl_hyun cri,
				RedirectAttributes rttr
			) {
		int result = 0;
		List<BoardVO> list = null;
		
		try {
			result = service.remove(bno);
			
			if(result == 1) {
				list = service.listCriteria(cri);		
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		rttr.addFlashAttribute("list", list);
		
		return "redirect:/board/list_hyun";
	}
	
	
	
	
	
	
	

}
