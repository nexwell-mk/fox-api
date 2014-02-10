package eu.nexwell.fox.api.test;

import eu.nexwell.fox.api.core.Fox;
import eu.nexwell.fox.api.core.FoxException;
import eu.nexwell.fox.api.devices.FoxDeviceOut;
import eu.nexwell.fox.api.slots.FoxSlotOutput;

public class FoxApiTestOutputToggle implements FoxApiTest {

	@Override
	public void run(Fox fox) throws FoxException {
		
		FoxDeviceOut foxOut = new FoxDeviceOut(1);
		fox.addDevice(foxOut);
		
		FoxSlotOutput foxOutput = foxOut.getOutput(0);
		
		foxOutput.toggle();
		System.out.println(foxOutput.isTurnedOn());
		
	}

}
