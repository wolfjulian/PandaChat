package de.pandastudios.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.pandastudios.chatengine.engine.Server;
import de.pandastudios.chatengine.graphics.ServerView;


public class ServerMain {
	
	ServerView view;
	Server server; 

	public static void main(String[] args) {
		new ServerMain();
		new ClientMain();
		new ClientMain();
		new ClientMain();
	}
	
	public ServerMain(){
		setView();
		server = new Server();
	}
	
	private void setView(){
		view = new ServerView();
		view.setVisible(true);
		
		BtnStartActionListener btnStart = new BtnStartActionListener();
		view.btnStartAddActionListener(btnStart);
		txtPortActionListener txtPort = new txtPortActionListener();
		view.txtPortAddActionListener(txtPort);
		BtnSendActionListener btnSend = new BtnSendActionListener();
		view.btnSendAddActionListener(btnSend);
	}
	
	public class BtnStartActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			new Thread(new Runnable() {
				@Override
				public void run(){
					server.startServer(Integer.parseInt(view.getTextFieldPort().getText()),view.getNachrichten());
				}}).start();
			view.getListNachrichten().setModel(view.getNachrichten());
		}
	}
	
	public class txtPortActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			view.getBtnStart().setVisible(true);
		}	
	}
	
	public class BtnSendActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e){
			// TODO Auto-generated method stub
			server.broadcast(view.getTextField_1().getText());			
			view.getTextField_1().setText("");
		}
	}
}
