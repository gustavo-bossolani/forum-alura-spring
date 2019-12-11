package com.alura.exercicio.forum.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura.exercicio.forum.dto.CursoDto;
import com.alura.exercicio.forum.modelo.Curso;

@RestController
@RequestMapping("/cursos")
public class CursoController {

	@Autowired
	CursoRepository cursoRepository;
	
	@GetMapping
	@Transactional
	public Page<CursoDto> lista(
				@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10)
				Pageable paginacao){
		Page<Curso> cursos = cursoRepository.findAll(paginacao);
		return CursoDto.converter(cursos);
	}
}