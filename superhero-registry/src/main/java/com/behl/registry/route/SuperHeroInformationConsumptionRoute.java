package com.behl.registry.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.behl.registry.dto.SuperHero;
import com.behl.registry.utility.JsonDataFormatter;

@Component
public class SuperHeroInformationConsumptionRoute extends RouteBuilder {

	@Override
	public void configure() {
		from("kafka:superhero-information").unmarshal(JsonDataFormatter.get(SuperHero.class))
				.to("log:" + SuperHeroInformationConsumptionRoute.class);
	}

}
