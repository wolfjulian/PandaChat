package de.pandastudios.chatengine.security;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import de.pandastudios.chatengine.config.Config;

public class IPChecker
{	
	long delay = 2000;
	
	public IPChecker()
	{

	}

	public void getIPAdress(Socket socket)
	{
		compairPastTime(socket);
	}
	
	public Timestamp getTimeStamp() {
		Date date= new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);
		return ts;
	}
	
	public void getHashMap(Socket socket) {
		Config.getMap().put(transformAddress(socket).getAddress(), getTimeStamp());
		System.out.println(Config.getMap().get(transformAddress(socket).getAddress()));
		System.out.println(transformAddress(socket).getAddress());
	}
	
	public void compairPastTime(Socket socket) {
		if(Config.getMap().get(transformAddress(socket).getAddress()) != null) {
			if((getTimeStamp().getTime() - Config.getMap().get(transformAddress(socket).getAddress()).getTime()) > delay){
				System.out.println("DDOS");
			}
		} else {
			getHashMap(socket); 
		}
	}
	
	public InetSocketAddress transformAddress(Socket socket) {
		SocketAddress sockAddr = socket.getRemoteSocketAddress();
		InetSocketAddress inetAddr = (InetSocketAddress)sockAddr;
		return inetAddr;
	}

}
