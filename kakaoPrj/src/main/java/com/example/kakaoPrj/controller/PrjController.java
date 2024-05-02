package com.example.kakaoPrj.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.kakaoPrj.dao.IMemberDao;
import com.example.kakaoPrj.dao.INoticeDao;


import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class PrjController {

	@Autowired
	private IMemberDao mdao;
	
	@Autowired
	private INoticeDao ndao;
	
	@RequestMapping("/")
	public String root() {
		return "index";
	}
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "loginForm";

	}
	
	@RequestMapping("/login")
	public String login(Model model) {
		return "list";
	}
	
	// @RequestMapping("/list")
	public String list(@RequestParam ("writer") String writer, @RequestParam ("receiver") String receiver, Model model) {
		model.addAttribute("list", ndao.listDao(writer, receiver));
		return "list";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		String writer = "aaa";
		String receiver = "aaa";
		model.addAttribute("list", ndao.listDao(writer, receiver));
		return "list";
	}
	
}
