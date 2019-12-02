package com.alura.exercicio.forum.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura.exercicio.forum.dto.TopicoDTO;
import com.alura.exercicio.forum.modelo.Curso;
import com.alura.exercicio.forum.modelo.Topico;

@RestController
public class TopicosController {

	
	@RequestMapping("/topicos")
	public List<TopicoDTO> topicos(){
		List<Topico> topicos = new ArrayList<>();
		topicos.add(
				new Topico("Dúvida Spring", "Estou com dúvida em relação a live reload", 
									new Curso("Java com Spring", "Programação")));
		
		topicos.add(
				new Topico("Problema com HTTP", "Minha aplicação não roda", 
									new Curso("API com Java", "Programação")));
		
		return TopicoDTO.converter(topicos);
	}
}
