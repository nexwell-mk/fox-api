package eu.nexwell.fox.api.devices;

import eu.nexwell.fox.api.core.FoxDevice;
import eu.nexwell.fox.api.core.FoxException;

public class FoxDeviceTouch extends FoxDevice {

	public FoxDeviceTouch(int address) throws FoxException {
		super(address);
		type = "Fox TOUCH";
		// TODO Auto-generated constructor stub
	}

}
