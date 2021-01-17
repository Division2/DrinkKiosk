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

public class SubStock extends JFrame {
	JPanel subStockPanel;
	
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

	JButton btnSubCiderStock;
	JButton btnSubCokeStock;
	JButton btnSubFantaStock;
	JButton btnSubPocariSweatStock;
	
	public SubStock() {
		Container ct = getContentPane();
		subStockPanel = new JPanel();
		subStockPanel.setLayout(null);
		
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
		
		btnSubCiderStock = new JButton("삭제");
		btnSubCiderStock.setBounds(165, 10, 100, 20);
		btnSubCiderStock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				KioskDAO kdao = new KioskDAO();
				kdao.subDrinkStock(1, ciderSpinner.getValue().toString());
				ciderSpinner.setValue(0);
			}
		});
		
		btnSubCokeStock = new JButton("삭제");
		btnSubCokeStock.setBounds(165, 30, 100, 20);
		btnSubCokeStock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				KioskDAO kdao = new KioskDAO();
				kdao.subDrinkStock(2, cokeSpinner.getValue().toString());
				cokeSpinner.setValue(0);
			}
		});
		
		btnSubFantaStock = new JButton("삭제");
		btnSubFantaStock.setBounds(165, 50, 100, 20);
		btnSubFantaStock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				KioskDAO kdao = new KioskDAO();
				kdao.subDrinkStock(3, fantaSpinner.getValue().toString());
				fantaSpinner.setValue(0);
			}
		});
		
		btnSubPocariSweatStock = new JButton("삭제");
		btnSubPocariSweatStock.setBounds(165, 70, 100, 20);
		btnSubPocariSweatStock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				KioskDAO kdao = new KioskDAO();
				kdao.subDrinkStock(4, pocariSpinner.getValue().toString());
				pocariSpinner.setValue(0);
			}
		});
		
		subStockPanel.add(lblCiderStock);
		subStockPanel.add(lblCokeStock);
		subStockPanel.add(lblFantaStock);
		subStockPanel.add(lblPocariSweatStock);
		
		subStockPanel.add(ciderSpinner);
		subStockPanel.add(cokeSpinner);
		subStockPanel.add(fantaSpinner);
		subStockPanel.add(pocariSpinner);
		
		subStockPanel.add(btnSubCiderStock);
		subStockPanel.add(btnSubCokeStock);
		subStockPanel.add(btnSubFantaStock);
		subStockPanel.add(btnSubPocariSweatStock);
		
		ct.add(subStockPanel);
		
		setVisible(true);
		setTitle("Subtract");
		setSize(290, 140);
		setResizable(false);
		setLocationRelativeTo(null);
	}
}