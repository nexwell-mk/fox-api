package eu.nexwell.fox.api.devices;

import eu.nexwell.fox.api.core.FoxDevice;
import eu.nexwell.fox.api.core.FoxException;

public class FoxDeviceDimm extends FoxDevice {

	public FoxDeviceDimm(int address) throws FoxException {
		super(address);
		type = "Fox DIMM";
		// TODO Auto-generated constructor stub
	}

}
