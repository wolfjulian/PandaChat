package de.pandastudios.chatengine.controller;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
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

	public Client()
	{

	}

	public void connect() throws Exception
	{
		client = new Socket("localhost", 8008);
		JOptionPane.showMessageDialog(null, "Client Connected to Server!", "", JOptionPane.INFORMATION_MESSAGE);
		started = true;
		stream.setUpStream(client);
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
			Config.setSending(true);
		} 
		catch (IOException e)
		{
			System.out.println("Error write Message! in Client.Java");
		}
	}
	
//	public void writeImgMessage(Message message)
//	{
//		
//		try
//		{
//			ImageIO.write(message.getBimg(),"JPG",client.getOutputStream());
//			System.out.println("1. Succes");
//		}catch(IOException e)
//		{
//			System.out.println("Error write client.IMGMessage !");
//		}
//	}
//	public String getImgMessage(DefaultListModel listMessages)
//	{
//		try
//		{
//			while (!Thread.currentThread().isInterrupted())
//			{
//				
//				String message = (String) stream.getInput().readObject();
//				listMessages.addElement(message);
//			}
//		} 
//		catch (IOException ioe)
//		{
//			System.out.println(ioe.getMessage());
//			started = false;
//		} 
//		catch (Exception e)
//		{
//			System.out.println(e.getMessage());
//			started = false;
//		}
//		return "";
//	}
	
}
