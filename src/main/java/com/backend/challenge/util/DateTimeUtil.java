package com.backend.challenge.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class DateTimeUtil {
	
	private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static LocalDateTime convert(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
		return LocalDateTime.parse(date, formatter);
	}
}
