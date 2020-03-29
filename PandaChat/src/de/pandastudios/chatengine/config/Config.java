package de.pandastudios.chatengine.config;

import java.io.BufferedReader;
import java.io.StringReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import de.pandastudios.chatengine.controller.Proxy;

public class Config {
	private static ArrayList<String> macArray = new ArrayList<String>();
	private static ArrayList<Proxy> pArray = new ArrayList<Proxy>();
	private static HashMap<InetAddress, Timestamp> map = new HashMap<InetAddress, Timestamp>();
	private static Boolean	isRunning	= false;
	private static int countClients;
	private static int maxClients = 2;
	private static String path = "C:\\Users\\lbehr\\git\\PandaChat\\PandaChat\\PandaChat\\src\\de\\pandastudios\\chatengine\\config\\banlist";
	private static String nioPath = "/PandaChat/src/de/pandastudios/chatengine/config/banlist";
	private static InetSocketAddress actualClient;
	private static String[] input;
	private static long streamSize = 2048;
	
	public static long getStreamSize() {
		return streamSize;
	}



	public static String getNioPath() {
		return nioPath;
	}



	public static String[] getInput() {
		return input;
	}

	public static void setInput(String[] input) {
		Config.input = input;
	}

	public static void setActualClient(InetSocketAddress actualClient) {
		Config.actualClient = actualClient;
	}

	public static InetSocketAddress getActualClient() {
		return actualClient;
	}

	public static int getMaxClients()
	{
		return maxClients;
	}

	public static void setCountClients(int countClients)
	{
		Config.countClients = countClients;
	}

	public static int getCountClients()
	{
		return countClients;
	}

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

	public static String getPath()
	{
		return path;
	} 
	
	public static Timestamp getTimeStamp()
	{
		Date date = new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);
		return ts;
	}
	

}
