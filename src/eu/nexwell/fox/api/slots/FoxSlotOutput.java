package eu.nexwell.fox.api.slots;

import eu.nexwell.fox.api.core.FoxException;
import eu.nexwell.fox.api.core.FoxSlot;

public class FoxSlotOutput extends FoxSlot {

	public FoxSlotOutput() {
		
	}
	
	public void turnOn() throws FoxException {
		writeSet(1);
	}
	
	public void turnOff() throws FoxException {
		writeSet(0);
	}
	
	public void toggle() throws FoxException {
		writeSet(2);
	}
	
	public boolean isTurnedOn() throws FoxException {
		return readGet()[0] != 0;
	}
}
