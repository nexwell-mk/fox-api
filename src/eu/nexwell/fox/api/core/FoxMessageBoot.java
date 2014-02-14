package eu.nexwell.fox.api.core;

class FoxMessageBoot extends FoxMessage {

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
