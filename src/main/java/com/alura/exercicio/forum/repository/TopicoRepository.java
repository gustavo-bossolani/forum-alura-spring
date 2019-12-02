package com.alura.exercicio.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alura.exercicio.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {}
