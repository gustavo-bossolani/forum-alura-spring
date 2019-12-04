package com.alura.exercicio.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alura.exercicio.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
	
	public List<Topico> findByCurso_Nome(String nomeCurso);
}
