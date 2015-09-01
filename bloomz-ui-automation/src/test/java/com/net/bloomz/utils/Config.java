package com.net.bloomz.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Config {

	private static final Logger logger = LoggerFactory.getLogger(Config.class);

	public static String getConfigData(String key) {
		Properties properties = null;
		try {
			properties = new Properties();
			properties.load(new FileReader("config.properties"));
		} catch (FileNotFoundException e) {
			logger.error(e.getLocalizedMessage());
		} catch (IOException e) {
			logger.error(e.getLocalizedMessage());
		}
		return properties.getProperty(key);
	}
}
