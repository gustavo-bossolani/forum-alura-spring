package com.alura.exercicio.forum.form;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.alura.exercicio.forum.controller.CursoRepository;
import com.alura.exercicio.forum.dto.CursoDto;
import com.alura.exercicio.forum.modelo.Curso;


public class CursoForm {

	@NotNull @NotEmpty
	private String categoria;
	
	@NotNull @NotEmpty
	private String nome;

	public String getCategoria() {
		return categoria;
	}

	public String getNome() {
		return nome;
	}

	public Curso converter(CursoRepository cursoRepository) {
		 Optional<Curso> optional = cursoRepository.findByNome(nome);
		 if(optional.isPresent()) {
				return null;
			}
		return new Curso(this.nome, this.categoria);
	}
}
