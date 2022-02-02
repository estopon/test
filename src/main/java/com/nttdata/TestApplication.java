package com.nttdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nttdata.chain.Unit;
import com.nttdata.decorator.PersonDecorator;
import com.nttdata.domain.Person;
import com.nttdata.domain.PersonLombok;
import com.nttdata.proxy.PersonProxyClass1;
import com.nttdata.proxy.PersonProxyClass2;
import com.nttdata.singleton.PersonSingletonEager;
import com.nttdata.singleton.PersonSingletonEnum;
import com.nttdata.singleton.PersonSingletonLazy;

@SpringBootApplication
public class TestApplication implements CommandLineRunner {

	@Autowired
	private ApplicationContext context;
	
	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("=============================================================================");
		System.out.println("Prácticas con Singleton");
		System.out.println("=============================================================================");
		
		PersonSingletonLazy.getInstance().setName("Alfonso");
		PersonSingletonLazy.getInstance().setAge(45);
		
		System.out.println(PersonSingletonLazy.getInstance().getName());
		
		PersonSingletonEager.INSTANCE.setName("Alfonso");
		PersonSingletonEager.INSTANCE.setAge(45);
		
		System.out.println(PersonSingletonEager.INSTANCE.getName());
		
		PersonSingletonEnum.INSTANCE.getPerson().setName("Alfonso");
		PersonSingletonEnum.INSTANCE.getPerson().setAge(45);
		
		System.out.println(PersonSingletonEnum.INSTANCE.getPerson().getName());
		
		System.out.println("=============================================================================");
		System.out.println("Prácticas con Prototype");
		System.out.println("=============================================================================");
		
		Person personClone = PersonSingletonEnum.INSTANCE.getPerson().getClone();
		
		System.out.println(personClone.getName());
		
		PersonLombok personLombok = new PersonLombok("Alfonso",45);
		PersonLombok personLombok2 = personLombok.builder().name("otro").age(1).build();
		PersonLombok personLombokClone = personLombok.toBuilder().age(10).build();
		
		System.out.println(personLombokClone.getName());
		
		System.out.println("=============================================================================");
		System.out.println("Prácticas con Builder");
		System.out.println("=============================================================================");
		
		Person person = Person.builder().age(45).name("Alfonso").build();
		System.out.println(person.getName());
		
		System.out.println("=============================================================================");
		System.out.println("Prácticas con Singleton/prototype");
		System.out.println("=============================================================================");
		
		System.out.println("Prototype Object name ->" + ((Person)context.getBean("personPrototype")).getName());
		System.out.println("Prototype Object ID ->" + context.getBean("personPrototype").hashCode());
		System.out.println("Prototype Object ID ->" + context.getBean("personPrototype").hashCode());
		System.out.println("Prototype Object ID ->" + context.getBean("personPrototype").hashCode());

		System.out.println("Singleton Object name ->" + ((Person)context.getBean("personSingleton")).getName());
		System.out.println("Singleton Object ID ->" + context.getBean("personSingleton").hashCode());
		System.out.println("Singleton Object ID ->" + context.getBean("personSingleton").hashCode());
		System.out.println("Singleton Object ID ->" + context.getBean("personSingleton").hashCode());
		
		System.out.println("=============================================================================");
		System.out.println("Prácticas con Decorador");
		System.out.println("=============================================================================");
		
		PersonDecorator personDecorator = new PersonDecorator(person);
		System.out.println(personDecorator.getName());
		
		System.out.println("=============================================================================");
		System.out.println("Prácticas con Proxy");
		System.out.println("=============================================================================");
		
		PersonProxyClass1 personProxyClass1 = new PersonProxyClass1(person);
		PersonProxyClass2 personProxyClass2 = new PersonProxyClass2(person);
		
		personProxyClass1.operacion();
		personProxyClass2.operacion();
		
		System.out.println("=============================================================================");
		System.out.println("Prácticas con Cadena de Mando");
		System.out.println("=============================================================================");
		
		Unit soldier = Unit.builder().name("soldier").build();
		Unit sergeant = Unit.builder().name("sergeant").subordinate(soldier).build();
		Unit captain = Unit.builder().name("captain").subordinate(sergeant).build();
		
		captain.executeCommand("Make a coffee");
		
		
	}

}
