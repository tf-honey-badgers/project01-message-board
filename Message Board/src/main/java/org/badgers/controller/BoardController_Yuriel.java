package org.badgers.controller;

import java.util.List;

import org.badgers.domain.BoardVO;
import org.badgers.domain.CriteriaImpl_Yuriel;
import org.badgers.domain.PagingDTO_Yuriel;
import org.badgers.service.BoardServiceImpl_Yuriel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
public class BoardController_Yuriel {

	@Setter(onMethod_ = { @Autowired } )
	private BoardServiceImpl_Yuriel service;
	
	@GetMapping("/listYuriel")
	public void list(CriteriaImpl_Yuriel cri, Model model) {
		log.info("listGET....................");
		List<BoardVO> list = null;
		
		try {
			list = service.listCriteria(cri);
			model.addAttribute("list", list);
			
			PagingDTO_Yuriel paging = new PagingDTO_Yuriel();
			paging.setCri(cri);
			paging.setTotalCount(service.listCount(cri));
			model.addAttribute("paging", paging);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "죄송합니다. 문제가 발생했는데 나중에 다시 접속해주세요.");
		}
	}
	
	@GetMapping("/registerYuriel")
	public void register() {
		log.info("registerGET...................");
	}
	@PostMapping("/registerYuriel")
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
		
		return "redirect:/board/listYuriel";
	}
	
	@GetMapping( {"/getYuriel", "/modifyYuriel" } )
	public void get(
				@RequestParam("bno") Integer bno, 
				@ModelAttribute("cri") CriteriaImpl_Yuriel cri, 
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
	
	@PostMapping("/modifyYuriel")
	public String modify (
				BoardVO board, 
				@ModelAttribute("cri") CriteriaImpl_Yuriel cri, 
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
		
		return "redirect:/board/listYuriel";
	}
	
	@PostMapping("/removeYuriel")
	public String remove(
				@RequestParam("bno") Integer bno,
				@ModelAttribute("cri") CriteriaImpl_Yuriel cri,
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
		
		return "redirect:/board/listYuriel";
	}
}