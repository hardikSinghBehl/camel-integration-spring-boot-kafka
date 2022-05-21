package com.behl.searcher.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "com.behl.kafka")
public class KafkaConfigurationProperties {

	private String topicName;
	private String deadLetterTopicName;

}
