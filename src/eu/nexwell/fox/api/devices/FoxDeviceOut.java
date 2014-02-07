package eu.nexwell.fox.api.devices;

import eu.nexwell.fox.api.core.FoxDevice;
import eu.nexwell.fox.api.core.FoxException;
import eu.nexwell.fox.api.slots.FoxSlotInput;
import eu.nexwell.fox.api.slots.FoxSlotOutput;


public class FoxDeviceOut extends FoxDevice {

	private final static int inputsCount = 8;
	private final static int outputsCount = 8;
	//private final static int pushPullsCount = 4;
	
	public FoxDeviceOut(int address) throws FoxException {
		super(address);
		type = "Fox OUT";
		
		for (int i = 0; i < inputsCount; i++)
			addSlot(new FoxSlotInput());
		
		for (int i = 0; i < outputsCount; i++)
			addSlot(new FoxSlotOutput());
	}
	
	public FoxSlotInput getInput(int index) {
		return (FoxSlotInput) findSlot(FoxSlotInput.class, index);
	}
	
	public FoxSlotOutput getOutput(int index) {
		return (FoxSlotOutput) findSlot(FoxSlotOutput.class, index);
	}
}
