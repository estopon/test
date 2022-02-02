package com.nttdata.decorator;

import com.nttdata.domain.Person;

public class PersonDecorator implements PersonInterface {
	
	private Person person;
	
	public PersonDecorator (Person person) {
		this.person = person;
	}

	@Override
	public String getName() {
		return this.person.getName()+" decorado";
	}

	@Override
	public int getAge() {
		return this.person.getAge()*100;
	}	

}
