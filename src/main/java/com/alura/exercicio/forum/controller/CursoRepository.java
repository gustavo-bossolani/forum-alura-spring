package com.alura.exercicio.forum.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alura.exercicio.forum.modelo.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
	
	public Curso findByNome(String nome);
}
