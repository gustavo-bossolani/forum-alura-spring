package com.alura.exercicio.forum.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
	
	public static List<TopicoDto> converter (List<Topico> topicos){
		List<TopicoDto> topicoDto = new ArrayList<>();
		for (Topico topico : topicos) {
			topicoDto.add(new TopicoDto(topico));
		}
		return topicoDto;
		
//		Retornando usando a sintaxe do Java 8
//		return topicos.stream().map(TopicoDTO :: new).collect(Collectors.toList());
	}
	
}
