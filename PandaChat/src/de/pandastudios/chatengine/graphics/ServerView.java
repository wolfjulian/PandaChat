package de.pandastudios.chatengine.graphics;

import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;

public class ServerView extends JFrame
{

	private JPanel						contentPane;
	private JLabel						lblMessages;
	private JLabel						lblPortnr;
	private JButton						btnStart;
	private JTextField					textFieldPort;
	private JTextField					textFieldBroadcast;
	private DefaultListModel<String>	nachrichten	= new DefaultListModel<String>();
	private JButton						btnSend;
	private JScrollPane sPMessage;
	private JList list;
	private JScrollPane scrollPane;

	public ServerView()
	{
		initialize();
	}

	public void btnSendAddActionListener(ActionListener listener)
	{
		getBtnSend().addActionListener(listener);
	}

	public void btnStartAddActionListener(ActionListener listener)
	{
		getBtnStart().addActionListener(listener);
	}

	private JButton getBtnSend()
	{
		if (btnSend == null)
		{
			btnSend = new JButton("Send");
			btnSend.setBounds(345, 205, 79, 23);
		}
		return btnSend;
	}

	public JButton getBtnStart()
	{
		if (btnStart == null)
		{
			btnStart = new JButton("Start");
			btnStart.setBounds(345, 127, 79, 68);
			btnStart.setVisible(true);
		}
		return btnStart;
	}

	private JLabel getlblMessages()
	{
		if (lblMessages == null)
		{
			lblMessages = new JLabel("Nachrichten");
			lblMessages.setBounds(10, 11, 74, 14);
		}
		return lblMessages;
	}

	private JLabel getLblPortnr()
	{
		if (lblPortnr == null)
		{
			lblPortnr = new JLabel("Portnr.");
			lblPortnr.setBounds(352, 37, 46, 14);
		}
		return lblPortnr;
	}

	public DefaultListModel<String> getNachrichten()
	{
		return nachrichten;
	}

	public JTextField getTextFieldBroadcast()
	{
		if (textFieldBroadcast == null)
		{
			textFieldBroadcast = new JTextField();
			textFieldBroadcast.setBounds(10, 206, 325, 20);
			textFieldBroadcast.setColumns(10);
		}
		return textFieldBroadcast;
	}

	public JTextField getTextFieldPort()
	{
		if (textFieldPort == null)
		{
			textFieldPort = new JTextField();
			textFieldPort.setText("8008");
			textFieldPort.setBounds(345, 62, 79, 20);
			textFieldPort.setColumns(10);
		}
		return textFieldPort;
	}

	private void initialize()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getlblMessages());
		contentPane.add(getLblPortnr());
		contentPane.add(getBtnStart());
		contentPane.add(getTextFieldPort());
		contentPane.add(getTextFieldBroadcast());
		contentPane.add(getBtnSend());
		contentPane.add(getList());
		contentPane.add(getScrollPane());
	}

	public void txtPortAddActionListener(ActionListener listener)
	{
		getTextFieldPort().addActionListener(listener);
	}
	public JList getList() {
		if (list == null) {
			list = new JList();
			list.setBounds(20, 36, 308, 157);
		}
		return list;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(20, 36, 308, 157);
		}
		return scrollPane;
	}
}
