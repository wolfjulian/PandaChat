package de.pandastudios.chatengine.security;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

import de.pandastudios.chatengine.config.*;

public class Port implements Runnable{
	
	private int pStart;
	private int pEnd;
	private String host;
	

	@Override
	public void run() {
		for(int i = pStart; i < pEnd; i++) {
			try {
				SocketAddress addr = new InetSocketAddress("localhost", i);
				Socket sock = new Socket();
				sock.connect(addr, 200);
				
			} catch (Exception e) {
				
			}
		}
		
	}
	
}
