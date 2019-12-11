package com.alura.exercicio.forum.dto;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

import com.alura.exercicio.forum.modelo.Curso;

public class CursoDto {

	private Long id;
	private String categoria;
	private String nome;
	
	
	public CursoDto(Curso curso) {
		this.id = curso.getId();
		this.categoria = curso.getCategoria();
		this.nome = curso.getNome();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public static Page<CursoDto> converter(Page<Curso> cursos) {
		return cursos.map(CursoDto::new);
	}

}
