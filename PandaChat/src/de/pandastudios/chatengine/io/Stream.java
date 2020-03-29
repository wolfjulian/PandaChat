package de.pandastudios.chatengine.io;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Stream
{
	private ObjectInputStream input;
	private ObjectOutputStream output;
	
	public Stream()
	{

	}

	public ObjectInputStream getInput()
	{
		return input;
	}

	public ObjectOutputStream getOutput()
	{
		return output;
	}

	public void setUpStream(Socket connection) throws Exception
	{
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();
		input = new ObjectInputStream(connection.getInputStream());
		System.out.println("Streams up -> Server");
	}

}
