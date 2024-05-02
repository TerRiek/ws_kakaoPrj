package com.example.kakaoPrj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public String login() {
		return "loginForm";

	}
}
