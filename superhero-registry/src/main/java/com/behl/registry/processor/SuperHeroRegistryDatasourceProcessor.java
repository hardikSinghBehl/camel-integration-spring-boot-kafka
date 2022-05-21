package com.behl.registry.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import com.behl.registry.entity.SuperHero;
import com.behl.registry.repository.SuperHeroRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SuperHeroRegistryDatasourceProcessor implements Processor {

	private final SuperHeroRepository superHeroRepository;

	@Override
	public void process(final Exchange exchange) {
		superHeroRepository.save((SuperHero) exchange.getMessage().getBody());
	}

}
