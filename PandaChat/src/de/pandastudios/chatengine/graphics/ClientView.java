package de.pandastudios.chatengine.graphics;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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

public class ClientView extends JFrame {
	
	private JPanel contentPane;
	private JLabel lblServer;
	private JLabel lblTextEingeben;
	private JButton btnStart;
	private JButton btnSenden;
	private JComboBox comboBoxServer;
	private JTextField textFieldEingabe;
	private JLabel labelMessage;
	private JList listMessages;
	private DefaultListModel messageListe = new DefaultListModel();
	private DefaultComboBoxModel idmodel = new DefaultComboBoxModel();

	public ClientView() {
		initialize();
	}

	public JButton getBtnSenden() {
		if (btnSenden == null) {
			btnSenden = new JButton("senden");
		}
		return btnSenden;
	}

	public void btnSendenAddActionListener(ActionListener listener) {
		getBtnSenden().addActionListener(listener);
	}

	public JButton getBtnStart() {
		if (btnStart == null) {
			btnStart = new JButton("Start");
		}
		return btnStart;
	}

	public void btnStartAddActionListener(ActionListener listener) {
		getBtnStart().addActionListener(listener);
	}

	public JComboBox getComboBoxServer() {
		if (comboBoxServer == null) {
			comboBoxServer = new JComboBox();
		}
		return comboBoxServer;
	}

	private JLabel getLabelMessage() {
		if (labelMessage == null) {
			labelMessage = new JLabel("");
		}
		return labelMessage;
	}

	private JLabel getLblServer() {
		if (lblServer == null) {
			lblServer = new JLabel("Server");
		}
		return lblServer;
	}

	private JLabel getLblTextEingeben() {
		if (lblTextEingeben == null) {
			lblTextEingeben = new JLabel("Text eingeben");
		}
		return lblTextEingeben;
	}

	public JTextField getTextFieldEingabe() {
		if (textFieldEingabe == null) {
			textFieldEingabe = new JTextField();
			textFieldEingabe.setColumns(10);
		}
		return textFieldEingabe;
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
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
		GridBagConstraints gbc_lblTextEingeben = new GridBagConstraints();
		gbc_lblTextEingeben.anchor = GridBagConstraints.WEST;
		gbc_lblTextEingeben.insets = new Insets(0, 0, 5, 5);
		gbc_lblTextEingeben.gridx = 1;
		gbc_lblTextEingeben.gridy = 4;
		contentPane.add(getLblTextEingeben(), gbc_lblTextEingeben);
		GridBagConstraints gbc_textFieldEingabe = new GridBagConstraints();
		gbc_textFieldEingabe.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEingabe.gridwidth = 9;
		gbc_textFieldEingabe.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldEingabe.gridx = 1;
		gbc_textFieldEingabe.gridy = 5;
		contentPane.add(getTextFieldEingabe(), gbc_textFieldEingabe);
		GridBagConstraints gbc_btnSenden = new GridBagConstraints();
		gbc_btnSenden.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSenden.insets = new Insets(0, 0, 5, 5);
		gbc_btnSenden.gridx = 9;
		gbc_btnSenden.gridy = 6;
		contentPane.add(getBtnSenden(), gbc_btnSenden);
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

	public JList getListMessages() {
		if (listMessages == null) {
			listMessages = new JList();
		}
		return listMessages;
	}

	public DefaultListModel getModel() {
		return messageListe;
	}

	public DefaultComboBoxModel getModelId() {
		return idmodel;
	}
}

