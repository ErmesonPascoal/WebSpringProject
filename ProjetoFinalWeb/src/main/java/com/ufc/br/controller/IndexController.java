package com.ufc.br.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IndexController {
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/logar")
	public ModelAndView cadastrarse() {
		ModelAndView mv = new ModelAndView("logar");
		return mv;
	}
}
