package de.pandastudios.chatengine.engine;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import de.pandastudios.chatengine.io.Stream;

public class Client {
	Socket client;
	boolean started = false;
	Stream stream = new Stream();
	
	public Client(){
		
	}
	
	public void connect(){
		try	{			
			if(!started)
			{
				client = new Socket("localhost", 8008);
				JOptionPane.showMessageDialog(null,"Client gestartet!","", JOptionPane.INFORMATION_MESSAGE);
			}
			started = true;
			stream.setUpStream(client);
		} catch(UnknownHostException uhe) {
			System.out.println(uhe.getMessage());
		} catch(IOException ioe) {
			System.out.println(ioe.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String getMessage(DefaultListModel listeMessages) {
		try	{		
			while(!Thread.currentThread().isInterrupted()) {
				String message = (String) stream.getInput().readObject();
				listeMessages.addElement(message);
				}
		} catch(IOException ioe) {
			System.out.println(ioe.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return "";		
	}
	
	public void writeMessage(String message) {
		try {
			stream.getOutput().writeObject(message);
			stream.getOutput().flush();
		} catch (IOException e) {
			System.out.println("Error write Message!");
		}
	}
	
	public void disconnect() {
		try {
			client.close();
		} catch(IOException ioe) {
			System.out.println(ioe.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}	
	}
	
}
