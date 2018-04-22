package ecommerce.shopping;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	
	public static String readProperty(String propertyName) {
		Properties property= new Properties();
		FileInputStream fs;
		String propertyValue = null;
		try {
		fs = new FileInputStream(System.getProperty("user.dir") + "\\config.properties");
		property.load(fs);
		propertyValue = property.getProperty(propertyName);

		} catch(IOException e) {
			System.out.println("Config file could not be read");
		}
		return propertyValue;
	}

}
