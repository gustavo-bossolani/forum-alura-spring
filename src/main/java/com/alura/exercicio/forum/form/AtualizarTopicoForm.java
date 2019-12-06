package com.alura.exercicio.forum.form;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.alura.exercicio.forum.modelo.Topico;
import com.alura.exercicio.forum.repository.TopicoRepository;
import com.sun.istack.internal.NotNull;

public class AtualizarTopicoForm {

	@NotNull @NotEmpty
	private String titulo;
	
	@NotNull @NotEmpty @Size(min = 12, max = 130)
	private String mensagem;
	
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
	public Topico atualizar(Long id, TopicoRepository repository) {
		Topico topico = repository.getOne(id);
		topico.setTitulo(this.titulo);
		topico.setMensagem(this.mensagem);
		return topico;
	}
}
