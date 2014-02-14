package eu.nexwell.fox.api.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import eu.nexwell.fox.api.core.FoxException;
import eu.nexwell.fox.api.core.FoxMessenger;

public class FoxMessengerTcpIp implements FoxMessenger {

	String host = "";
	int port = 0;
	int timeout = 250;
	PrintStream printStream = null;
	
	Socket socket;
	PrintWriter toServer;
	BufferedReader fromServer;
	
	public FoxMessengerTcpIp() {
		
	}
	
	public void setHost(String host, int port) {
		this.host = host;
		this.port = port;
	}
	
	public void setHost(String host) {
		int colon = host.indexOf(":");
		if (colon < 1)
			setHost(host, 23);
		else
			setHost(host.substring(0, colon), Integer.parseInt(host.substring(colon + 1)));
	}
	
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
	
	public void setPrintStream(PrintStream printStream) {
		this.printStream = printStream;
	}
	
	@Override
	public void open() throws FoxException {
		try {
			socket = new Socket(host, port);
			socket.setSoTimeout(timeout);
			toServer = new PrintWriter(socket.getOutputStream(),true);
			fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String prompt = read();
			if (!prompt.equals("> Fox terminal"))
				throw new FoxException("Wrong prompt received");
		} catch (IOException e) {
			throw new FoxException(e.getMessage());
		}
	}
	
	private void printData(boolean toSystem, String text) {
		if (printStream != null && text.startsWith("@"))
			printStream.println(String.format("%s Fox %s App %s",
					(new SimpleDateFormat("HH:mm:ss.SSS")).format(Calendar.getInstance().getTime()),
					toSystem ? "<--" : "-->",
					text.trim()));
	}

	@Override
	public void write(String text) throws FoxException {
		toServer.println(text);
		printData(true, text);
		readEcho(text);
	}
	
	private String readLine() {
		try {
			String line = fromServer.readLine();
			if (line == null)
				line = "";
			return line;
		} catch (IOException e) {
			return "";
		}
	}
	
	private void readEcho(String text) throws FoxException {
		String echo = readLine();
		if (!echo.equals(text.trim()))
			throw new FoxException("Wrong echo received");
	}

	@Override
	public String read() {
		String text = readLine();
		printData(false, text);
		return text;
	}

	@Override
	public void close() {
		try {
			toServer.close();
			fromServer.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
