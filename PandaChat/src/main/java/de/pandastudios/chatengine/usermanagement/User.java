package de.pandastudios.chatengine.usermanagement;

import org.hsqldb.types.TimeData;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

/*
 * Aufbau User-Tabelle:
 * Index | Tabellenname      | Typ
 * --------------------------------------
 * 1     | ID                | Int UNQ
 * 2     | Benutzername      | String UNQ
 * 3     | Chatname          | String UNQ
 * 4     | Passwort          | String
 * 5     | RegistriertSeit   | Date
 * 6     | Gebannt           | Bool
 * 7     | GebanntBis        | Date
 * 8     | Moderator         | Bool
 * 9     | Admin             | Bool
 * 10    | Online            | Bool
 */

public class User {

	private String benutzername;
	private String chatname;
	private String password;
	private boolean isBanned;
	private boolean isAdministrator;
	private boolean isModerator;
	private Date registeredSince;
	private Date bannedUntil;
	DatabaseHandler databaseHandler;

	public User()
	{
		databaseHandler = DatabaseHandler.getInstance();
	}


	public void loadUser(String benutzername, String password) throws PasswordIncorrectException, ResultException, UserNotFoundException
	{
		try
		{
			//Statement geilesStatement = con.createStatement();
			//geilesStatement.execute("INSERT INTO User (Benutzername, Chatname, Passwort, RegistriertSeit, GebanntBis, Moderator, Admin) "
			//		+ "VALUES                         ( 'Schnitzel', 'GeilesSchnitzel', 'Schnitzel',  )");
			int i = 0;
			Statement stmt = databaseHandler.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT User.* FROM [User] WHERE (((User.Benutzername)=" + "\"" + benutzername + "\"));");
			while(rs.next())
			{
				i++;
				//abbrechen, falls zu viele Einträge gefunden wurden - eigentlich unmöglich aber Vorsicht ist immer besser als Nachsicht.
				if(i > 1)
					throw new ResultException("Zu viele Eintraege gefunden!");

				this.benutzername = rs.getString(2);
				this.chatname = rs.getString(3);
				this.password = rs.getString(4);
				this.registeredSince = rs.getDate(5);
				this.isBanned = rs.getBoolean(6);
				this.bannedUntil = rs.getDate(7);
				this.isModerator = rs.getBoolean(8);
				this.isAdministrator = rs.getBoolean(9);
			}

			System.out.println(this.benutzername);
			if(this.benutzername == null)
				throw new UserNotFoundException("Kein User gefunden!");

			if(this.password.compareTo(password) != 0)
				throw new PasswordIncorrectException("Passwort nicht korrekt!");

			databaseHandler.getConnection().close();

		} catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("SQL Fehlerhaft");
		}

	}

	public void createUser(String benutzername, String chatname, String password)
	{
		try
		{
			//INSERT INTO [User] (Benutzername, [Chatname], [Passwort], [RegistriertSeit])
			//VALUES ('febel','febel','febel',Date())
			Statement statement = databaseHandler.getConnection().createStatement();
			statement.execute("INSERT INTO [User] (Benutzername, [Chatname], [Passwort], [RegistriertSeit])\n VALUES ('" +
					benutzername +"','"+chatname+"','"+password+"',Date())");

		} catch(SQLException e)
		{
			e.printStackTrace();
		}

	}
	
	public void changeUser(String chatname, String password)
	{
		try
		{
			//INSERT INTO [User] (Benutzername, [Chatname], [Passwort], [RegistriertSeit])
			//VALUES ('febel','febel','febel',Date())
			Statement statement = databaseHandler.getConnection().createStatement();
			statement.execute("UPDATE [User] SET [Chatname] = " + chatname + ", [Passwort] = " + password + ")\n"
					+ "WHERE [Benutzername] = " + getBenutzername());

		} catch(SQLException e)
		{
			e.printStackTrace();
		}

	}
	

	public String getBenutzername()
	{
		return benutzername;
	}

	public User setBenutzername(String benutzername)
	{
		this.benutzername = benutzername;
		return this;
	}

	public String getChatname()
	{
		return chatname;
	}

	public User setChatname(String chatname)
	{
		this.chatname = chatname;
		return this;
	}

	public String getPassword()
	{
		return password;
	}

	public User setPassword(String password)
	{
		this.password = password;
		return this;
	}

	public boolean isBanned()
	{
		return isBanned;
	}

	public User setBanned(boolean banned)
	{
		isBanned = banned;
		return this;
	}

	public boolean isAdministrator()
	{
		return isAdministrator;
	}

	public User setAdministrator(boolean administrator)
	{
		isAdministrator = administrator;
		return this;
	}

	public boolean isModerator()
	{
		return isModerator;
	}

	public User setModerator(boolean moderator)
	{
		isModerator = moderator;
		return this;
	}

	public Date getRegisteredSince()
	{
		return registeredSince;
	}

	public User setRegisteredSince(Date registeredSince)
	{
		this.registeredSince = registeredSince;
		return this;
	}

	public Date getBannedUntil()
	{
		return bannedUntil;
	}

	public User setBannedUntil(Date bannedUntil)
	{
		this.bannedUntil = bannedUntil;
		return this;
	}

}
