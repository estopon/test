package com.nttdata.singleton;

import java.util.Objects;

import com.nttdata.domain.Person;

public class PersonSingletonLazy {
	
	private static Person INSTANCE;
	
	private PersonSingletonLazy() {
		super();
	}
	
	public static Person getInstance() {
		if (Objects.isNull(INSTANCE)) {
			INSTANCE = new Person();
		}
		return INSTANCE;
	}
	
	

}
