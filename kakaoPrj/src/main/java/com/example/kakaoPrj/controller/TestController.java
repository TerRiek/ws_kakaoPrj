package com.example.kakaoPrj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.kakaoPrj.dao.INoticeDao;
import com.example.kakaoPrj.dto.MemberDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class TestController {
	
	@Autowired
	private INoticeDao ndao;
	
	@RequestMapping("/meMentioned")
	public String getMeMentioned(HttpSession session, Model model) {
		MemberDto dto = (MemberDto)session.getAttribute("dto");
		model.addAttribute("list", ndao.getMeMentioned(dto.getId()));
		
		return "receiverWrite";
	}
	
	@RequestMapping("/mySelf")
	public String getMySelf(Model model, HttpSession session) {
		MemberDto dto = (MemberDto)session.getAttribute("dto");
		model.addAttribute("list", ndao.getMySelf(dto.getId()));
		return "mySelf";
	}
	
	@RequestMapping("/fromMeWroten")
	public String fromMeWroten(HttpSession session, Model model) {
		MemberDto dto = (MemberDto)session.getAttribute("dto");
		model.addAttribute("list", ndao.getMeWroten(dto.getId()));
		return "fromMeWroten";
	}
}
