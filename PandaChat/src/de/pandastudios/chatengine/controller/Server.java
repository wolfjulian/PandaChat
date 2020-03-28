package de.pandastudios.chatengine.controller;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import de.pandastudios.chatengine.config.Config;
import de.pandastudios.chatengine.security.IPChecker;

public class Server
{
	ServerSocket server;
	Socket client;


	public Server()
	{
	}

	public void broadcast(String message)
	{
		for (Proxy p : Config.getpArray())
		{
			p.writeMessage(message);
		}
	}

	public void startServer(int port, DefaultListModel messages)
	{
		try
		{
			server = new ServerSocket(port);
			JOptionPane.showMessageDialog(null, "Server Up", "", JOptionPane.INFORMATION_MESSAGE);
			// server.setSoTimeout(1000);

			while (!Thread.currentThread().isInterrupted())
			{
				if(Config.getCountClients() <= Config.getMaxClients())
				{
					client = server.accept();
					Proxy p = new Proxy(client, messages);
					new IPChecker().getIPAdress(client);
					Thread t1 = new Thread(p);
					t1.start();
					Config.getpArray().add(p);
					Config.setCountClients(Config.getCountClients()+1);
				}
				
			}
		} 
		catch (IOException ioe)
		{
			JOptionPane.showMessageDialog(null, ioe.getMessage(), "IOExceptionS", JOptionPane.INFORMATION_MESSAGE);
		} 
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), "Exception", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
}
