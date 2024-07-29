package com.eBanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	
	public ReadConfig() {
		
		try {
		File src=new File("./Configuration/config.properties");
		
		FileInputStream fis=new FileInputStream(src);
		
		prop=new Properties();
		prop.load(fis);
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	public String getApplicationURL() {
		
		String url=prop.getProperty("baseURL");
		return url;
	}
	
	public String getUsernName() {
		String name=prop.getProperty("username");
		return name;
	}
	
	public String getPassword() {
		String pwd=prop.getProperty("password");
		return pwd;
	}
	
	public String getchromePath() {
		String chromepath=prop.getProperty("chromepath");
		return chromepath;
	}
	
	public String getedgePath() {
		String chromepath=prop.getProperty("chromepath");
		return chromepath;
	}
	

}
