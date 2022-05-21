package com.behl.registry.dto;

import java.time.LocalDateTime;
import java.util.UUID;

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

}
