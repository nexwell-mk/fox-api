package eu.nexwell.fox.api.core;

import java.util.Scanner;

public class FoxMessageMe extends FoxMessage {

	private String type;
	private String version;
	
	@Override
	protected void prepareMessage() {
		
	}

	@Override
	protected void interpretMessage() {
		type = "";
		version = "";
		if (message.matches("me .+ .+")) {
			Scanner scanner = new Scanner (message);
			scanner.next();
			type = scanner.next();
			version = scanner.next();
			scanner.close();
		}
	}
	
	String getType() {
		return type;
	}
	
	String getVersion() {
		return version;
	}

}
