package main;

import network.http.*;

public class Main {
	
	public static void main(String[] args) {
		HttpRequest test = new HttpRequest("GET /index.html HTTP/1.1");
		System.out.println("Request Method: "+ test.requestMethod);
		System.out.println("Request Url: " + test.requestUrl);
		System.out.println("isValid: " + test.isValid);
	}

}
