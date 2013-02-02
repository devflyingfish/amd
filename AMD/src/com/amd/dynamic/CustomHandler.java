package com.amd.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CustomHandler implements InvocationHandler {
	
	private Proxy proxy;

	public CustomHandler(Proxy proxy) {
		this.proxy = proxy;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}

}
