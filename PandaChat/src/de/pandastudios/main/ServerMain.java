package de.pandastudios.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JList;

import de.pandastudios.chatengine.controller.Server;
import de.pandastudios.chatengine.graphics.ServerView;
import de.pandastudios.chatengine.security.Attack;

public class ServerMain
{
	ServerView view;
	Server server;

	public ServerMain()
	{
		setView();
		server = new Server();
	}
	
	private void setView()
	{
		view = new ServerView();
		view.getList().setSize(309, 157);
		view.getScrollPane().setSize(309, 157);
		view.getScrollPane().setLocation(10, 38);
		view.getList().setLocation(10, 38);
		view.setVisible(true);

		BtnStartActionListener btnStart = new BtnStartActionListener();
		view.btnStartAddActionListener(btnStart);
		txtPortActionListener txtPort = new txtPortActionListener();
		view.txtPortAddActionListener(txtPort);
		BtnSendActionListener btnSend = new BtnSendActionListener();
		view.btnSendAddActionListener(btnSend);
	}

	
	public class BtnSendActionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			// TODO Auto-generated method stub
			server.broadcast(view.getTextFieldBroadcast().getText());
			view.getTextFieldBroadcast().setText("");
		}
	}

	public class BtnStartActionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			new Thread(new Runnable()
			{
				@Override
				public void run()
				{
					server.startServer(Integer.parseInt(view.getTextFieldPort().getText()), view.getNachrichten());
				}
			}).start();

			view.getList().setModel(view.getNachrichten());
			view.getScrollPane().setViewportView(view.getList());
			view.getList().setLayoutOrientation(JList.VERTICAL);
			
		}
	}

	public class txtPortActionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			view.getBtnStart().setVisible(true);
		}
	}

	public static void main(String[] args)
	{
		new ServerMain();

	}
}
