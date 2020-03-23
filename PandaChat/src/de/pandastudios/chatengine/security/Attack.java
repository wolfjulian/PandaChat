package de.pandastudios.chatengine.security;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import de.pandastudios.main.ClientMain;
import de.pandastudios.main.ServerMain;

public class Attack
{
	private static final int MYTHREADS = 2;
	static ExecutorService executor = Executors.newFixedThreadPool(MYTHREADS);
	
	public static void createClients()
	{
			while(!Thread.currentThread().isInterrupted()) 
			{
				new ClientMain().getClient().writeMessage("DDOS");
			}	
	}

	
	public static void main(String[] args)
	{
		executor.execute(new Runnable() {
			@Override
			public void run()
			{
				// TODO Auto-generated method stub
				createClients();
			}
		});
	}
	
}

