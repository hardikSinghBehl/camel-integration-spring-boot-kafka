package com.behl.searcher.utility;

import org.apache.camel.component.jackson.JacksonDataFormat;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonDataFormatter {

	public static JacksonDataFormat get(final Class<?> T) {
		JacksonDataFormat jsonDataFormat = new JacksonDataFormat(T);
		jsonDataFormat.addModule(new JavaTimeModule());
		return jsonDataFormat;
	}

}
