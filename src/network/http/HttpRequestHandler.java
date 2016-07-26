package network.http;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class HttpRequestHandler implements Runnable{
	private Socket requestSocket; 
	public HttpRequestHandler(Socket requestSocket){
		this.requestSocket = requestSocket;
	}
	
	@Override
	public void run() {
		try {
			InputStream reader = this.requestSocket.getInputStream();
			OutputStream writer = this.requestSocket.getOutputStream();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	

}
