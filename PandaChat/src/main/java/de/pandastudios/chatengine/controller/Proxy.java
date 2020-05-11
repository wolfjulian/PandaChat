package de.pandastudios.chatengine.controller;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.Timestamp;

import javax.swing.DefaultListModel;



import de.pandastudios.chatengine.config.Config;
import de.pandastudios.chatengine.io.Stream;

public class Proxy implements Runnable {
	Socket	client;
	DefaultListModel messages;
	Stream	stream	= new Stream();
	Timestamp timeStamp;
	Timestamp tmpTimeStamp;

	public Timestamp getTimeStamp()
	{
		return timeStamp;
	}

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
		timeStamp = Config.getTimeStamp();
		new Thread(new Runnable() 
		{
			@Override
			public void run()
			{
				compareTimeStamps();
			}
		}).start();
	}

	public Socket getClient()
	{
		return client;
	}
	
	public void compareTimeStamps()
	{
		while(!Thread.currentThread().isInterrupted())
		{
			if(Config.getTimeStamp().getTime() - timeStamp.getTime() > 900000)
			{	
				System.out.println("Client Timeout");
				try
				{
					client.close();
					Thread.currentThread().interrupt();
				} 
				catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
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
					timeStamp = Config.getTimeStamp();
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
			System.out.println("Error write Message! @Proxy");
		}
	}
//	public void writeImgMessage(String message)
//	{
//		try
//		{
//		stream.getOutput().writeObject(message);
//		stream.getOutput().flush();
//		}
//		catch(IOException e)
//		{
//			System.out.println("Error write ImgMessage @Proxy");
//		}
//	}
	
}
