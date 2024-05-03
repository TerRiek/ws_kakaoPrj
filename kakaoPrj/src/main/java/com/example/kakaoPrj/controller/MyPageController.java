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
	
	
	@RequestMapping("/fromMeWrotenDetail")
	public String fromMeWrotenDetail(@RequestParam("nno") String nno, Model model) {
		model.addAttribute("dto", ndao.detailDao(nno));
		return "listDetail";
	}
	
	
	@RequestMapping("/mySelfDetail")
	public String mySelfDetail(HttpServletRequest request, Model model) {
		String nno = request.getParameter("nno");
		NoticeDto nDto = ndao.detailDao(nno);
		model.addAttribute("dto", nDto);
		return "listDetail";
	}
	
	
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
	
	@RequestMapping("/receiverWriteDetail")
	public String root(@RequestParam("nno") String nno, Model model) {
		NoticeDto dto = ndao.detailDao(nno);
		model.addAttribute("dto", dto);
		return "listDetail";
	}
	
	@RequestMapping("/deleteDetail")
	public String deleteDetail(@RequestParam("nno") String nno) {
		int result = ndao.deleteDao(nno);
		if(result == 1) {
			return "redirect:/list";
		}
		return "";
	}

	@RequestMapping("/updateDetail")
	public String updateDetail(@RequestParam("nno") String nno, @RequestParam("title") String title, @RequestParam("content") String content) {
		int result = ndao.updateDao(nno, title, content);
		if(result == 1) {
			return "redirect:/list";
		}
		return "";
	}
}
