package com.behl.registry.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MessageBodyLogger implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		log(exchange.getMessage().getBody());
	}

	private void log(final Object messageBody) {
		log.info("Polled Superhero information: {}", messageBody);
	}

}