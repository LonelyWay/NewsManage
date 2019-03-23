package com.bdqn.zmj.util;

import java.io.IOException;
import java.util.Properties;

public class ConfigMapper {

	private static Properties prop;
	
	static {
		prop = new Properties();
		try {
			//加载配置文件
			prop.load(ConfigMapper.class.getResourceAsStream("/db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//通过key获取value值
	public static String get(String key) {
		return prop.getProperty(key);
	}
}
