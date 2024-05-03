package com.example.kakaoPrj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.kakaoPrj.dao.IMemberDao;
import com.example.kakaoPrj.dto.MemberDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberControllerB {
	
	@Autowired
	private IMemberDao mdao;
	
	
	@RequestMapping("/mDetail")
	public String mDetail(HttpSession session, Model model) {
		MemberDto dto = (MemberDto)session.getAttribute("dto");
		model.addAttribute("dto", dto);
		
		return "mDetail";
	}
	
	@RequestMapping("/mDelete")
	public String mDelete(HttpServletRequest request) {
		String mno = request.getParameter("mno");
		mdao.deleteDto(mno);
		
		return "loginForm";
	}
	
	@RequestMapping("/mUpdate")
	public String mUpdate(HttpServletRequest request) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		MemberDto dto = new MemberDto("", id, pw, name);
		
		return "redirect:mDetail";
	}
}
