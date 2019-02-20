package org.badgers.controller;

import javax.inject.Inject;

import org.badgers.domain.BoardVO;
import org.badgers.domain.Criteria;
import org.badgers.domain.Criteria_yuni;
import org.badgers.domain.PageMaker_yuni;
import org.badgers.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.Getter;
import lombok.extern.log4j.Log4j;

@RequestMapping("/board/*")
@Controller
@Log4j
public class BoardController_yuni {

	@Inject
	private BoardService service;

	@RequestMapping("listYuni")
	public String list(Model model) throws Exception {
		model.addAttribute("list", service.listAll());
		return "/board/listYuni";
	}
	
	@GetMapping("get")
	public String get(@RequestParam("bno")int bno , Model model) throws Exception {
		
		model.addAttribute("board", service.read(bno));
		return "/board/getYuni";
	}
	
	@GetMapping("modify")
	public String modifyGet (@RequestParam("bno")int bno , Model model) throws Exception {
		model.addAttribute("board", service.read(bno));
		return "/board/modifyYuni";
		
	}
	@PostMapping("modifypost")
	public String modifyPost(BoardVO board) throws Exception {
		service.modify(board);
		log.info(board.getTitle());
		return	"redirect:/board/listYuni";
		
	}
	
	@PostMapping("remove")
	public String remove (@RequestParam("bno")int bno) throws Exception {
		service.remove(bno);
		
		return "redirect:/board/listYuni";
		
	}
	
	@GetMapping("listPage")
	public void listPage(Criteria_yuni cri, Model model, @RequestParam("page")int page) throws Exception {
		System.out.println(page);
		cri.setPage(page);
		cri.setPageStart(1);
	
		System.out.println(" ....................."+cri.getPage());
		System.out.println(" ....................."+cri.getPageStart());
		
		model.addAttribute("list", service.listCriteria(cri));
		
		PageMaker_yuni pageMaker= new PageMaker_yuni();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listAll().size());
		System.out.println(" ....................."+pageMaker.getStartPage());
		System.out.println(" ....................."+pageMaker.getEndPage());
		System.out.println(" ....................."+pageMaker.getTotalCount());
		
		model.addAttribute("pageMaker",pageMaker);
		
		
	}

}
