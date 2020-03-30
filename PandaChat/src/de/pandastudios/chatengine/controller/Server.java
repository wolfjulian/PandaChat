package de.pandastudios.chatengine.controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import de.pandastudios.chatengine.config.Config;
import de.pandastudios.chatengine.security.IPChecker;
import de.pandastudios.chatengine.security.ShareTraffic;
import de.pandastudios.chatengine.utils.fileUtils;

public class Server
{
	ServerSocket	server;
	Socket			client;
	IPChecker		ipCh	= new IPChecker();

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
			Thread tShare = new Thread(new ShareTraffic());
			tShare.start();
			

			while (!Thread.currentThread().isInterrupted())
			{
				if (Config.getCountClients() <= Config.getMaxClients())
				{
					client = server.accept();
					Config.setActualClient(ipCh.transformAddress(client));
					Config.setInput(fileUtils.loadAsString(Config.getNioPath()).split("\n"));
					//Config.setInput(fileUtils.loadAsString(Config.getPath()).split("\n"));
					for (int i = 0; i < Config.getInput().length; i++)
					{
						if (Config.getActualClient().getAddress().toString().equals(Config.getInput()[i]))
						{
							System.out.println("BANNED");
							client.close();
						}
					}
					Proxy p = new Proxy(client, messages);
					ipCh.getIPAdress(client);
					Thread t1 = new Thread(p);
					t1.start();
					Config.getpArray().add(p);
					Config.setCountClients(Config.getCountClients() + 1);
					
				}
			}
			
			
		} catch (IOException ioe)
		{
			JOptionPane.showMessageDialog(null, ioe.getMessage(), "IOExceptionS", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), "Exception", JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
