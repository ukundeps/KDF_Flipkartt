package com.testingshastra.CustomUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class PropertiesUtil {
	 static Properties prop=new Properties();
	public static String getLocators(String locatorName) {
		String values = "";
		try {
			String basePath=System.getProperty("user.dir"); //Absolute Path
			System.out.println(basePath);//Base Path Of File
			FileInputStream fis=new FileInputStream(basePath+"\\src\\main\\resources\\ObjRepository.properties");
			prop.load(fis);
			values=(String) prop.get(locatorName);
		} catch (FileNotFoundException e) {
			System.err.println("Object Repository Not Found!!!");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Unable to load properties file!!");
			e.printStackTrace();
		}
		return values;
	}
public static void main(String[] args) {
	System.out.println(getLocators("searchComponenet"));
}
}
