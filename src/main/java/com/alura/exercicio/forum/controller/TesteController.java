package com.alura.exercicio.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TesteController {

	@RequestMapping("/")
	@ResponseBody
	public String olaMundo() {
		return "Olá Mundo Spring Boot";
	}
	
}
