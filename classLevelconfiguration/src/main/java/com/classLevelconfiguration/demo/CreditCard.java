package com.classLevelconfiguration.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class CreditCard {

	
	public void send() {
		System.out.println("CreditCard");
	}
}
