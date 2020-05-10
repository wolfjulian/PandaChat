package de.pandastudios.chatengine.controller;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Timer;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import org.apache.commons.lang3.time.StopWatch;

import de.pandastudios.chatengine.config.Config;
import de.pandastudios.chatengine.io.Message;
import de.pandastudios.chatengine.io.Stream;
import de.pandastudios.chatengine.security.IPChecker;

public class Client
{
	Socket		client;
	Socket		clientUser;
	boolean		started	= false;
	Stream		stream	= new Stream();
	IPChecker	mac		= new IPChecker();
	//Timer für den Spamschutz
	public StopWatch watch = new StopWatch();

	public Client()
	{

	}

	public void connect() throws Exception
	{
		client = new Socket("localhost", 8008);
		JOptionPane.showMessageDialog(null, "Client Connected to Server!", "", JOptionPane.INFORMATION_MESSAGE);
		started = true;
		stream.setUpStream(client);
		watch.start();
	}

	public boolean connected()
	{
		return started;
	}

	public void setStarted(boolean started)
	{
		this.started = started;
	}

	public void disconnect()
	{
		try
		{
			client.close();
		} 
		catch (IOException ioe)
		{
			System.out.println(ioe.getMessage());
		} 
		catch (Exception e)
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
		} 
		catch (IOException ioe)
		{
			System.out.println(ioe.getMessage());
			started = false;
		} 
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			started = false;
		}
		return "";
	}

	public void writeMessage(Message message)
	{
		try
		{
			stream.getOutput().writeObject(message.toString());
			stream.getOutput().flush();
			//Timerstart für Spamschutz
			watch.start();
			//Config.setSending(true);
		} 
		catch (IOException e)
		{
			System.out.println("Error write Message!");
		}
	}
}
