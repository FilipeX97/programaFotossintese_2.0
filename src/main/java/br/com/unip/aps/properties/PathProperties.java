package br.com.unip.aps.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PathProperties {
	
	private static final Logger logger = Logger.getLogger(PathProperties.class);
	
	public static Properties getPathProperties() {
		Properties props = new Properties();
		try {
			
		FileInputStream file = new FileInputStream("paths.properties");
		props.load(file);
		return props;

		} catch (IOException e) {
			logger.error(e.getMessage());
			return null;
		}
	}

}
