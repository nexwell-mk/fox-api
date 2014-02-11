package eu.nexwell.fox.api.slots;

import eu.nexwell.fox.api.core.FoxException;
import eu.nexwell.fox.api.core.FoxSlot;

public class FoxSlotThermostate extends FoxSlot {

	public FoxSlotThermostate() {
		
	}
	
	public void turnOn() throws FoxException {
		writeSet(0x01);
	}
	
	public void turnOn(float temperatureThreshold) throws FoxException {
		writeSet(0x01, convertArg((int) (10 * temperatureThreshold), -1200, 1200));
	}
	
	public void turnOff() throws FoxException {
		writeSet(0x00);
	}
	
	public void toggle() throws FoxException {
		writeSet(0x02);
	}
	
	public void toggle(float temperatureThreshold) throws FoxException {
		writeSet(0x02, convertArg((int) (10 * temperatureThreshold), -1200, 1200));
	}
	
	public void setThreshold(float temperatureThreshold) throws FoxException {
		writeSet(0x10, convertArg((int) (10 * temperatureThreshold), -1200, 1200));
	}
	
	public boolean isOn() throws FoxException {
		return readGet(1)[0] != 0x00;
	}
	
	public boolean isActive() throws FoxException {
		return readGet(2)[1] != 0x00;
	}
}
