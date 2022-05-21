package com.behl.registry.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.behl.registry.entity.SuperHero;

@Repository
public interface SuperHeroRepository extends JpaRepository<SuperHero, UUID> {

}
