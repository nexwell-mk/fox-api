package eu.nexwell.fox.api.test;

import eu.nexwell.fox.api.connection.FoxMessengerTcpIp;
import eu.nexwell.fox.api.core.Fox;
import eu.nexwell.fox.api.core.FoxException;

public class FoxApiTester {

	public static void main(String[] args) {
		
		try {
			Fox fox = new Fox();
			
			FoxMessengerTcpIp messenger = new FoxMessengerTcpIp();
			messenger.setHost("fox");
			messenger.setTimeout(100);
			messenger.open();
			fox.setMessenger(messenger);
			
			FoxApiTest test;
			
			//test = new FoxApiTestOutputToggle();
			test = new FoxApiTestSearch();
			
			test.run(fox);
			
			messenger.close();
		}
		catch (FoxException ex) {
			System.err.println(ex.getMessage());
		}
		
	}

}
