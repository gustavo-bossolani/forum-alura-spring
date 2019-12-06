package com.alura.exercicio.forum.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.alura.exercicio.forum.modelo.Resposta;
import com.alura.exercicio.forum.modelo.StatusTopico;
import com.alura.exercicio.forum.modelo.Topico;

public class DetalheTopicoDto {

	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;
	private StatusTopico status;
	private String nomeAutor;
	private List<RespostaDto> respostas; 
	
	public DetalheTopicoDto(Topico topico) {
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.dataCriacao = topico.getDataCriacao();
		this.status = topico.getStatus();
		this.nomeAutor = topico.getAutor().getNome();
		this.respostas = converterRespostas(topico.getRespostas());
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public StatusTopico getStatus() {
		return status;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public List<RespostaDto> getRespostas() {
		return respostas;
	}
	
	public static List<RespostaDto> converterRespostas (List<Resposta> respostas){
		List<RespostaDto> respostaDto = new ArrayList<>();
		for (Resposta resposta : respostas) {
			respostaDto.add(new RespostaDto(resposta));
		}
		return respostaDto;
	}
	
}
