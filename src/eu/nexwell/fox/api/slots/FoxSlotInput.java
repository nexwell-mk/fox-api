package eu.nexwell.fox.api.slots;

import eu.nexwell.fox.api.core.FoxException;
import eu.nexwell.fox.api.core.FoxSlot;

public class FoxSlotInput extends FoxSlot {

	public FoxSlotInput() {
		
	}
	
	public boolean isActive() throws FoxException {
		return readGet(1)[0] != 0;
	}
}
