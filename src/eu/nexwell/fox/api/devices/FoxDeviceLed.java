package eu.nexwell.fox.api.devices;

import eu.nexwell.fox.api.core.FoxDevice;
import eu.nexwell.fox.api.core.FoxException;
import eu.nexwell.fox.api.slots.FoxSlotColour;
import eu.nexwell.fox.api.slots.FoxSlotLevel;
import eu.nexwell.fox.api.slots.FoxSlotOutput;

public class FoxDeviceLed extends FoxDevice {
	
	public final static int outputsCount = 10;
	public final static int levelsCount = 8;
	public final static int coloursCount = 2;
	
	public FoxDeviceLed(int address) throws FoxException {
		super(address);
		type = "Fox LED";
		
		for (int i = 0; i < outputsCount; i++)
			addSlot(new FoxSlotOutput());
		
		for (int i = 0; i < levelsCount; i++)
			addSlot(new FoxSlotLevel());
		
		for (int i = 0; i < coloursCount; i++)
			addSlot(new FoxSlotColour());
	}
	
	public FoxSlotOutput getOutput(int index) {
		return (FoxSlotOutput) findSlot(FoxSlotOutput.class, index);
	}
	
	public FoxSlotLevel getLed(int index) {
		return (FoxSlotLevel) findSlot(FoxSlotLevel.class, index);
	}
	
	public FoxSlotColour getRGB(int index) {
		return (FoxSlotColour) findSlot(FoxSlotColour.class, index);
	}

}
