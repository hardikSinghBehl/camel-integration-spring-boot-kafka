package com.behl.registry.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import com.behl.registry.dto.SuperHero;
import com.behl.registry.processor.MessageBodyLogger;
import com.behl.registry.properties.KafkaConfigurationProperties;
import com.behl.registry.utility.JsonDataFormatter;

import lombok.RequiredArgsConstructor;

@Component
@EnableConfigurationProperties(value = KafkaConfigurationProperties.class)
@RequiredArgsConstructor
public class SuperHeroInformationConsumptionRoute extends RouteBuilder {

	private final KafkaConfigurationProperties kafkaConfigurationProperties;
	private final MessageBodyLogger messageBodyLogger;

	@Override
	public void configure() {
		from("kafka:" + kafkaConfigurationProperties.getTopicName()).unmarshal(JsonDataFormatter.get(SuperHero.class))
				.process(messageBodyLogger).end();
	}

}
