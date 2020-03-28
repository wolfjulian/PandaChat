package de.pandastudios.chatengine.security;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.file.FileSystems;
import java.sql.Timestamp;
import java.util.Date;
import de.pandastudios.chatengine.config.Config;
import de.pandastudios.chatengine.utils.fileUtils;


public class IPChecker
{
	long delay = 2000;


	public IPChecker()
	{

	}

	public void compairPastTime(Socket socket)
	{
		if (Config.getMap().get(transformAddress(socket).getAddress()) != null)
		{
			if ((getTimeStamp().getTime()
					- Config.getMap().get(transformAddress(socket).getAddress()).getTime()) > 3000)
			{
				try
				{
					fileUtils.writeAsString(Config.getPath(), transformAddress(socket).getAddress().toString());
					//System.out.println(fileUtils.loadAsString(Config.getPath()));
					socket.close();
					
					// schreibe IP in die Banliste
					// prüfe im Server ob die Ip des Sockets in der Liste steht
					
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else
		{
			getHashMap(socket);
		}
	}

	public void getHashMap(Socket socket)
	{
		Config.getMap().put(transformAddress(socket).getAddress(), getTimeStamp());
		System.out.println(Config.getMap().get(transformAddress(socket).getAddress()));
		System.out.println(transformAddress(socket).getAddress());
	}

	public void getIPAdress(Socket socket)
	{
		compairPastTime(socket);
	}

	public Timestamp getTimeStamp()
	{
		Date date = new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);
		return ts;
	}



	public InetSocketAddress transformAddress(Socket socket)
	{
		SocketAddress sockAddr = socket.getRemoteSocketAddress();
		InetSocketAddress inetAddr = (InetSocketAddress)sockAddr;
		
		return inetAddr;
	}

}
