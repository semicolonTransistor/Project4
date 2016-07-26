package network.http;
import java.io.IOException;
import java.net.*;

public class HttpRequestDispatcher extends Thread{
	private ServerSocket serverSocket;
	public HttpRequestDispatcher(int port) throws IOException{
		if(port<0){
			serverSocket=new ServerSocket();
		}else{
			serverSocket=new ServerSocket(port);
		}
		System.out.println("Opened server on port" + port + ".");
	}
	
	public void run(){
		while(true){
			try{
				Socket requestSocket = serverSocket.accept();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
}
