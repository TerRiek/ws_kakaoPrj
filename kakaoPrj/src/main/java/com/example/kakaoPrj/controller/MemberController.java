package com.example.kakaoPrj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.kakaoPrj.dao.IMemberDao;
import com.example.kakaoPrj.dto.MemberDto;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MemberController {
	
	@Autowired
	private IMemberDao mdao;
	
	@RequestMapping("/regForm")
	public String regForm() {
		
		return "regForm";
	}
	
	@RequestMapping("/regist")
	public String regDto(HttpServletRequest request) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		MemberDto dto = new MemberDto("", id, pw, name);
		mdao.regDto(dto);
		
		return "loginForm";
	}
	
	@RequestMapping("/mDetail")
	public String mDetail(HttpServletRequest request, Model model) {
		String mno = request.getParameter("mno");
		model.addAttribute("dto", mdao.detailDto(mno));
		
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
