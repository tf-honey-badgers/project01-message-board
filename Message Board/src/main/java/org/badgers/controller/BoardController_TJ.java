package org.badgers.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController_TJ {

	@RequestMapping("/tj/list")
	public List BoardList() {
		
		return null;
	}
}
