package de.pandastudios.chatengine.usermanagement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import de.pandastudios.main.ServerMain;


public class DatabaseHandler {

	// Zeile 1
	
	public static void main(String[] args) {
		DatabaseHandler handler = new DatabaseHandler();
	}

	public DatabaseHandler() {
		UiLogin ui = new UiLogin();
		ui.setVisible(true);

		ui.getBtnLogin().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadUser(ui.getTextName().getText(), ui.getTextPassword().getText());
			}
		});
	}

	public void loadUser(String name, String passwort) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			Connection con = DriverManager.getConnection("jdbc:ucanaccess://D:/PandaChat.accdb");

			//Statement geilesStatement = con.createStatement();
			//geilesStatement.execute("INSERT INTO User (Benutzername, Chatname, Passwort, RegistriertSeit, GebanntBis, Moderator, Admin) "
			//		+ "VALUES                         ( 'Schnitzel', 'GeilesSchnitzel', 'Schnitzel',  )");
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM TestTabelle");
			while (rs.next())
				System.out.println( rs.getInt(1) + rs.getString(2) );
			con.close();
		} catch (Exception e) {
			System.out.println(e);
			System.out.print("DA GEHT WAS NISCH ):");
		}
	}

}
