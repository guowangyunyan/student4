package com.shsxt.util;

import java.io.IOException;
import java.util.Properties;

//配置文件工具类
public class PropertiesUtil {
	private static Properties properties;

	static {
		properties = new Properties();
		try {
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String get(String key) {
		return properties.getProperty(key);
	}
}
