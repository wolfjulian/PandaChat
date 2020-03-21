package de.pandastudios.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.pandastudios.chatengine.engine.Client;
import de.pandastudios.chatengine.graphics.ClientView;


public class ClientMain {
	
	ClientView view;
	Client client;

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

	public ClientMain() {
		client = new Client();
		setView();
	}
	
	private void setView() {
		view = new ClientView();
		view.setVisible(true);

		BtnClientStartActionListener btnStart = new BtnClientStartActionListener();
		view.btnStartAddActionListener(btnStart);
		BtnSendenActionListener btnSenden = new BtnSendenActionListener();
		view.btnSendenAddActionListener(btnSenden);	
	}
	
	public class BtnSendenActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			client.writeMessage(view.getTextFieldEingabe().getText());
			view.getTextFieldEingabe().setText("");
		}	
	}
	
	public class BtnClientStartActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			client.connect();
			view.getListMessages().setModel(view.getModel());
			view.getComboBoxServer().setModel(view.getModelId());
			new Thread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
						client.getMessage(view.getModel());
				}}).start();
		}
	}
}
