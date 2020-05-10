package de.pandastudios.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.SocketException;
import java.net.UnknownHostException;

import de.pandastudios.chatengine.config.Config;
import de.pandastudios.chatengine.controller.Client;
import de.pandastudios.chatengine.graphics.ClientView;
import de.pandastudios.chatengine.io.Message;

public class ClientMain
{
	ClientView view;
	Client client;
	Message msg;
	
	public ClientMain()
	{
		client = new Client();
		setView();
	}
	
	private void setView()
	{
		view = new ClientView();
		view.setVisible(true);

		BtnClientStartActionListener btnStart = new BtnClientStartActionListener();
		view.btnStartAddActionListener(btnStart);
		BtnSendActionListener btnSenden = new BtnSendActionListener();
		view.btnSendAddActionListener(btnSenden);
	}
	
	public class BtnClientStartActionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if (!client.connected())
			{
				try 
				{
					client.connect();
				} 
				catch (Exception e1) 
				{

					e1.printStackTrace();
				}
				view.getListMessages().setModel(view.getModel());
				view.getComboBoxServer().setModel(view.getModelId());
				
				new Thread(new Runnable()
				{
					@Override
					public void run()
					{

						client.getMessage(view.getModel());
					}
				}).start();
			}
		}
	}		
	
	
	public Client getClient()
	{
		return client;
	}

	public class BtnSendActionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			msg = new Message();
			msg.writeMessage(view.getTextFieldInput().getText());
			if(msg.getSize() > Config.getStreamSize()) 
			{
				System.out.println("ERROR to big for sending");
			} 
			else 
			{
				//Stoppen des Timers
				client.watch.stop();
				//Überprüfen, ob die Zeit zwischen den Nachrichten 2 Sekunden überschreitet
				if(client.watch.getTime() < 2000)
				{
					//Falls Ja - Fehlermeldung und zurücksetzten des Timers, sowie neu aufruf
					System.out.println("Spam protection - try again in a few seconds");
					client.watch.reset();
					client.watch.start();
				}
				else
				{
					//Falls Nein - Zurücksetzten des Timers & Nachricht versenden 
					client.watch.reset();
					client.writeMessage(msg);
					view.getTextFieldInput().setText("");	
				}
				
			}
		}
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		new ClientMain();
	}
}
