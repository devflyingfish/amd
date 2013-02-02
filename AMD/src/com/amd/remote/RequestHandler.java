package com.amd.remote;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class RequestHandler implements Runnable {
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private Container container;
	
	public RequestHandler(Socket socket, Container container) throws IOException {
		this.ois = new ObjectInputStream(socket.getInputStream());
		this.oos = new ObjectOutputStream(socket.getOutputStream());
		this.container = container;
	}

	@Override
	public void run() {
		try {
			Object request = ois.readObject();
			if(request instanceof String){
				oos.writeObject(container.getObject((String)request));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
