package eu.nexwell.fox.api.core;

public class FoxMessageBoot extends FoxMessage {

	public FoxMessageBoot() {
		super();
		appToken = "god";
	}

	@Override
	protected void prepareMessage() {
		message = "boot";
	}

	@Override
	protected void interpretMessage() {
		
	}
}
