package com.behl.searcher.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import com.behl.searcher.dto.SuperHero;
import com.behl.searcher.processor.MessageBodyLogger;
import com.behl.searcher.properties.KafkaConfigurationProperties;
import com.behl.searcher.transformer.SuperHeroSearcher;
import com.behl.searcher.utility.JsonDataFormatter;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
@EnableConfigurationProperties(value = KafkaConfigurationProperties.class)
public class SuperHeroSearchScheduler extends RouteBuilder {

	private final SuperHeroSearcher superHeroSearcher;
	private final MessageBodyLogger messageBodyLogger;
	private final KafkaConfigurationProperties kafkaConfigurationProperties;

	@Override
	public void configure() {
		final var deadLetterTopicConfiguration = kafkaConfigurationProperties.getDeadLetter();
		errorHandler(deadLetterChannel("kafka:" + deadLetterTopicConfiguration.getTopicName())
				.maximumRedeliveries(deadLetterTopicConfiguration.getRetries())
				.maximumRedeliveryDelay(deadLetterTopicConfiguration.getDelay()));

		from("timer:superhero-search-scheduler?period=5000").bean(superHeroSearcher).process(messageBodyLogger)
				.marshal(JsonDataFormatter.get(SuperHero.class))
				.to("kafka:" + kafkaConfigurationProperties.getTopicName());
	}

}
