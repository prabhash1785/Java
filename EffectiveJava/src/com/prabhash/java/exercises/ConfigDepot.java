package com.prabhash.java.exercises;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigDepot {

	static Map<String, Map<String, String>> globalMap = new HashMap<String, Map<String, String>>();

	public static Map<String, String> getConfig(String configFileName) throws ConfigFileNotFoundException {
		InputStream is = null;
		Map<String, String> map = null;
		try {
			is = ConfigDepot.class.getClassLoader().getResourceAsStream(
					configFileName);
			
			if (is == null)
			{
				throw new ConfigFileNotFoundException(configFileName);
			}
			Properties prop = new Properties();
			prop.load(is);
			map = new HashMap<String, String>((Map) prop);
			globalMap.put(configFileName, map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new ConfigFileNotFoundException(configFileName, e);
		} finally {
			try {
				if (is != null)
					is.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return map;
	}

	public static void main(String[] args) {
		try {
			Map<String,String> devConfig = ConfigDepot.getConfig("dev.properties");
			System.out.printf("Development mode	configurations:\n\t%s\n",devConfig);
			System.out.printf("Development	mode	host:\n\t%s\n",	devConfig.get("host"));
			Map<String,	String>	prodConfig	= ConfigDepot.getConfig("prod.properties");
			System.out.printf("Production	mode configurations:\n\t%s\n",prodConfig);
			System.out.printf("Production	mode	host:\n\t%s\n",	prodConfig.get("host"));
		} catch (ConfigFileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
