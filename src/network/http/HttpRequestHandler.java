package network.http;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import network.http.response.HttpResponse;

public class HttpRequestHandler implements Runnable{
	private Socket requestSocket; 
	private BufferedReader reader;
	private OutputStreamWriter writer;
	public HttpRequestHandler(Socket requestSocket){
		this.requestSocket = requestSocket;
	}
	
	@Override
	public void run() {
		try {
			this.reader = new BufferedReader(new InputStreamReader(this.requestSocket.getInputStream()));
			this.writer = new OutputStreamWriter(this.requestSocket.getOutputStream());
			HttpRequest httpRequest = new HttpRequest(reader.readLine());
			System.out.println(httpRequest);
			switch(httpRequest.requestMethod){
				case get:{
					processGet(httpRequest,writer);
					break;
				}
				default:{
					new HttpResponse(HttpResponse.ResponseType.forbidden,null).send(writer);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				requestSocket.close();
				if(reader != null){
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	protected void processGet(HttpRequest request,OutputStreamWriter writer) throws IOException{
		if(request.requestUrl.trim().equals("/")){
			request.requestUrl = HttpConfig.defaultUrl;
		}
		File file = new File(HttpConfig.webRoot+request.requestUrl);
		System.out.println("File name: " + file.getName());
		HttpResponse response;
		if(file.exists() && file.isFile()){
			if(file.canRead()){
				response = new HttpResponse(HttpResponse.ResponseType.ok,file);
			}else{
				response = new HttpResponse(HttpResponse.ResponseType.badRequest,null);
			}
		}else{
			response = new HttpResponse(HttpResponse.ResponseType.notFound,null);
		}
		response.send(writer);
	}
	

}
