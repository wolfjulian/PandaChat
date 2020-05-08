package de.pandastudios.chatengine.usermanagement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import de.pandastudios.main.ServerMain;
/* Singleton Klasse
 * Durch das synchronized wird sicher gestellt, dass der Database-Handler Threadsafe ist
 * Eigentlich nicht wirklich nötig aber sicher ist sicher.*/

public class DatabaseHandler
{

	private static DatabaseHandler instance;
	private Connection connection;
	private String connectionUrl = "jdbc:ucanaccess://src/main/resources/PandaChat.accdb";

	private DatabaseHandler()
	{
		//Initialisierung des Treibers
		try
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		} catch(ClassNotFoundException e)
		{
			e.printStackTrace();
			System.out.println("DatabaseHandler: Klasse nicht gefunden bei Class.forName(DBDRIVER)");
		}
	}

	public static synchronized DatabaseHandler getInstance()
	{
		if(DatabaseHandler.instance == null){
			DatabaseHandler.instance = new DatabaseHandler();
		}
		return DatabaseHandler.instance;
	}

	public Connection getConnection() throws SQLException
	{
		if(this.connection == null || connection.isClosed())
			connection = DriverManager.getConnection(connectionUrl);

		return connection;
	}


}
