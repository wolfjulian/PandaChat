package de.pandastudios.chatengine.usermanagement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import de.pandastudios.main.ServerMain;

public class DatabaseHandler {

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
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo", "root", "root");
			// here sonoo is database name, root is username and password
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from emp");
			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
