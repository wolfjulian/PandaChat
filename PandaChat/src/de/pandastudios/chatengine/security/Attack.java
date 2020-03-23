package de.pandastudios.chatengine.security;

import de.pandastudios.main.ClientMain;
import de.pandastudios.main.ServerMain;

public class Attack
{
	public Attack()
	{
		
	}
	
	public static void createClients()
	{
		new Thread(new Runnable(){
		@Override
		public void run(){
			while(true) {
				try
				{
					Thread.currentThread().sleep(0);
				} catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				new ClientMain();
			}
			}}).start();
	}
	
	public static void main(String[] args)
	{
		createClients();
	}
}
