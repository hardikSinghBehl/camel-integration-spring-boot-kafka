package com.behl.searcher.transformer;

import org.springframework.stereotype.Component;

import com.behl.searcher.dto.SuperHero;

@Component
public class SuperHeroSearcher {

	public SuperHero search() {
		return SuperHero.find();
	}

}
