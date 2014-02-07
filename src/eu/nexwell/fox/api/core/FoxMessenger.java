package eu.nexwell.fox.api.core;


public interface FoxMessenger {
	
	public void open() throws FoxException;
	public void write(String text) throws FoxException;
	public String read() throws FoxException;
	public void close() throws FoxException;
}
