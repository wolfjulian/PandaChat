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
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ServerView extends JFrame {


	private JPanel		contentPane;
	private JLabel		lblNachrichten;
	private JLabel		lblPortnr;
	private JButton		btnStart;
	private JTextField	textFieldPort;
	private JTextField	textField_1;
	private JList listNachrichten;
	private DefaultListModel<String> nachrichten = new DefaultListModel<String>();
	private JButton btnSend;
	
	public DefaultListModel<String> getNachrichten(){
		return nachrichten;}
	
	public ServerView()	{
		initialize();}
	
	public JButton getBtnStart(){
		if (btnStart == null){
			btnStart = new JButton("Start");
			btnStart.setBounds(345, 127, 79, 68);
			btnStart.setVisible(true);
		}return btnStart;}
	
	public void btnStartAddActionListener(ActionListener listener){
		getBtnStart().addActionListener(listener);}
	
	public void btnSendAddActionListener(ActionListener listener){
		getBtnSend().addActionListener(listener);}

	private JLabel getLblNachrichten(){
		if (lblNachrichten == null){
			lblNachrichten = new JLabel("Nachrichten");
			lblNachrichten.setBounds(10, 11, 74, 14);}
		return lblNachrichten;}

	private JLabel getLblPortnr(){
		if (lblPortnr == null){
			lblPortnr = new JLabel("Portnr.");
			lblPortnr.setBounds(352, 37, 46, 14);}
		return lblPortnr;}
	
	public JTextField getTextField_1(){
		if (textField_1 == null){
			textField_1 = new JTextField();
			textField_1.setBounds(10, 206, 325, 20);
			textField_1.setColumns(10);}
		return textField_1;}

	public JTextField getTextFieldPort(){
		if (textFieldPort == null){
			textFieldPort = new JTextField();
			textFieldPort.setText("8008");
			textFieldPort.setBounds(345, 62, 79, 20);
			textFieldPort.setColumns(10);}
		return textFieldPort;}
	
	public void txtPortAddActionListener(ActionListener listener){
		getTextFieldPort().addActionListener(listener);}

	private void initialize(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNachrichten());
		contentPane.add(getLblPortnr());
		contentPane.add(getBtnStart());
		contentPane.add(getTextFieldPort());
		contentPane.add(getTextField_1());
		contentPane.add(getListNachrichten());
		contentPane.add(getBtnSend());}
	
	public JList getListNachrichten(){
		if (listNachrichten == null){
			listNachrichten = new JList();
			listNachrichten.setBounds(10, 36, 325, 159);}
		return listNachrichten;}
	
	private JButton getBtnSend(){
		if (btnSend == null){
			btnSend = new JButton("Send");
			btnSend.setBounds(345, 205, 79, 23);}
		return btnSend;}
}
