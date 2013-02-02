package com.amd.remote;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TCPServer implements Runnable{
	private ServerSocket serverSocket;
	private Container container;
	private ExecutorService executor = Executors.newFixedThreadPool(3);
	
	public TCPServer(int port, Container container) throws IOException {
		this.serverSocket = new ServerSocket(port);
		this.container = container;
	}

	@Override
	public void run() {
		while(true){
			try {
				Socket socket = serverSocket.accept();
				executor.execute(new RequestHandler(socket, container));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
