package eu.nexwell.fox.api.core;

import java.math.BigInteger;
import java.util.ArrayList;


public class FoxSlot {

	protected FoxDevice parentDevice = null;
	
	public FoxSlot() {
		
	}
	
	protected int getIndex() {
		return parentDevice.getIndex(this);
	}
	
	protected void writeSet(Integer... args) throws FoxException {
		FoxMessageSet msg = new FoxMessageSet();
		msg.setDevice(parentDevice);
		msg.setSlotIndex(getIndex());
		ArrayList<Byte> argsList = new ArrayList<Byte>();
		for (Integer i : args) {
			byte[] bytes = BigInteger.valueOf(i).toByteArray();
			for (int bi = 0; bi < bytes.length; bi++) {
				byte b = bytes[(bytes.length - 1) - bi];
				if (bi < bytes.length - 1 || b != 0 || bytes.length == 1)
					argsList.add(b);
			}
		}
		msg.setArgs(argsList);
		parentDevice.getParentSystem().write(msg);
	}
	
	protected Byte[] readGet() throws FoxException {
		FoxMessageGet msgGet = new FoxMessageGet();
		msgGet.setDevice(parentDevice);
		msgGet.setSlotIndex(getIndex());
		parentDevice.getParentSystem().write(msgGet);
		FoxMessageTake msgTake = new FoxMessageTake();
		parentDevice.getParentSystem().read(msgTake);
		if (msgTake.getDevice() != parentDevice.getAddress())
			throw new FoxException("Unexpected device address");
		if (msgTake.getIndex() != getIndex())
			throw new FoxException("Unexpected slot index");
		String[] strArray = msgTake.getArgs().split(" ");
		Byte[] intArray = new Byte[strArray.length];
		for(int i = 0; i < strArray.length; i++)
		    intArray[i] = Byte.parseByte(strArray[i]);
		return intArray;
	}
	
	protected Byte[] readGet(int minSize) throws FoxException {
		Byte[] bytes = readGet();
		if (bytes.length < minSize)
			throw new FoxException("Read value list too short");
		return bytes;
	}
	
	protected int convertArg(int value, int minValue, int maxValue, int scale) {
		return convertArg(value, minValue, maxValue) / scale;
	}
	
	protected int convertArg(int value, int minValue, int maxValue) {
		if (value < minValue)
			value = minValue;
		if (value > maxValue)
			value = maxValue;
		return value;
	}
	
	void setParentDevice(FoxDevice device) {
		parentDevice = device;
	}
}
