package de.pandastudios.chatengine.usermanagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UiLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textPassword;
	private JButton btnLogin;
	private JLabel lblName;
	private JLabel lblPassword;


	public UiLogin() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 251, 137);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getTextName());
		contentPane.add(getTextPassword());
		contentPane.add(getBtnLogin());
		contentPane.add(getLblName());
		contentPane.add(getLblPassword());
	}
	protected JTextField getTextName() {
		if (textName == null) {
			textName = new JTextField();
			textName.setBounds(93, 11, 139, 20);
			textName.setColumns(10);
		}
		return textName;
	}
	protected JTextField getTextPassword() {
		if (textPassword == null) {
			textPassword = new JTextField();
			textPassword.setBounds(93, 42, 139, 20);
			textPassword.setColumns(10);
		}
		return textPassword;
	}
	protected JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("Login");
			btnLogin.setBounds(69, 73, 89, 23);
		}
		return btnLogin;
	}
	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Name");
			lblName.setBounds(10, 14, 46, 14);
		}
		return lblName;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password");
			lblPassword.setBounds(10, 45, 46, 14);
		}
		return lblPassword;
	}
}
