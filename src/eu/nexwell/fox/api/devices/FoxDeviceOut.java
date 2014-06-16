package eu.nexwell.fox.api.devices;

import eu.nexwell.fox.api.core.FoxDevice;
import eu.nexwell.fox.api.core.FoxException;
import eu.nexwell.fox.api.slots.FoxSlotInput;
import eu.nexwell.fox.api.slots.FoxSlotOutput;
import eu.nexwell.fox.api.slots.FoxSlotPushPull;


public class FoxDeviceOut extends FoxDevice {

	public final static int inputsCount = 8;
	public final static int outputsCount = 8;
	public final static int pushPullsCount = 4;
	
	public FoxDeviceOut(int address) throws FoxException {
		super(address);
		type = "Fox OUT";
		
		for (int i = 0; i < inputsCount; i++)
			addSlot(new FoxSlotInput());
		
		for (int i = 0; i < outputsCount; i++)
			addSlot(new FoxSlotOutput());
		
		for (int i = 0; i < pushPullsCount; i++)
			addSlot(new FoxSlotPushPull());
	}
	
	public FoxSlotInput getButton(int index) {
		return (FoxSlotInput) findSlot(FoxSlotInput.class, index);
	}
	
	public FoxSlotOutput getOutput(int index) {
		return (FoxSlotOutput) findSlot(FoxSlotOutput.class, index);
	}
	
	public FoxSlotPushPull getRoller(int index) {
		return (FoxSlotPushPull) findSlot(FoxSlotPushPull.class, index);
	}
}
