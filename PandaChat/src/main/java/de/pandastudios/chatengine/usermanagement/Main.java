package de.pandastudios.chatengine.usermanagement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main
{
	/*Debug Main*/
	public static void main(String[] args) {
		UiLogin ui = new UiLogin();
		ui.setVisible(true);
		User user = new User();

		ui.getBtnLogin().addActionListener(e->
		{
			try
			{
				user.loadUser(ui.getTextName().getText(), ui.getTextPassword().getText());
			} catch(Throwable throwable)
			{
				throwable.printStackTrace();
			}
		});
	}

}
