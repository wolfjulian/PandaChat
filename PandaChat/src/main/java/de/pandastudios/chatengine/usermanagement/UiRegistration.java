package de.pandastudios.chatengine.usermanagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class UiRegistration extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldBenutzername;
	private JTextField textFieldChatname;
	private JTextField textFieldPasswort;
	private JTextField textFieldPasswortBestaetigung;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UiRegistration frame = new UiRegistration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UiRegistration() {
		setTitle("Registrieren");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 248, 182);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBenutzername = new JLabel("Benutzername:");
		lblBenutzername.setBounds(10, 11, 86, 14);
		contentPane.add(lblBenutzername);
		
		JLabel lblChatname = new JLabel("Chatname:");
		lblChatname.setBounds(10, 36, 86, 14);
		contentPane.add(lblChatname);
		
		JLabel lblPasswort = new JLabel("Passwort:");
		lblPasswort.setBounds(10, 61, 86, 14);
		contentPane.add(lblPasswort);
		
		JLabel lblPasswordBestaetigen = new JLabel("Passwort best.:");
		lblPasswordBestaetigen.setBounds(10, 86, 86, 14);
		contentPane.add(lblPasswordBestaetigen);
		
		textFieldBenutzername = new JTextField();
		textFieldBenutzername.setToolTipText("Dein Benutzername sollte nur dir bekannt sein. Der Anzeigename wird \u00FCber Chatname festgelegt");
		textFieldBenutzername.setBounds(94, 8, 130, 20);
		contentPane.add(textFieldBenutzername);
		textFieldBenutzername.setColumns(10);
		
		textFieldChatname = new JTextField();
		textFieldChatname.setBounds(94, 33, 130, 20);
		contentPane.add(textFieldChatname);
		textFieldChatname.setColumns(10);
		
		textFieldPasswort = new JTextField();
		textFieldPasswort.setBounds(94, 58, 130, 20);
		contentPane.add(textFieldPasswort);
		textFieldPasswort.setColumns(10);
		
		textFieldPasswortBestaetigung = new JTextField();
		textFieldPasswortBestaetigung.setBounds(94, 83, 130, 20);
		contentPane.add(textFieldPasswortBestaetigung);
		textFieldPasswortBestaetigung.setColumns(10);
		
		JButton btnRegistrieren = new JButton("Registrieren");
		btnRegistrieren.setBounds(10, 111, 102, 23);
		contentPane.add(btnRegistrieren);
		
		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.setBounds(122, 111, 102, 23);
		contentPane.add(btnAbbrechen);
	}
}
