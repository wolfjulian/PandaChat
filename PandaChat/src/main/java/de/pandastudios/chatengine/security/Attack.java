package de.pandastudios.chatengine.security;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import de.pandastudios.main.ClientMain;

public class Attack
{
	private static final int	MYTHREADS	= 8;
	static ExecutorService		executor	= Executors.newFixedThreadPool(MYTHREADS);

	public static void createClients() throws UnknownHostException, SocketException
	{
		while (!Thread.currentThread().isInterrupted())
		{
			//new ChatMain().getClient().writeMessage("DDOS");
		}
	}

	public Attack()
	{
		executor.execute(new Runnable()
		{
			@Override
			public void run()
			{
				// TODO Auto-generated method stub
				try
				{
					createClients();
				} 
				catch (UnknownHostException | SocketException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		new Attack();
	}
}
