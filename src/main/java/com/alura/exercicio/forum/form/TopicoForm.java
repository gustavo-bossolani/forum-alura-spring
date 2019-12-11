package com.alura.exercicio.forum.form;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.alura.exercicio.forum.controller.CursoRepository;
import com.alura.exercicio.forum.modelo.Curso;
import com.alura.exercicio.forum.modelo.Topico;
import com.sun.istack.internal.NotNull;

public class TopicoForm {

	@NotNull @NotEmpty
	private String titulo;
	
	@NotNull @NotEmpty @Size(min = 12, max = 130)
	private String mensagem;
	
	@NotNull @NotEmpty
	private String nomeCurso;
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String cursoNome) {
		this.nomeCurso = cursoNome;
	}
	
	public Topico converter(CursoRepository repository) {
		Optional<Curso> optional = repository.findByNome(this.nomeCurso);
		if(optional.isPresent()) {
			Curso curso = optional.get();
			return new Topico(titulo, mensagem, curso);
		}
		return null;
	}
}
