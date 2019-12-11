package com.alura.exercicio.forum.controller;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alura.exercicio.forum.modelo.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
	
	public Optional<Curso> findByNome(String nome);
}
