package com.classLevelconfiguration.demo;

import org.springframework.stereotype.Component;

@Component
public class UPI implements Payment{

	@Override
	public void send() {
		System.out.println("UPI");		
	}

}
