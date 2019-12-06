package com.alura.exercicio.forum.dto;

import java.time.LocalDateTime;

import com.alura.exercicio.forum.modelo.Resposta;

public class RespostaDto {

	private Long id;
	private String mensagem;
	private String autor;
	private Boolean solucao;
	private LocalDateTime dataCriacao;
	
	public RespostaDto(Resposta resposta) {
		this.id = resposta.getId();
		this.mensagem = resposta.getMensagem();
		this.autor = resposta.getAutor().getNome();
		this.solucao = resposta.getSolucao();
		this.dataCriacao = resposta.getDataCriacao();
	}
	
	public Long getId() {
		return id;
	}
	public String getMensagem() {
		return mensagem;
	}
	public String getAutor() {
		return autor;
	}
	public Boolean getSolucao() {
		return solucao;
	}
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
}
