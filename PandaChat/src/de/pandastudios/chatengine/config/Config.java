package de.pandastudios.chatengine.config;

import java.util.ArrayList;

import de.pandastudios.chatengine.controller.Proxy;

public class Config {
	static ArrayList<String> macArray = new ArrayList<String>();
	static ArrayList<Proxy> pArray = new ArrayList<Proxy>();
	private static Boolean	isRunning	= false;

	public static void setIsRunning(Boolean isRunning)
	{
		Config.isRunning = isRunning;
	}

	public static Boolean getIsRunning()
	{
		return isRunning;
	}

	public static ArrayList<Proxy> getpArray() {
		return pArray;
	}

	public static ArrayList<String> getMacArray() {
		return macArray;
	} 
	
	
	
}
