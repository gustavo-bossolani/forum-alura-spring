package com.alura.exercicio.forum.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.alura.exercicio.forum.modelo.Topico;

public class TopicoDTO {
	
	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;

	
	
	public TopicoDTO(Topico topico) {
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
	
	public static List<TopicoDTO> converter (List<Topico> topicos){
		List<TopicoDTO> topicoDto = new ArrayList<>();
		for (Topico topico : topicos) {
			topicoDto.add(new TopicoDTO(topico));
		}
		return topicoDto;
		
//		Retornando usando a sintaxe do Java 8
//		return topicos.stream().map(TopicoDTO :: new).collect(Collectors.toList());
	}
	
}
