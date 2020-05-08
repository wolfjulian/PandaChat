package de.pandastudios.chatengine.usermanagement;

public class PasswordIncorrectException extends Exception
{
	public PasswordIncorrectException(String errorMessage)
	{
		super(errorMessage);
	}
}
