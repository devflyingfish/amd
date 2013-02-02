package com.amd.bean.impl;

import com.amd.bean.Salarie;

public class SalarieImpl implements Salarie {
	private String name;
	private double salary;

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public synchronized void setName(String name) {
		this.name = name;
	}

	@Override
	public double getSalary() {
		return this.salary;
	}

	@Override
	public synchronized void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public synchronized void raiseSalary(double amount) {
		//Simuler operation longue
		try {
			Thread.currentThread().sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.salary += amount;
	}

}
