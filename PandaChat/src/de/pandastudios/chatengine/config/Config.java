package de.pandastudios.chatengine.config;

import java.util.ArrayList;

import de.pandastudios.chatengine.controller.Proxy;

public class Config {
	static ArrayList<String> macArray = new ArrayList<String>();
	static ArrayList<Proxy> pArray = new ArrayList<Proxy>();

	public static ArrayList<Proxy> getpArray() {
		return pArray;
	}

	public static ArrayList<String> getMacArray() {
		return macArray;
	} 
	
	
	
}
