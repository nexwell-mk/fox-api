package eu.nexwell.fox.api.core;

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
		ArrayList<Integer> argsList = new ArrayList<Integer>();
		for (Integer i : args)
			argsList.add(i);
		msg.setArgs(argsList);
		parentDevice.getParentSystem().write(msg);
	}
	
	protected Integer[] readGet() throws FoxException {
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
		Integer[] intArray = new Integer[strArray.length];
		for(int i = 0; i < strArray.length; i++)
		    intArray[i] = Integer.parseInt(strArray[i]);
		return intArray;
	}
	
	void setParentDevice(FoxDevice device) {
		parentDevice = device;
	}
}
