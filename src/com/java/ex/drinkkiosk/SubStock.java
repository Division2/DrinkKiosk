package com.java.ex.drinkkiosk;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.java.ex.dao.KioskDAO;

public class SubStock extends JFrame {
	JPanel subStockPanel;
	
	JTextField txtCiderStock;
	JTextField txtCokeStock;
	JTextField txtFantaStock;
	JTextField txtPocariSweatStock;

	JButton btnSubCiderStock;
	JButton btnSubCokeStock;
	JButton btnSubFantaStock;
	JButton btnSubPocariSweatStock;
	
	public SubStock() {
		Container ct = getContentPane();
		subStockPanel = new JPanel();
		subStockPanel.setLayout(null);
		
		txtCiderStock = new JTextField("사이다");
		txtCiderStock.setBounds(10, 10, 100, 20);
		txtCiderStock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCiderStock.setText("");
			}
		});
		
		txtCokeStock = new JTextField("콜라");
		txtCokeStock.setBounds(10, 30, 100, 20);
		txtCokeStock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCokeStock.setText("");
			}
		});
		
		txtFantaStock = new JTextField("환타");
		txtFantaStock.setBounds(10, 50, 100, 20);
		txtFantaStock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtFantaStock.setText("");
			}
		});
		
		txtPocariSweatStock = new JTextField("포카리스웨트");
		txtPocariSweatStock.setBounds(10, 70, 100, 20);
		txtPocariSweatStock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPocariSweatStock.setText("");
			}
		});
		
		btnSubCiderStock = new JButton("삭제");
		btnSubCiderStock.setBounds(110, 10, 100, 20);
		btnSubCiderStock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				KioskDAO kdao = new KioskDAO();
				kdao.subDrinkStock(1, txtCiderStock.getText());
			}
		});
		
		btnSubCokeStock = new JButton("삭제");
		btnSubCokeStock.setBounds(110, 30, 100, 20);
		btnSubCokeStock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				KioskDAO kdao = new KioskDAO();
				kdao.subDrinkStock(2, txtCokeStock.getText());
			}
		});
		
		btnSubFantaStock = new JButton("삭제");
		btnSubFantaStock.setBounds(110, 50, 100, 20);
		btnSubFantaStock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				KioskDAO kdao = new KioskDAO();
				kdao.subDrinkStock(3, txtFantaStock.getText());
			}
		});
		
		btnSubPocariSweatStock = new JButton("삭제");
		btnSubPocariSweatStock.setBounds(110, 70, 100, 20);
		btnSubPocariSweatStock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				KioskDAO kdao = new KioskDAO();
				kdao.subDrinkStock(4, txtPocariSweatStock.getText());
			}
		});
		
		subStockPanel.add(txtCiderStock);
		subStockPanel.add(txtCokeStock);
		subStockPanel.add(txtFantaStock);
		subStockPanel.add(txtPocariSweatStock);
		subStockPanel.add(btnSubCiderStock);
		subStockPanel.add(btnSubCokeStock);
		subStockPanel.add(btnSubFantaStock);
		subStockPanel.add(btnSubPocariSweatStock);
		
		ct.add(subStockPanel);
		
		setVisible(true);
		setTitle("Subtract");
		setSize(235, 140);
		setResizable(false);
		setLocationRelativeTo(null);
	}
}