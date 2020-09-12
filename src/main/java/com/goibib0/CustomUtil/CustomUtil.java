package com.goibib0.CustomUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class CustomUtil {
	static Properties prop = new Properties();

	protected static String getLocator(String locatorName) {
		String locator = "";
		FileInputStream fis;
		try {
			fis = new FileInputStream(
					"C:\\Users\\NRK\\javapract\\KDF_Flipkartt\\src\\main\\resources\\ObjRepoGoibibo.properties");
			prop.load(fis);
			locator = prop.getProperty(locatorName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return locator;

	}

	public static String[] getLocatorValue(String locatorname) {
		
		return getLocator(locatorname).split("##");
		
		
	}
}