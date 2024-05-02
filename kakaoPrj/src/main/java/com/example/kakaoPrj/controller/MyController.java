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
@RequestMapping("/my")
public class MyController {

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
			// id와 일치하는 member 테이블의 쿼리문을 가져와야함 하나만 가져와도 되므로 객체 형태도 ㄱㅊ
			// MemberDto getDto(String id);
			MemberDto memDto = mdao.getDto(id);
			
			// 그 dto 내에 있는 name을 가져와서 name을 session에 저장하기 --> ㅇㅇ님, 반갑습니다.
			// name을 게시글에서 writer로 사용해야함 즉, writer 파라미터의 value 값이 name
			// name을 writer의 파라미터로 설정하려면?
			// 파라미터 형태가 아니라 name을 String writer에 대입하는 방법을 이용하는건?
			// db에 올릴 때만 writer 변수로 대입하도록 한다면?
			
			//System.out.println(name);
			
			// name을 세션에 저장
			//session.setAttribute("name", name);

		}

		return "list";
	}
	
	//@RequestMapping("/list")
	public String list(@RequestParam ("writer") String writer, @RequestParam ("receiver") String receiver, Model model) {
		// notice의 모든 쿼리를 불러온 상태에서 List<NoticeDto> getList
		// list 내의 모든 receiver를 param으로 설정 --> 어떻게?
		// --> param으로 설정할게 아니라 list 내의 모든 receiver를 추출해서 (반복문)
		// receiver == writer 이거나, receiver == null, receiver == "" 인것만 출력해야함
		
		model.addAttribute("list", ndao.listDao(writer, receiver));
		return "list";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		String writer = "홍길동";
		String receiver = "";
		model.addAttribute("list", ndao.listDao(writer, receiver));
		return "list";
	}
	
}
