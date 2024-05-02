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
public class MyPageControllerB {
	
	@Autowired
	private INoticeDao ndao;
	
	@RequestMapping("/myPage")
	public String myPage(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		MemberDto dto = (MemberDto)session.getAttribute("dto");
		
		model.addAttribute("name", dto.getName());
		return "myPage";
	}
	
	@RequestMapping("/listDetail")
	public String listDetail(HttpServletRequest request, Model model) {
		String nno = request.getParameter("nno");
		model.addAttribute("dto", ndao.detailDao(nno));
		
		return "listDetail";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("dto");
		return "index";
	}
}
