package com.example.kakaoPrj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class PrjController {

	@RequestMapping("/aaa")
	public @ResponseBody String root() {
		return "aaa";
	}
}
