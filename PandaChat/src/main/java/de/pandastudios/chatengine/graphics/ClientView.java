package de.pandastudios.chatengine.graphics;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;

public class ClientView extends JFrame
{

	private JPanel					contentPane;
	private JLabel					lblServer;
	private JLabel					lblInputText;
	private JButton					btnStart;
	private JButton					btnSend;
	private JComboBox				comboBoxServer;
	private JTextField				textFieldInput;
	private JLabel					labelMessage;
	private JList					listMessages;
	private DefaultListModel		messageList		= new DefaultListModel();
	private DefaultComboBoxModel	idmodel			= new DefaultComboBoxModel();
	private JButton 				btnSendImg;

	public ClientView()
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

	public void btnSendImgAddActionListener(ActionListener listener)
	{
		getBtnSendImg().addActionListener(listener);
	}
	
	public JButton getBtnSend()
	{
		if (btnSend == null)
		{
			btnSend = new JButton("Send");
		}
		return btnSend;
	}

	public JButton getBtnStart()
	{
		if (btnStart == null)
		{
			btnStart = new JButton("Start");
		}
		return btnStart;
	}

	public JComboBox getComboBoxServer()
	{
		if (comboBoxServer == null)
		{
			comboBoxServer = new JComboBox();
		}
		return comboBoxServer;
	}

	private JLabel getLabelMessage()
	{
		if (labelMessage == null)
		{
			labelMessage = new JLabel("");
		}
		return labelMessage;
	}

	private JLabel getLblServer()
	{
		if (lblServer == null)
		{
			lblServer = new JLabel("Server");
		}
		return lblServer;
	}

	private JLabel getLblInputText()
	{
		if (lblInputText == null)
		{
			lblInputText = new JLabel("Text eingeben");
		}
		return lblInputText;
	}

	public JList getListMessages()
	{
		if (listMessages == null)
		{
			listMessages = new JList();
		}
		return listMessages;
	}

	public DefaultListModel getModel()
	{
		return messageList;
	}

	public DefaultComboBoxModel getModelId()
	{
		return idmodel;
	}

	public JTextField getTextFieldInput()
	{
		if (textFieldInput == null)
		{
			textFieldInput = new JTextField();
			textFieldInput.setColumns(10);
		}
		return textFieldInput;
	}
	private JButton getBtnSendImg()
	{
		if (btnSendImg == null)
		{
			btnSendImg = new JButton("Send Img");
		}
		return btnSendImg;
	}


	private void initialize()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]
		{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[]
		{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[]
		{ 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[]
		{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);
		GridBagConstraints gbc_lblServer = new GridBagConstraints();
		gbc_lblServer.anchor = GridBagConstraints.WEST;
		gbc_lblServer.insets = new Insets(0, 0, 5, 5);
		gbc_lblServer.gridx = 1;
		gbc_lblServer.gridy = 1;
		contentPane.add(getLblServer(), gbc_lblServer);
		GridBagConstraints gbc_comboBoxServer = new GridBagConstraints();
		gbc_comboBoxServer.gridwidth = 8;
		gbc_comboBoxServer.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxServer.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxServer.gridx = 1;
		gbc_comboBoxServer.gridy = 2;
		contentPane.add(getComboBoxServer(), gbc_comboBoxServer);
		GridBagConstraints gbc_btnStart = new GridBagConstraints();
		gbc_btnStart.anchor = GridBagConstraints.EAST;
		gbc_btnStart.insets = new Insets(0, 0, 5, 5);
		gbc_btnStart.gridx = 9;
		gbc_btnStart.gridy = 2;
		contentPane.add(getBtnStart(), gbc_btnStart);
		GridBagConstraints gbc_lblInputText = new GridBagConstraints();
		gbc_lblInputText.gridwidth = 3;
		gbc_lblInputText.anchor = GridBagConstraints.WEST;
		gbc_lblInputText.insets = new Insets(0, 0, 5, 5);
		gbc_lblInputText.gridx = 1;
		gbc_lblInputText.gridy = 4;
		contentPane.add(getLblInputText(), gbc_lblInputText);
		GridBagConstraints gbc_textFieldInput = new GridBagConstraints();
		gbc_textFieldInput.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldInput.gridwidth = 9;
		gbc_textFieldInput.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldInput.gridx = 1;
		gbc_textFieldInput.gridy = 5;
		contentPane.add(getTextFieldInput(), gbc_textFieldInput);
		GridBagConstraints gbc_btnSendImg = new GridBagConstraints();
		gbc_btnSendImg.insets = new Insets(0, 0, 5, 5);
		gbc_btnSendImg.gridx = 8;
		gbc_btnSendImg.gridy = 6;
		contentPane.add(getBtnSendImg(), gbc_btnSendImg);
		GridBagConstraints gbc_btnSend = new GridBagConstraints();
		gbc_btnSend.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSend.insets = new Insets(0, 0, 5, 5);
		gbc_btnSend.gridx = 9;
		gbc_btnSend.gridy = 6;
		contentPane.add(getBtnSend(), gbc_btnSend);
		GridBagConstraints gbc_labelMessage = new GridBagConstraints();
		gbc_labelMessage.insets = new Insets(0, 0, 5, 5);
		gbc_labelMessage.gridx = 1;
		gbc_labelMessage.gridy = 8;
		contentPane.add(getLabelMessage(), gbc_labelMessage);
		GridBagConstraints gbc_listMessages = new GridBagConstraints();
		gbc_listMessages.gridwidth = 9;
		gbc_listMessages.insets = new Insets(0, 0, 0, 5);
		gbc_listMessages.fill = GridBagConstraints.BOTH;
		gbc_listMessages.gridx = 1;
		gbc_listMessages.gridy = 9;
		contentPane.add(getListMessages(), gbc_listMessages);
	}

}
