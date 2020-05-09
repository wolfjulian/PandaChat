package de.pandastudios.chatengine.usermanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main
{
	/*Debug Main*/
	public static void main(String[] args) {
		UiLogin ui = new UiLogin();
		ui.setVisible(true);
		User user = new User();

		user.createUser("febel","febel","febel");

		ui.getBtnLogin().addActionListener(e->
		{

			try
			{
				user.loadUser(ui.getTextName().getText(), ui.getTextPassword().getText());
			} catch(PasswordIncorrectException passwordIncorrectException)
			{
				passwordIncorrectException.printStackTrace();
				JOptionPane.showMessageDialog(null, "Passwort nicht korrekt!");
			} catch(UserNotFoundException userNotFoundException)
			{
				userNotFoundException.printStackTrace();
				JOptionPane.showMessageDialog(null, "User nicht gefunden!");
			} catch(ResultException resultException)
			{
				resultException.printStackTrace();
			}
		});
	}

}
