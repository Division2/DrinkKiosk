package com.java.ex.drinkkiosk;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import com.java.ex.dao.KioskDAO;

public class AddStock extends JFrame {
	
	JPanel addStockPanel;
	
	JLabel lblCiderStock;
	JLabel lblCokeStock;
	JLabel lblFantaStock;
	JLabel lblPocariSweatStock;

	SpinnerNumberModel ciderModel;
	SpinnerNumberModel cokeModel;
	SpinnerNumberModel fantaModel;
	SpinnerNumberModel pocariModel;
	JSpinner ciderSpinner;
	JSpinner cokeSpinner;
	JSpinner fantaSpinner;
	JSpinner pocariSpinner;

	JButton btnAddCiderStock;
	JButton btnAddCokeStock;
	JButton btnAddFantaStock;
	JButton btnAddPocariSweatStock;
	
	public AddStock() {
		Container ct = getContentPane();
		addStockPanel = new JPanel();
		addStockPanel.setLayout(null);
		
		lblCiderStock = new JLabel("사이다 : ");
		lblCiderStock.setBounds(10, 10, 100, 20);
		
		lblCokeStock = new JLabel("콜라 : ");
		lblCokeStock.setBounds(10, 30, 100, 20);
		
		lblFantaStock = new JLabel("환타 : ");
		lblFantaStock.setBounds(10, 50, 100, 20);
		
		lblPocariSweatStock = new JLabel("포카리 : ");
		lblPocariSweatStock.setBounds(10, 70, 100, 20);
		
		ciderModel = new SpinnerNumberModel(0, 0, 100, 1);
		cokeModel = new SpinnerNumberModel(0, 0, 100, 1);
		fantaModel = new SpinnerNumberModel(0, 0, 100, 1);
		pocariModel = new SpinnerNumberModel(0, 0, 100, 1);
		
		ciderSpinner = new JSpinner(ciderModel);
		ciderSpinner.setBounds(60, 10, 100, 20);
		
		cokeSpinner = new JSpinner(cokeModel);
		cokeSpinner.setBounds(60, 30, 100, 20);
		
		fantaSpinner = new JSpinner(fantaModel);
		fantaSpinner.setBounds(60, 50, 100, 20);
		
		pocariSpinner = new JSpinner(pocariModel);
		pocariSpinner.setBounds(60, 70, 100, 20);
		
		btnAddCiderStock = new JButton("추가");
		btnAddCiderStock.setBounds(165, 10, 100, 20);
		btnAddCiderStock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				KioskDAO kdao = new KioskDAO();
				kdao.addDrinkStock(1, ciderSpinner.getValue().toString());
				ciderSpinner.setValue(0);
			}
		});
		
		btnAddCokeStock = new JButton("추가");
		btnAddCokeStock.setBounds(165, 30, 100, 20);
		btnAddCokeStock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				KioskDAO kdao = new KioskDAO();
				kdao.addDrinkStock(2, cokeSpinner.getValue().toString());
				cokeSpinner.setValue(0);
			}
		});
		
		btnAddFantaStock = new JButton("추가");
		btnAddFantaStock.setBounds(165, 50, 100, 20);
		btnAddFantaStock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				KioskDAO kdao = new KioskDAO();
				kdao.addDrinkStock(3, fantaSpinner.getValue().toString());
				fantaSpinner.setValue(0);
			}
		});
		
		btnAddPocariSweatStock = new JButton("추가");
		btnAddPocariSweatStock.setBounds(165, 70, 100, 20);
		btnAddPocariSweatStock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				KioskDAO kdao = new KioskDAO();
				kdao.addDrinkStock(4, pocariSpinner.getValue().toString());
				pocariSpinner.setValue(0);
			}
		});
		addStockPanel.add(lblCiderStock);
		addStockPanel.add(lblCokeStock);
		addStockPanel.add(lblFantaStock);
		addStockPanel.add(lblPocariSweatStock);
		
		addStockPanel.add(ciderSpinner);
		addStockPanel.add(cokeSpinner);
		addStockPanel.add(fantaSpinner);
		addStockPanel.add(pocariSpinner);
		
		addStockPanel.add(btnAddCiderStock);
		addStockPanel.add(btnAddCokeStock);
		addStockPanel.add(btnAddFantaStock);
		addStockPanel.add(btnAddPocariSweatStock);
		
		ct.add(addStockPanel);
		
		setVisible(true);
		setTitle("Add");
		setSize(290, 140);
		setResizable(false);
		setLocationRelativeTo(null);
	}
}