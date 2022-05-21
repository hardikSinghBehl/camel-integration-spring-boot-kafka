package com.behl.searcher.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.behl.searcher.processor.MessageBodyLogger;
import com.behl.searcher.transformer.SuperHeroSearcher;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SuperHeroSearchScheduler extends RouteBuilder {

	private final SuperHeroSearcher superHeroSearcher;
	private final MessageBodyLogger messageBodyLogger;

	@Override
	public void configure() {
		from("timer:superhero-search-scheduler?period=5000").bean(superHeroSearcher).process(messageBodyLogger)
				.to("kafka:superhero-information");
	}

}
