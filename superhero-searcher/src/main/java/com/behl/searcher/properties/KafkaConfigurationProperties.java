package com.behl.searcher.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "com.behl.kafka")
public class KafkaConfigurationProperties {

	private String topicName;
	private DeadLetter deadLetter = new DeadLetter();

	@Data
	public class DeadLetter {
		private String topicName;
		private Integer retries;
		/***
		 * Delay between messages that fail to publish in milliseconds
		 */
		private Long delay;

	}

}
