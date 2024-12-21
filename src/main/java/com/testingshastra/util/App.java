package com.testingshastra.util;

public class App {

	private static String baseDir = System.getProperty("user.dir"); // Current working directory path
	private static String filePath = baseDir + "/src/main/resources/propertiesfiles/app.properties";

	public static String getAppUrl(String env) {
		return PropertiesUtil.getProperty(filePath, env + ".url");
	}

	public static String getUsername(String env) {
		return PropertiesUtil.getProperty(filePath, env + ".username");
	}

	public static String getPassword(String env) {
		return PropertiesUtil.getProperty(filePath, env + ".password");
	}

	public static boolean isOnGrid() {
		return Boolean.parseBoolean(PropertiesUtil.getProperty(filePath, "isOnGrid"));
	}

}
