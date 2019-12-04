package com.alura.exercicio.forum.form;

import com.alura.exercicio.forum.controller.CursoRepository;
import com.alura.exercicio.forum.modelo.Curso;
import com.alura.exercicio.forum.modelo.Topico;

public class TopicoForm {

	private String titulo;
	private String mensagem;
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
		Curso curso = repository.findByNome(this.nomeCurso);
		return new Topico(titulo, mensagem, curso);
	}
}
