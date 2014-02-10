package eu.nexwell.fox.api.devices;

import eu.nexwell.fox.api.core.FoxDevice;
import eu.nexwell.fox.api.core.FoxException;
import eu.nexwell.fox.api.slots.FoxSlotInput;
import eu.nexwell.fox.api.slots.FoxSlotLevel;
import eu.nexwell.fox.api.slots.FoxSlotOutput;

public class FoxDeviceDimm extends FoxDevice {

	private final static int inputsCount = 8;
	private final static int outputsCount = 7;
	private final static int levelsCount = 7;
	
	public FoxDeviceDimm(int address) throws FoxException {
		super(address);
		type = "Fox DIMM";
		
		for (int i = 0; i < inputsCount; i++)
			addSlot(new FoxSlotInput());
		
		for (int i = 0; i < outputsCount; i++)
			addSlot(new FoxSlotOutput());
		
		for (int i = 0; i < levelsCount; i++)
			addSlot(new FoxSlotLevel());
	}

	public FoxSlotInput getButton(int index) {
		return (FoxSlotInput) findSlot(FoxSlotInput.class, index);
	}
	
	public FoxSlotOutput getOutput(int index) {
		return (FoxSlotOutput) findSlot(FoxSlotOutput.class, index);
	}
	
	public FoxSlotLevel getDimmer(int index) {
		return (FoxSlotLevel) findSlot(FoxSlotLevel.class, index);
	}
}
