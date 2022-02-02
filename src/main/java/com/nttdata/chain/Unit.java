package com.nttdata.chain;

import java.util.Objects;

import lombok.Builder;
import lombok.Data;
import lombok.extern.java.Log;

@Data
@Builder
@Log
public class Unit {
	
	private Unit subordinate;
	
	private String name;
	
	public void executeCommand (String command) {
		
		if (Objects.nonNull(subordinate)) {
			log.info("My name is "+name+" and I'm sending command to "+subordinate.getName());
			subordinate.executeCommand(command);
		} else {
			log.info("Mi name is "+name+" and I'm executing command "+command);
		}
		
	}

}
