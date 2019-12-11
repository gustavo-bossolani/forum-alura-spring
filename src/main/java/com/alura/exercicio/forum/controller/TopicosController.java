package com.alura.exercicio.forum.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.alura.exercicio.forum.dto.DetalheTopicoDto;
import com.alura.exercicio.forum.dto.TopicoDto;
import com.alura.exercicio.forum.form.AtualizarTopicoForm;
import com.alura.exercicio.forum.form.TopicoForm;
import com.alura.exercicio.forum.modelo.Topico;
import com.alura.exercicio.forum.repository.TopicoRepository;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

	@Autowired
	TopicoRepository topicoRepository;

	@Autowired
	CursoRepository cursoRepository;

	@GetMapping
	@Transactional
	public Page<TopicoDto> lista(
				@RequestParam(required = false) String nomeCurso, 
				@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10)
				Pageable paginacao) {
//		Pageable paginacao = PageRequest.of(pagina, qtd, Direction.ASC, ordenacao);
		
		if(nomeCurso != null) {
			Page<Topico> topicos = topicoRepository.findByCurso_Nome(nomeCurso, paginacao);
			return TopicoDto.converter(topicos);
		}
		Page<Topico> topicos = topicoRepository.findAll(paginacao);
		return TopicoDto.converter(topicos);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm topicoForm, UriComponentsBuilder uriBuilder) {
		Topico topico = topicoForm.converter(cursoRepository);
		if( topico != null ) {
			topicoRepository.save(topico);
			URI uri = uriBuilder.path("/topicos/{ id }").buildAndExpand(topico.getId()).toUri();
			return ResponseEntity.created(uri).body(new TopicoDto(topico));
		}
		return ResponseEntity.badRequest().build();
	}

	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity<DetalheTopicoDto> detalhar(@PathVariable Long id) {
		//		Topico topico = topicoRepository.getOne(id);
		Optional<Topico> optional = topicoRepository.findById(id);
		if(optional.isPresent())
			return ResponseEntity.ok(new DetalheTopicoDto(optional.get()));
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<TopicoDto> atualzar(@PathVariable Long id, @RequestBody @Valid AtualizarTopicoForm atualizarForm){
		Optional<Topico> optional = topicoRepository.findById(id);
		if(optional.isPresent()) {
			Topico topico = atualizarForm.atualizar(id, topicoRepository);
			return ResponseEntity.ok(new TopicoDto(topico));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletar(@PathVariable Long id){
		Optional<Topico> optional = topicoRepository.findById(id);
		if(optional.isPresent()) {
			topicoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}
