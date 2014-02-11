package eu.nexwell.fox.api.devices;

import eu.nexwell.fox.api.core.FoxDevice;
import eu.nexwell.fox.api.core.FoxException;

public class FoxDeviceNet extends FoxDevice {

	public FoxDeviceNet(int address) throws FoxException {
		super(address);
		type = "Fox NET";
	}

}
