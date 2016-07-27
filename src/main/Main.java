package main;

import java.io.IOException;
import java.util.Scanner;

import network.http.*;

public class Main {
	
	public static void main(String[] args) {
		HttpResponseConfig.loadConfig();
		System.out.println(HttpResponseConfig.fileTypeMap);
		HttpRequestDispatcher server;
		try {
			server = new HttpRequestDispatcher(9000);
			server.start();
			Scanner scanner = new Scanner(System.in);
			scanner.nextLine();
			server.interrupt();
			scanner.close();
			System.out.println("Server Interrupted");
		} catch (IOException e) {
			System.out.println("Unable to start Server");
			e.printStackTrace();
			System.exit(-1);
		}
	}

}
