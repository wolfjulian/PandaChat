package de.pandastudios.chatengine.security;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import de.pandastudios.main.ClientMain;
import de.pandastudios.main.ServerMain;

public class Attack
{
	public Attack() {
		executor.execute(new Runnable() {
			@Override
			public void run()
			{
				// TODO Auto-generated method stub
				try {
					createClients();
				} catch (UnknownHostException | SocketException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	private static final int MYTHREADS = 8;
	static ExecutorService executor = Executors.newFixedThreadPool(MYTHREADS);
	
	public static void createClients() throws UnknownHostException, SocketException
	{
			while(!Thread.currentThread().isInterrupted()) 
			{
				new ClientMain().getClient().writeMessage("DDOS");
			}	
	}

	
}

