package com.amd.bean;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Salarie extends Remote{
	public String getName() throws RemoteException;
	public void setName(String name)throws RemoteException;
	public double getSalary()throws RemoteException;
	public void setSalary(double salary)throws RemoteException;
	public void raiseSalary(double amount)throws RemoteException;
}
