package com.nttdata.domain;

import com.nttdata.prototype.IPrototype;
import com.nttdata.proxy.IPersonProxyInterface;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person implements IPrototype, IPersonProxyInterface {	
	
	private String name;
	
	private int age;	
	
	/*@Override
	public Person clone() {
		return new Person(this.name,this.age);
	}*/
	
	@Override
	public Person getClone() {
		return new Person(this);
	}	
	
	public Person (Person person) {
		this.name = person.name;
		this.age = person.age;
	}
	
	private Person(PersonBuilder personBuilder) {
		super();
		this.name = personBuilder.name;
		this.age = personBuilder.age;
	}
	
	public static PersonBuilder builder() {
		return new PersonBuilder();
	}
	
	public static class PersonBuilder {
		
		private String name;
		
		private int age;
		
		public PersonBuilder name (String name) {
			this.name = name;
			return this;
		}
		
		public PersonBuilder age (int age) {
			this.age = age;
			return this;
		}
		
		public Person build () {
			return new Person(this);
		}
		
	}

	@Override
	public void operacion() {
		System.out.println("Ejecutando operación");		
	}

}
