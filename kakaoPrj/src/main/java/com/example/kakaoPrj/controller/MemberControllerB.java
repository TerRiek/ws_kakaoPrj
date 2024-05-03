package com.example.kakaoPrj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String mUpdate(HttpServletRequest request, @RequestParam("pw") String pw, @RequestParam("name") String name) {
		HttpSession session = request.getSession();
		MemberDto dto2 = (MemberDto)session.getAttribute("dto");
		MemberDto dto = new MemberDto(dto2.getMno(), "", pw, name);
		mdao.updateDto(dto);
		
		return "redirect:list";
	}
}
