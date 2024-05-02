package com.example.kakaoPrj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.kakaoPrj.dao.INoticeDao;
import com.example.kakaoPrj.dto.NoticeDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/my")
public class MyPageControllerA {
	
	@Autowired
	private INoticeDao ndao;
	

	@RequestMapping("/mySelf")
	public String getMySelf(HttpSession session, Model model) {
		String name = (String)session.getAttribute("name");
		model.addAttribute("list", ndao.getMySelf(name));
		
		return "mySelf";
	}
	
	@RequestMapping("/mySelfDetail")
	public String mySelfDetail(HttpServletRequest request, Model model) {
		String nno = request.getParameter("nno");
		NoticeDto dto = ndao.detailDao(nno);
		return "MySelfDetail";
	}
	
	
	@RequestMapping("/meMentioned")
	public String getMeMentioned(HttpSession session, Model model) {
		String name = (String)session.getAttribute("name");
		model.addAttribute("list", ndao.getMeMentioned(name));
		
		return "receiverWrite";
	}
	
}
