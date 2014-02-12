package eu.nexwell.fox.api.slots;

import eu.nexwell.fox.api.core.FoxException;
import eu.nexwell.fox.api.core.FoxSlot;

public class FoxSlotThermometer extends FoxSlot {

	public FoxSlotThermometer() {
		
	}
	
	public double getTemperature() throws FoxException {
		Byte[] state = readGet(3);
		return (256*state[2] + (state[1] & 0xff)) / 10.0;
	}
}
