package com.behl.registry.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "com.behl.kafka")
public class KafkaConfigurationProperties {

	private String topicName;

}
