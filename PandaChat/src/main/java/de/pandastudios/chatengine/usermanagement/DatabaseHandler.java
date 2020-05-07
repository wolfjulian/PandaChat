package de.pandastudios.chatengine.usermanagement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import de.pandastudios.main.ServerMain;
/* Singleton Klasse
* Durch das synchronized wird sicher gestellt, dass der Database-Handler Threadsafe ist
* Eigentlich nicht wirklich nötig aber sicher ist sicher.*/

public class DatabaseHandler {

	// Zeile 1
	private static DatabaseHandler instance;
	private Connection connection;

	/*Debug Main*/
	public static void main(String[] args) {
		DatabaseHandler handler = new DatabaseHandler();
		UiLogin ui = new UiLogin();
		ui.setVisible(true);

		ui.getBtnLogin().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				handler.loadUser(ui.getTextName().getText(), ui.getTextPassword().getText());
			}
		});
	}

	private DatabaseHandler() {
		//Initialisierung des Treibers
		try
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		} catch(ClassNotFoundException e)
		{
			e.printStackTrace();
			System.out.println("DatabaseHandler: Klasse nicht gefunden bei Class.forName(DBDRIVER)");
		}

		//Aufbau der Datenbankverbindung
		try
		{
			connection = DriverManager.getConnection("jdbc:ucanaccess://src/main/resources/PandaChat.accdb");
		} catch(SQLException throwables)
		{
			throwables.printStackTrace();
			System.out.println("DatabaseHandler: Verbindung zur Datenbank konnte nicht aufgebaut werden");
		}
	}

	public static synchronized DatabaseHandler getInstance(){
		if(DatabaseHandler.instance == null){
			DatabaseHandler.instance = new DatabaseHandler();
		}
		return DatabaseHandler.instance;
	}

	public void loadUser(String name, String passwort) {
		try {


			//Statement geilesStatement = con.createStatement();
			//geilesStatement.execute("INSERT INTO User (Benutzername, Chatname, Passwort, RegistriertSeit, GebanntBis, Moderator, Admin) "
			//		+ "VALUES                         ( 'Schnitzel', 'GeilesSchnitzel', 'Schnitzel',  )");
			
			Statement stmt = this.connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM TestTabelle");
			while (rs.next())
				System.out.println( rs.getInt(1) + rs.getString(2) );
			this.connection.close();
		} catch (Exception e) {
			System.out.println(e);
			System.out.print("DA GEHT WAS NISCH ):");
		}
	}

}
