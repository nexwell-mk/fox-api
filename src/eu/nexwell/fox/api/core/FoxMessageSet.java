package eu.nexwell.fox.api.core;

import java.util.ArrayList;

class FoxMessageSet extends FoxMessage {

	int slotIndex;
	String setArgs;
	
	public FoxMessageSet() {
		slotIndex = 0;
		setArgs = "";
	}
	
	@Override
	protected void prepareMessage() {
		message = String.format("set %d %s", slotIndex, setArgs);
	}
	
	void setSlotIndex(int index) {
		slotIndex = index;
	}
	
	void setArgs(ArrayList<Integer> args) {
		StringBuilder builder = new StringBuilder();
		for (Integer i : args) {
			builder.append(i);
			builder.append(" ");
		}
		setArgs = builder.toString().trim();
	}

	@Override
	protected void interpretMessage() {
		// TODO Auto-generated method stub
		
	}

}
