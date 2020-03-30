package de.pandastudios.chatengine.graphics;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;

public class TPSView extends JFrame {

	private JPanel contentPane;
	private JLabel lblName;
	private JSeparator separator;
	private JSeparator separator_1;
	private JLabel lblStatus;
	private JSeparator separator_2;
	private JTextField textFieldServerStatus;
	private JLabel lblServerLoad;
	private JLabel lblServerLoadValue;
	private JLabel lblPortScanner;
	private JButton btnPortScannerScan;

	public TPSView() 
	{
		initialize();
	}
	private void initialize() 
	{
		setTitle("Panda TPS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 578);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblName());
		contentPane.add(getSeparator());
		contentPane.add(getSeparator_1());
		contentPane.add(getLblStatus());
		contentPane.add(getSeparator_2());
		contentPane.add(getTextFieldServerStatus());
		contentPane.add(getLblServerLoad());
		contentPane.add(getLblServerLoadValue());
		contentPane.add(getLblPortScanner());
		contentPane.add(getBtnPortScannerScan());
	}
	private JLabel getLblName() 
	{
		if (lblName == null) 
		{
			lblName = new JLabel("Panda Threat Protection System");
			lblName.setFont(new Font("SansSerif", Font.PLAIN, 16));
			lblName.setBounds(285, 11, 225, 53);
		}
		return lblName;
	}
	private JSeparator getSeparator() 
	{
		if (separator == null) 
		{
			separator = new JSeparator();
			separator.setBounds(10, 62, 826, 2);
		}
		return separator;
	}
	private JSeparator getSeparator_1() 
	{
		if (separator_1 == null) 
		{
			separator_1 = new JSeparator();
			separator_1.setBounds(10, 301, 826, 2);
		}
		return separator_1;
	}
	private JLabel getLblStatus() 
	{
		if (lblStatus == null) 
		{
			lblStatus = new JLabel("Server Status");
			lblStatus.setFont(new Font("SansSerif", Font.PLAIN, 13));
			lblStatus.setBounds(20, 75, 78, 27);
		}
		return lblStatus;
	}
	private JSeparator getSeparator_2() 
	{
		if (separator_2 == null) 
		{
			separator_2 = new JSeparator();
			separator_2.setOrientation(SwingConstants.VERTICAL);
			separator_2.setBounds(204, 75, 2, 215);
		}
		return separator_2;
	}
	private JTextField getTextFieldServerStatus() 
	{
		if (textFieldServerStatus == null) 
		{
			textFieldServerStatus = new JTextField();
			textFieldServerStatus.setBackground(Color.GREEN);
			textFieldServerStatus.setBounds(134, 79, 25, 20);
			textFieldServerStatus.setColumns(10);
		}
		return textFieldServerStatus;
	}
	private JLabel getLblServerLoad() 
	{
		if (lblServerLoad == null) 
		{
			lblServerLoad = new JLabel("Auslastung");
			lblServerLoad.setFont(new Font("SansSerif", Font.PLAIN, 13));
			lblServerLoad.setBounds(20, 113, 71, 41);
		}
		return lblServerLoad;
	}
	private JLabel getLblServerLoadValue() 
	{
		if (lblServerLoadValue == null) 
		{
			lblServerLoadValue = new JLabel("0 %");
			lblServerLoadValue.setFont(new Font("SansSerif", Font.PLAIN, 13));
			lblServerLoadValue.setBounds(134, 113, 25, 41);
		}
		return lblServerLoadValue;
	}
	private JLabel getLblPortScanner() 
	{
		if (lblPortScanner == null) 
		{
			lblPortScanner = new JLabel("PortScanner");
			lblPortScanner.setFont(new Font("SansSerif", Font.PLAIN, 13));
			lblPortScanner.setBounds(216, 68, 78, 41);
		}
		return lblPortScanner;
	}
	private JButton getBtnPortScannerScan() 
	{
		if (btnPortScannerScan == null) 
		{
			btnPortScannerScan = new JButton("Scan");
			btnPortScannerScan.setFont(new Font("SansSerif", Font.PLAIN, 13));
			btnPortScannerScan.setBounds(736, 78, 89, 23);
		}
		return btnPortScannerScan;
	}
}
