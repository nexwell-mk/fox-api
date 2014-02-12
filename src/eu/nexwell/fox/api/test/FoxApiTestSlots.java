package eu.nexwell.fox.api.test;

import java.awt.Color;

import eu.nexwell.fox.api.core.Fox;
import eu.nexwell.fox.api.core.FoxException;
import eu.nexwell.fox.api.devices.FoxDeviceDimm;
import eu.nexwell.fox.api.devices.FoxDeviceLed;
import eu.nexwell.fox.api.devices.FoxDeviceOut;
import eu.nexwell.fox.api.devices.FoxDeviceTouch;
import eu.nexwell.fox.api.slots.FoxSlotPushPull.Sequence;

public class FoxApiTestSlots implements FoxApiTest {

	@Override
	public void run(Fox fox) throws FoxException {
		
		FoxDeviceTouch foxTouch = (FoxDeviceTouch) fox.addDevice(new FoxDeviceTouch(0));
		FoxDeviceOut foxOut = (FoxDeviceOut) fox.addDevice(new FoxDeviceOut(1));
		FoxDeviceDimm foxDimm = (FoxDeviceDimm) fox.addDevice(new FoxDeviceDimm(2));
		FoxDeviceLed foxLed = (FoxDeviceLed) fox.addDevice(new FoxDeviceLed(3));
		
		foxOut.getOutput(0).toggle();
		System.out.println(String.format("Output is %s",
				foxOut.getOutput(0).isOn() ? "on" : "off"));
		foxOut.getOutput(1).pulse(50);
		foxOut.getOutput(2).pwm(100, 1900);
		foxOut.getOutput(3).flash(3000);
		foxOut.getRoller(2).doNextFromSequence(Sequence.OPEN_STOP_CLOSE_STOP);
		
		System.out.println(String.format("Button is %s",
				foxTouch.getButton(0).isActive() ? "pressed" : "released"));
		for (int i = 1000; i <= 3000; i *= 1.25) {
			foxTouch.getSpeaker().play(i, 25);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				;
			}
		}
		for (int i = 0; i < 6; i++)
			foxTouch.getLed(i).toggle();
		double temperature = foxTouch.getThermometer().getTemperature();
		System.out.println(String.format("Temperature: %.1f °C", temperature));
		foxTouch.getThermostate(0).turnOn(temperature - 10.0);
		foxTouch.getThermostate(1).turnOn(temperature + 10.0);
		System.out.println(String.format("Thermostates: %b %b",
				foxTouch.getThermostate(0).isActive(),
				foxTouch.getThermostate(1).isActive()));
		
		foxDimm.getDimmer(0).toggle();
		foxDimm.getDimmer(1).turnOn(0.25f);
		foxDimm.getDimmer(2).turnOn(0.75f);
		foxDimm.getDimmer(3).sweep();
		
		foxLed.getLed(0).toggle();
		foxLed.getLed(1).turnOn(0.25f);
		foxLed.getLed(2).turnOn(0.75f);
		foxLed.getLed(3).sweep();
		foxLed.getRGB(1).turnOn(new Color(128, 255, 0));
	}

}
