package eu.nexwell.fox.api.test;

import eu.nexwell.fox.api.core.Fox;
import eu.nexwell.fox.api.core.FoxException;
import eu.nexwell.fox.api.devices.FoxDeviceDimm;
import eu.nexwell.fox.api.devices.FoxDeviceLed;
import eu.nexwell.fox.api.devices.FoxDeviceOut;
import eu.nexwell.fox.api.devices.FoxDeviceTouch;
import eu.nexwell.fox.api.slots.FoxSlotInput;
import eu.nexwell.fox.api.slots.FoxSlotOutput;

public class FoxApiTestLabels implements FoxApiTest {

	@Override
	public void run(Fox fox) throws FoxException {
		
		FoxDeviceTouch foxTouch = (FoxDeviceTouch) fox.addDevice(new FoxDeviceTouch(0));
		FoxDeviceOut foxOut = (FoxDeviceOut) fox.addDevice(new FoxDeviceOut(1));
		FoxDeviceDimm foxDimm = (FoxDeviceDimm) fox.addDevice(new FoxDeviceDimm(2));
		FoxDeviceLed foxLed = (FoxDeviceLed) fox.addDevice(new FoxDeviceLed(3));
		
		foxTouch.getButton(0).label("foo");
		foxTouch.getButton(1).label("bar");
		
		int label = 0;
		for (int i = 0; i < FoxDeviceOut.outputsCount; i++)
			foxOut.getOutput(i).label(label++);
		for (int i = 0; i < FoxDeviceDimm.outputsCount; i++)
			foxDimm.getOutput(i).label(label++);
		for (int i = 0; i < FoxDeviceLed.outputsCount; i++)
			foxLed.getOutput(i).label(label++);
		
		System.out.println(String.format("Foo is %s, bar is %s",
				((FoxSlotInput) fox.get("foo")).isActive() ? "pressed" : "released",
				((FoxSlotInput) fox.get("bar")).isActive() ? "pressed" : "released"));
		
		for (int i = 0; i < label; i++) {
			FoxSlotOutput output = (FoxSlotOutput) fox.get(i);
			output.toggle();
			System.out.println(String.format("Output %d is %s",
					i, output.isOn() ? "on" : "off"));
		}
		
		foxTouch.getButton(0).label("foo-duplicated");
		
		try {
			foxTouch.getButton(2).label("bar");
			System.err.println("This should not happen!");
		}
		catch (Exception ex) {
			System.out.println(String.format("Expected exception: %s",
					ex.getMessage()));
		}
	}

}
