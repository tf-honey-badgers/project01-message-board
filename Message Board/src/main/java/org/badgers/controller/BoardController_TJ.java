package org.badgers.controller;

import java.util.List;

import javax.inject.Inject;

import org.badgers.domain.BoardVO;
import org.badgers.domain.Criteria;
import org.badgers.domain.CriteriaTJ;
import org.badgers.domain.PageMaker;
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
	
	@Inject
	private PageMaker pageMaker;

	@GetMapping("/list") //게시판 페이지로 이동
	public void BoardList(CriteriaTJ cri, Model model) {
		
		System.out.println(cri);
		List<BoardVO> list = null;
		
		try {
			list = bs.listCriteria(cri);
		} catch (Exception e) {
			e.printStackTrace();
		}
		pageMaker.setCri(cri);
		System.out.println(pageMaker);
		model.addAttribute("list", list);
		model.addAttribute("cri", cri);
		model.addAttribute("pageMaker", pageMaker);
	}
	
	@GetMapping("/register") // 게시글 등록 폼으로 이동
	public void register() {
		
	}
	
	@PostMapping("/register") // 게시글 등록 처리
	public String register(BoardVO board, RedirectAttributes rttr) {
		try {
			bs.regist(board);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/board/tj/list?page=1&perPageNum=10";
	}
	
	@GetMapping({"/get","/modify"}) //get은 읽기만 한다, modify는 변경하는 폼으로 보내준다.
	public void get(@RequestParam("bno") Integer bno, @ModelAttribute("cri") CriteriaTJ cri, Model model) {
		//bno를 받아서
		BoardVO vo=null;
		try {
			vo=bs.read(bno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("vo", vo);
		//service를 호출해서
		//개별 board 객체를 받아서
		//보여주는 get이라는 뷰페이지로 이동시켜준다
	}
	
	@PostMapping("/modify") //게시글 수정 처리
	public String modify(BoardVO board, @ModelAttribute("cri") CriteriaTJ cri, RedirectAttributes rttr) {
		System.out.println("수정할 : "+ board);
		try {
			bs.modify(board);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
	@PostMapping("/remove") // 게시글 삭제 처리
	public String remove(@RequestParam("bno") Integer bno, @ModelAttribute("cri") CriteriaTJ cri, Model model) {
		try {
			bs.remove(bno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
}
