package com.behl.registry.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "super_hero")
public class SuperHero implements Serializable {

	private static final long serialVersionUID = -7529266820643998609L;

	@Id
	private UUID id;

	private String name;
	private String descriptor;
	private String power;
	private String prefix;
	private String suffix;
	private LocalDateTime foundAt;

}