package de.pandastudios.chatengine.security;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

import de.pandastudios.chatengine.config.Config;

public class MacChecker {
	
	private InetAddress ip;
	private StringBuilder sb = new StringBuilder();
	private Boolean isRunning = false;
	
	
	public MacChecker() {

	}

	public void getMacAddress() throws UnknownHostException, SocketException {
		ip = InetAddress.getLocalHost();
		NetworkInterface network = NetworkInterface.getByInetAddress(ip);
		byte[] mac = network.getHardwareAddress();
		for (int i = 0; i < mac.length; i++) {
			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
		}
		if(Config.getMacArray().contains(sb.toString())) {
			System.out.println("DDOS");
			isRunning = true;
		} else Config.getMacArray().add(sb.toString());
	}
	
	public void deleteMacAddress() throws UnknownHostException, SocketException {
		ip = InetAddress.getLocalHost();
		NetworkInterface network = NetworkInterface.getByInetAddress(ip);
		byte[] mac = network.getHardwareAddress();
		for (int i = 0; i < mac.length; i++) {
			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
		}
		Config.getMacArray().remove(sb.toString());
	}

	public Boolean getIsRunning() {
		return isRunning;
	}
	
	
}
