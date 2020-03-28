package de.pandastudios.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.SocketException;
import java.net.UnknownHostException;

import de.pandastudios.chatengine.controller.Client;
import de.pandastudios.chatengine.graphics.ClientView;

public class ClientMain
{
	ClientView view;
	Client client;
	
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
			// TODO Auto-generated method stub
			if (!client.connected())
			{
				try {
					client.connect();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				view.getListMessages().setModel(view.getModel());
				view.getComboBoxServer().setModel(view.getModelId());
				
				new Thread(new Runnable()
				{
					@Override
					public void run()
					{
						// TODO Auto-generated method stub
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
			// TODO Auto-generated method stub
			client.writeMessage(view.getTextFieldInput().getText());
			view.getTextFieldInput().setText("");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ClientMain();
	}
}
