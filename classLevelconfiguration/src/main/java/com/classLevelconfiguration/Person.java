package com.classLevelconfiguration;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
//dependency injection	

	//field injection: above variable autowired
	@Autowired
	private Mobile mob;

	@Autowired
	private Scanner scan;

	public Mobile getMob() {
		return mob;
	}

	//setter injection: above setter autowired
	@Autowired
	public void setMob(Mobile mob) {
		this.mob = mob;
	}

	public Scanner getScan() {
		return scan;
	}

	public void setScan(Scanner scan) {
		this.scan = scan;
	}
	public void getMessage() {
		System.out.println("Hii");
	}
	
	//constructor injection : not need to write autowired keyword
	
	public Person(Mobile mob) {
		this.mob=mob;	
		}

}
