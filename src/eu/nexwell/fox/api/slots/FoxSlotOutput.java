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
	
	public void flash() throws FoxException {
		writeSet(3);
	}
	
	public void flash(int timeMs) throws FoxException {
		writeSet(3, convertArg(timeMs, 25, 5*60*1000, 25));
	}
	
	public void pulse() throws FoxException {
		writeSet(4);
	}
	
	public void pulse(int timeMs) throws FoxException {
		writeSet(4, convertArg(timeMs, 25, 5*60*1000, 25));
	}
	
	public void pwm() throws FoxException {
		writeSet(5);
	}
	
	public void pwm(int timeOnMs, int timeOffMs) throws FoxException {
		writeSet(5, convertArg(timeOnMs, 25, 5000, 25), 0,
				convertArg(timeOffMs, 25, 5000, 25), 0);
	}
	
	public boolean isOn() throws FoxException {
		return readGet()[0] != 0;
	}
}
