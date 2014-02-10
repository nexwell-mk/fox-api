package eu.nexwell.fox.api.slots;

import eu.nexwell.fox.api.core.FoxException;
import eu.nexwell.fox.api.core.FoxSlot;

public class FoxSlotLevel extends FoxSlot {

	public FoxSlotLevel() {
		
	}
	
	public void turnOn() throws FoxException {
		writeSet(0x01);
	}
	
	public void turnOn(int level) throws FoxException {
		writeSet(0x10, convertArg(level, 1, 255, 1));
	}
	
	public void turnOff() throws FoxException {
		writeSet(0x00);
	}
	
	public void toggle() throws FoxException {
		writeSet(0x02);
	}
	
	public void toggle(int level) throws FoxException {
		writeSet(0x12, convertArg(level, 1, 255, 1));
	}
	
	public void stopSweep() throws FoxException {
		writeSet(0x20);
	}
	
	public void sweep() throws FoxException {
		writeSet(0x21);
	}
	
	public void sweepUp() throws FoxException {
		writeSet(0x22);
	}
	
	public void sweepDown() throws FoxException {
		writeSet(0x23);
	}
	
	public boolean isOn() throws FoxException {
		return readGet(1)[0] != 0x00;
	}
	
	public int getLevel() throws FoxException {
		return readGet(2)[1];
	}
}
