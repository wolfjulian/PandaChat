package de.pandastudios.chatengine.config;

import java.net.InetAddress;
import java.net.SocketAddress;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.pandastudios.chatengine.controller.Proxy;

public class Config {
	static ArrayList<String> macArray = new ArrayList<String>();
	static ArrayList<Proxy> pArray = new ArrayList<Proxy>();
	static HashMap<InetAddress, Timestamp> map = new HashMap<InetAddress, Timestamp>();
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

	public static HashMap<InetAddress, Timestamp> getMap() {
		return map;
	} 
	

}
