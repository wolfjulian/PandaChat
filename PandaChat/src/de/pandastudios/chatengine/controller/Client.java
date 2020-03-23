package de.pandastudios.chatengine.controller;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import de.pandastudios.chatengine.io.Stream;

public class Client
{
	Socket	client;
	boolean	started	= false;
	Stream	stream	= new Stream();

	public Client()
	{

	}

	public void connect()
	{
		try
		{
			client = new Socket("localhost", 8008);
			JOptionPane.showMessageDialog(null, "Client Connected to Server!", "", JOptionPane.INFORMATION_MESSAGE);
			
			started = true;
			stream.setUpStream(client);
			//attack();
		} 
		catch (UnknownHostException uhe)
		{
			System.out.println(uhe.getMessage());
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
		} 
		catch (IOException ioe)
		{
			System.out.println(ioe.getMessage());
		} 
		catch (Exception e)
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
		} 
		catch (IOException e)
		{
			System.out.println("Error write Message!");
		}
	}
	
	//NUR FÜR TESTZWECKE
//	public void attack() {
//		new Thread(new Runnable(){
//			@Override
//			public void run(){
//				while(true) {
//					writeMessage("DDOS \n");
//				}
//				}}).start();
//		new Thread(new Runnable(){
//			@Override
//			public void run(){
//				while(true) {
//					writeMessage("DDOS \n");
//				}
//				}}).start();
//
//	}


}
