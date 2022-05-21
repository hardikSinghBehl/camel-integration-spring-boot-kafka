package com.behl.registry.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.behl.registry.entity.SuperHero;
import com.behl.registry.repository.SuperHeroRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/registry")
public class SuperHeroController {

	private final SuperHeroRepository superHeroRepository;

	@GetMapping(value = "/superheroes", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<SuperHero>> superHeroRegistryDetailsRetreival() {
		return ResponseEntity.status(HttpStatus.OK).body(superHeroRepository.findAll());
	}

}
