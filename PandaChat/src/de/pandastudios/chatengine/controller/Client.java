package de.pandastudios.chatengine.controller;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import de.pandastudios.chatengine.config.Config;
import de.pandastudios.chatengine.io.Stream;
import de.pandastudios.chatengine.security.MacChecker;

public class Client
{
	Socket		client;
	Socket		clientUser;
	boolean		started	= false;
	Stream		stream	= new Stream();
	MacChecker	mac		= new MacChecker();

	public Client()
	{

	}

	public boolean connect()
	{
		try
		{
			
			mac.getMacAddress();
			if (Config.getIsRunning())
			{
				client = new Socket("localhost", 8008);
				JOptionPane.showMessageDialog(null, "Client Connected to Server!", "", JOptionPane.INFORMATION_MESSAGE);
				started = true;
				stream.setUpStream(client);
				
				return true;
			} 
			else
			{
				System.out.println("Nix geht");
				
				return false;
			}
		} catch (UnknownHostException uhe)
		{
			System.out.println(uhe.getMessage());
			return false;
		} catch (IOException ioe)
		{
			System.out.println(ioe.getMessage());
			return false;
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
		
	}

	public boolean connected()
	{
		return started;
	}

	public void disconnect()
	{
		try
		{
			client.close();
		} catch (IOException ioe)
		{
			System.out.println(ioe.getMessage());
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	public String getMessage(DefaultListModel listMessages)
	{
		try
		{
			while (!Thread.currentThread().isInterrupted())
			{
				String message = (String) stream.getInput().readObject();
				listMessages.addElement(message);
			}
		} catch (IOException ioe)
		{
			System.out.println(ioe.getMessage());
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return "";
	}

	public void writeMessage(String message)
	{
		try
		{
			stream.getOutput().writeObject(message);
			stream.getOutput().flush();
		} catch (IOException e)
		{
			System.out.println("Error write Message!");
		}
	}
}
