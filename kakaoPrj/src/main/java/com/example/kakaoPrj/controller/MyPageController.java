package com.example.kakaoPrj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.kakaoPrj.dao.IMemberDao;
import com.example.kakaoPrj.dao.INoticeDao;
import com.example.kakaoPrj.dto.MemberDto;
import com.example.kakaoPrj.dto.NoticeDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/my")
public class MyPageController {
	
	@Autowired
	private INoticeDao ndao;
	
	@Autowired
	private IMemberDao mdao;
	
	@RequestMapping("/fromMeWroten")
	public String fromMeWroten(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		MemberDto dto = (MemberDto)session.getAttribute("dto");
		model.addAttribute("list", ndao.getMeWroten(dto.getId()));
		return "fromMeWroten";
	}
	
	@RequestMapping("/fromMeWrotenDetail")
	public String fromMeWrotenDetail(@RequestParam("nno") String nno, Model model) {
		model.addAttribute("dto", ndao.detailDao(nno));
		return "MySelfDetail";
	}
	
	@RequestMapping("/mySelf")
	public String getMySelf(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberDto dto = (MemberDto)session.getAttribute("dto");
		model.addAttribute("list", ndao.getMySelf(dto.getId()));
		return "mySelf";
	}
	
	@RequestMapping("/mySelfDetail")
	public String mySelfDetail(HttpServletRequest request, Model model) {
		String nno = request.getParameter("nno");
		NoticeDto nDto = ndao.detailDao(nno);
		model.addAttribute("dto", nDto);
		return "MySelfDetail";
	}
	
	
	@RequestMapping("/meMentioned")
	public String getMeMentioned(HttpSession session, Model model) {
		String name = (String)session.getAttribute("name");
		model.addAttribute("list", ndao.getMeMentioned(name));
		
		return "receiverWrite";
	}
	
}
