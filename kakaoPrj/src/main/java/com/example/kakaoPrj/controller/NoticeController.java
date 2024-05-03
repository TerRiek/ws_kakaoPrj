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
import com.example.kakaoPrj.dto.MemberDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class NoticeController {

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
	public String login(@RequestParam("id") String id, @RequestParam("pw") String pw , HttpServletRequest request) {
		int result = mdao.loginCheck(id, pw);
		System.out.println(result);
		
		HttpSession session = request.getSession();
		
		if(result == 1) {			
			MemberDto dto = mdao.getDto(id);
			
			session.setAttribute("dto", dto);

		}else {
			return "index";
		}

		return "redirect:list";
	}

	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		MemberDto dto = (MemberDto)session.getAttribute("dto");
		
		String id = dto.getId();
		
		model.addAttribute("name", dto.getName());
		model.addAttribute("list", ndao.listDao(id));
		return "list";
	}
	
}
