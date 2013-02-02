package com.amd.remote;

import java.util.HashMap;
import java.util.Map;

public class Container {
	private Map<String, Object> registry = new HashMap<String, Object>();
	
	public void register(String name, Object bean){
		this.registry.put(name, bean);
	}
	
	public void unregister(String name){
		this.registry.remove(name);
	}
	
	public Object getObject(String name){
		return registry.get(name);
	}
	
	public Object getAvailable(){
		return registry.keySet();
	}

}
