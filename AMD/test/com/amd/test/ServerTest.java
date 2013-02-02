package com.amd.test;

import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.amd.bean.Salarie;
import com.amd.bean.impl.SalarieImpl;
import com.amd.remote.Container;
import com.amd.remote.TCPServer;

public class ServerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Salarie kevin = new SalarieImpl();
		Salarie mael = new SalarieImpl();
		Container c = new Container();
		try {
			kevin.setName("Kevin");
			Salarie stub1 = (Salarie) UnicastRemoteObject.exportObject(kevin, 0);
			Salarie stub2 = (Salarie) UnicastRemoteObject.exportObject(mael, 0);
			c.register("Kevin", stub1);
			c.register("Mael", stub2);
			executor.execute(new TCPServer(1099, c));
			System.out.println(kevin.getName());
			Thread.sleep(10000);
			System.out.println(kevin.getSalary());
			Thread.sleep(10000);
			System.out.println(kevin.getSalary());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
