package eu.nexwell.fox.api.test;

import java.util.ArrayList;

import eu.nexwell.fox.api.connection.FoxMessengerTcpIp;
import eu.nexwell.fox.api.core.Fox;
import eu.nexwell.fox.api.core.FoxException;

public class FoxApiTester {

	public static void main(String[] args) {
		
		try {
			ArrayList<FoxApiTest> tests = new ArrayList<FoxApiTest>();
			tests.add(new FoxApiTestSlots());
			tests.add(new FoxApiTestTasks());
			tests.add(new FoxApiTestSearch());
			tests.add(new FoxApiTestLabels());
			
			for (FoxApiTest test : tests) {
				FoxMessengerTcpIp messenger = new FoxMessengerTcpIp();
				messenger.setHost("fox");
				messenger.setTimeout(250);
				messenger.setPassword("password");
				messenger.setPrintStream(System.out);
				
				Fox fox = new Fox();
				fox.setMessenger(messenger);
				
				messenger.open();
				test.run(fox);
				messenger.close();
			}
		}
		catch (FoxException ex) {
			System.err.println(ex.getMessage());
		}
		
	}

}
