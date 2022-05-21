package com.behl.searcher.dto;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

import com.github.javafaker.Faker;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class SuperHero {

	private UUID id;
	private String name;
	private String descriptor;
	private String power;
	private String prefix;
	private String suffix;
	private LocalDateTime foundAt;

	public static SuperHero find() {
		final var superHero = new Faker().superhero();
		return SuperHero.builder().id(UUID.randomUUID()).name(superHero.name()).descriptor(superHero.descriptor())
				.power(superHero.power()).prefix(superHero.prefix()).suffix(superHero.suffix())
				.foundAt(LocalDateTime.now(ZoneId.of("+00:00"))).build();
	}

}
