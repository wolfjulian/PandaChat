package de.pandastudios.chatengine.usermanagement;

import java.time.LocalDate;

public class User {

	String username;
	String chatname;
	String password;
	boolean isBanned;
	boolean isAdministrator;
	boolean isModerator;
	LocalDate registeredSince;
	LocalDate bannedUntil;
	
	public User()
	{
		
	}
	
	public User(String username, String chatname, String password, boolean isBanned, boolean isAdministrator,
			boolean isModerator, LocalDate registeredSince, LocalDate bannedUntil) {
		super();
		this.username = username;
		this.chatname = chatname;
		this.password = password;
		this.isBanned = isBanned;
		this.isAdministrator = isAdministrator;
		this.isModerator = isModerator;
		this.registeredSince = registeredSince;
		this.bannedUntil = bannedUntil;
	}
	
}
