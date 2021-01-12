package com.java.ex.drinkkiosk;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.java.ex.dao.KioskDAO;

public class AddStock extends JFrame {
	
	JPanel addStockPanel;
	
	JTextField txtCiderStock;
	JTextField txtCokeStock;
	JTextField txtFantaStock;
	JTextField txtPocariSweatStock;

	JButton btnAddCiderStock;
	JButton btnAddCokeStock;
	JButton btnAddFantaStock;
	JButton btnAddPocariSweatStock;
	
	public AddStock() {
		Container ct = getContentPane();
		addStockPanel = new JPanel();
		addStockPanel.setLayout(null);
		
		txtCiderStock = new JTextField("���̴�");
		txtCiderStock.setBounds(10, 10, 100, 20);
		txtCiderStock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCiderStock.setText("");
			}
		});
		
		txtCokeStock = new JTextField("�ݶ�");
		txtCokeStock.setBounds(10, 30, 100, 20);
		txtCokeStock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCokeStock.setText("");
			}
		});
		
		txtFantaStock = new JTextField("ȯŸ");
		txtFantaStock.setBounds(10, 50, 100, 20);
		txtFantaStock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtFantaStock.setText("");
			}
		});
		
		txtPocariSweatStock = new JTextField("��ī������Ʈ");
		txtPocariSweatStock.setBounds(10, 70, 100, 20);
		txtPocariSweatStock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPocariSweatStock.setText("");
			}
		});
		
		btnAddCiderStock = new JButton("�߰�");
		btnAddCiderStock.setBounds(110, 10, 100, 20);
		btnAddCiderStock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				KioskDAO kdao = new KioskDAO();
				kdao.addDrinkStock(1, txtCiderStock.getText());
			}
		});
		
		btnAddCokeStock = new JButton("�߰�");
		btnAddCokeStock.setBounds(110, 30, 100, 20);
		btnAddCokeStock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				KioskDAO kdao = new KioskDAO();
				kdao.addDrinkStock(2, txtCokeStock.getText());
			}
		});
		
		btnAddFantaStock = new JButton("�߰�");
		btnAddFantaStock.setBounds(110, 50, 100, 20);
		btnAddFantaStock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				KioskDAO kdao = new KioskDAO();
				kdao.addDrinkStock(3, txtFantaStock.getText());
			}
		});
		
		btnAddPocariSweatStock = new JButton("�߰�");
		btnAddPocariSweatStock.setBounds(110, 70, 100, 20);
		btnAddPocariSweatStock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				KioskDAO kdao = new KioskDAO();
				kdao.addDrinkStock(4, txtPocariSweatStock.getText());
			}
		});
		
		addStockPanel.add(txtCiderStock);
		addStockPanel.add(txtCokeStock);
		addStockPanel.add(txtFantaStock);
		addStockPanel.add(txtPocariSweatStock);
		
		addStockPanel.add(btnAddCiderStock);
		addStockPanel.add(btnAddCokeStock);
		addStockPanel.add(btnAddFantaStock);
		addStockPanel.add(btnAddPocariSweatStock);
		
		ct.add(addStockPanel);
		
		setVisible(true);
		setTitle("Add");
		setSize(235, 140);
		setResizable(false);
		setLocationRelativeTo(null);
	}
}