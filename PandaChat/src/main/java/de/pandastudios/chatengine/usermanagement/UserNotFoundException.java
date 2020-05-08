package de.pandastudios.chatengine.usermanagement;

public class UserNotFoundException extends Exception
{
	public UserNotFoundException(String errorMessage)
	{
		super(errorMessage);
	}
}
