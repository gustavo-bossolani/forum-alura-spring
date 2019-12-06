package com.alura.exercicio.forum.dto;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;

import com.alura.exercicio.forum.modelo.Topico;

public class TopicoDto {
	
	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;

	
	
	public TopicoDto(Topico topico) {
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.dataCriacao = topico.getDataCriacao();
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
	
	public static Page<TopicoDto> converter (Page<Topico> topicos){
		return topicos.map(TopicoDto:: new );
		
//		Retornando usando a sintaxe do Java 8
//		return topicos.stream().map(TopicoDTO :: new).collect(Collectors.toList());
	}
	
}
