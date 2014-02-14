package eu.nexwell.fox.api.test;

import eu.nexwell.fox.api.core.Fox;
import eu.nexwell.fox.api.core.FoxDevice;
import eu.nexwell.fox.api.core.FoxException;

public class FoxApiTestSearch implements FoxApiTest {

	@Override
	public void run(Fox fox) throws FoxException {
		
		fox.addDevices(fox.searchDevices());
		
		for (FoxDevice dev : fox.getDevices())
			System.out.println(String.format("FoxDevice address: %02d, type: %s",
					dev.getAddress(), dev.getTypeString()));
		
	}

}
