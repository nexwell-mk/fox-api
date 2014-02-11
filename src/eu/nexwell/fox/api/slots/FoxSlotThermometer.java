package eu.nexwell.fox.api.slots;

import eu.nexwell.fox.api.core.FoxException;
import eu.nexwell.fox.api.core.FoxSlot;

public class FoxSlotThermometer extends FoxSlot {

	public FoxSlotThermometer() {
		
	}
	
	public float getTemperature() throws FoxException {
		Byte[] state = readGet(2);
		return 256*state[1] + (state[0] & 0xff);
	}
}
