package de.pandastudios.chatengine.controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import de.pandastudios.chatengine.config.Config;

public class Server
{
	ServerSocket server;
	Socket client;
	ArrayList<Proxy> proxylist = new ArrayList<Proxy>();

	public Server()
	{
	}

	public void broadcast(String message)
	{
		for (Proxy p : proxylist)
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
				client = server.accept();
				Proxy p = new Proxy(client, messages);
				Config.getpArray().add(client.getPort());
				p.start();
				proxylist.add(p);
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
