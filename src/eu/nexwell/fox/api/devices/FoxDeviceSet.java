package eu.nexwell.fox.api.devices;

import eu.nexwell.fox.api.core.FoxDevice;
import eu.nexwell.fox.api.core.FoxException;
import eu.nexwell.fox.api.slots.FoxSlotBeep;
import eu.nexwell.fox.api.slots.FoxSlotInput;
import eu.nexwell.fox.api.slots.FoxSlotOutput;
import eu.nexwell.fox.api.slots.FoxSlotPrint;
import eu.nexwell.fox.api.slots.FoxSlotThermometer;
import eu.nexwell.fox.api.slots.FoxSlotThermostate;

public class FoxDeviceSet extends FoxDevice {

	public final static int inputsCount = 7;
	public final static int outputsCount = 7;
	public final static int beepsCount = 1;
	public final static int thermometerCount = 1;
	public final static int thermostateCount = 4;
	public final static int printCount = 1;
	
	public FoxDeviceSet(int address) throws FoxException {
		super(address);
		type = "Fox SET";
		
		for (int i = 0; i < inputsCount; i++)
			addSlot(new FoxSlotInput());
		
		for (int i = 0; i < outputsCount; i++)
			addSlot(new FoxSlotOutput());
		
		for (int i = 0; i < beepsCount; i++)
			addSlot(new FoxSlotBeep());
		
		for (int i = 0; i < thermometerCount; i++)
			addSlot(new FoxSlotThermometer());
		
		for (int i = 0; i < thermostateCount; i++)
			addSlot(new FoxSlotThermostate());
		
		for (int i = 0; i < printCount; i++)
			addSlot(new FoxSlotPrint());
	}

	public FoxSlotInput getButton(int index) {
		return (FoxSlotInput) findSlot(FoxSlotInput.class, index);
	}
	
	public FoxSlotOutput getLed(int index) {
		return (FoxSlotOutput) findSlot(FoxSlotOutput.class, index);
	}
	
	public FoxSlotBeep getSpeaker() {
		return (FoxSlotBeep) findSlot(FoxSlotBeep.class, 0);
	}
	
	public FoxSlotThermometer getThermometer() {
		return (FoxSlotThermometer) findSlot(FoxSlotThermometer.class, 0);
	}
	
	public FoxSlotThermostate getThermostate(int index) {
		return (FoxSlotThermostate) findSlot(FoxSlotThermostate.class, index);
	}
	
	public FoxSlotPrint getPrint() {
		return (FoxSlotPrint) findSlot(FoxSlotPrint.class, 0);
	}
}
