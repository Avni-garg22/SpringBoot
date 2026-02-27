package com.classLevelconfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.classLevelconfiguration")
public class DemoConfiguration {
	@Bean("scan1")
	public Scanner getScanner() {
		return new Scanner(System.in);
	}
	
	//return type should not be void it should be factory method
	@Bean
	public List<String> getabc(){
		return List.of("avi","garg","shubhi","gupta");	
	}
	
	//map
	@Bean
	public Map<String, String> getabd(){
	    Map<String, String> map = new LinkedHashMap<>();
	    map.put("name1", "avi");
	    map.put("name2", "garg");
	    return map;
	}
}


