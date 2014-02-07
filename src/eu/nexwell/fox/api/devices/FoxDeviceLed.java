package eu.nexwell.fox.api.devices;

import eu.nexwell.fox.api.core.FoxDevice;
import eu.nexwell.fox.api.core.FoxException;

public class FoxDeviceLed extends FoxDevice {

	public FoxDeviceLed(int address) throws FoxException {
		super(address);
		type = "Fox LED";
		// TODO Auto-generated constructor stub
	}

}
