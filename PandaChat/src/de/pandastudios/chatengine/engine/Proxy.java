package de.pandastudios.chatengine.engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.DefaultListModel;

import de.pandastudios.chatengine.io.Stream;

public class Proxy extends Thread{
	Socket client;
	DefaultListModel nachrichten;
	Stream stream = new Stream();
	private static int id = 0;
	
	public Proxy(Socket client, DefaultListModel nachrichten)
	{
		this.client = client;
		this.nachrichten = nachrichten;
		id++;
		try {
			stream.setUpStream(client);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Socket getClient()
	{
		return client;
	}
	
	public long getId()
	{
		return id;
	}
	
	public void run()
	{
		try
		{
			String message = (String) stream.getInput().readObject();
			nachrichten.addElement(message);
		}
		catch(IOException ioe)
		{
			System.out.println(ioe.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void writeMessage(String message)
	{
		try {
			stream.getOutput().writeObject(message);
			stream.getOutput().flush();
		} catch (IOException e) {
			System.out.println("Error write Message!");
		}
	}
}
