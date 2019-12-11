package com.alura.exercicio.forum.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.alura.exercicio.forum.dto.CursoDto;
import com.alura.exercicio.forum.form.CursoForm;
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
	
	@PostMapping
	@Transactional
	public ResponseEntity<CursoDto> cadastrar(@RequestBody @Valid CursoForm form, UriComponentsBuilder uriBuilder) {
		Curso curso = form.converter(cursoRepository);
		if(curso != null) {
			cursoRepository.save(curso);
			URI uri = uriBuilder.path("/cursos/{ id }").buildAndExpand(curso.getId()).toUri();
			return ResponseEntity.created(uri).body(new CursoDto(curso));
		}
		return ResponseEntity.badRequest().build();
	}
	
}
