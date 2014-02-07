package eu.nexwell.fox.api.core;

class FoxMessageHello extends FoxMessage {

	public FoxMessageHello() {
		super();
	}

	@Override
	protected void prepareMessage() {
		message = "hello";
	}

	@Override
	protected void interpretMessage() {
		
	}
}
