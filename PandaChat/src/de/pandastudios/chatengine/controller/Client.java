package de.pandastudios.chatengine.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import de.pandastudios.chatengine.io.Stream;
import de.pandastudios.chatengine.security.MacChecker;

public class Client 
{
	Socket	client;
	Socket clientUser;
	boolean	started	= false;
	Stream	stream	= new Stream();
	MacChecker mac = new MacChecker();

	public Client() throws UnknownHostException, SocketException
	{
		
	}

	public void connect()
	{
		try
		{
			
			client = new Socket("localhost", 8008);
			JOptionPane.showMessageDialog(null, "Client Connected to Server!", "", JOptionPane.INFORMATION_MESSAGE);
			started = true;
			mac.getMacAddress();
			if(!mac.getIsRunning()) {
				stream.setUpStream(client);
			} else {
				client.close(); 
				System.out.println("Nix geht");
			}
		} catch (UnknownHostException uhe)
		{
			System.out.println(uhe.getMessage());
		} catch (IOException ioe)
		{
			System.out.println(ioe.getMessage());
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
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
