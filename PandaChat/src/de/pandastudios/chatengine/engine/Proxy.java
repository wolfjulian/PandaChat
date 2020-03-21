package de.pandastudios.chatengine.engine;

import java.io.IOException;
import java.net.Socket;

import javax.swing.DefaultListModel;

import de.pandastudios.chatengine.io.Stream;

public class Proxy extends Thread
{
	Socket	client;
	DefaultListModel messages;
	Stream	stream	= new Stream();

	public Proxy(Socket client, DefaultListModel messages)
	{
		this.client = client;
		this.messages = messages;
		try
		{
			stream.setUpStream(client);
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Socket getClient()
	{
		return client;
	}

	@Override
	public void run()
	{
		try
		{
			while (!Thread.currentThread().isInterrupted())
			{
				String message = (String) stream.getInput().readObject();
				message = message + "\n";
				messages.addElement(message);
			}
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

	public void writeMessage(String message)
	{
		try
		{
			stream.getOutput().writeObject(message);
			stream.getOutput().flush();
		} 
		catch (IOException e)
		{
			System.out.println("Error write Message!");
		}
	}
}
