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
import com.java.ex.dto.KioskDTO;

public class EditPrice extends JFrame {
	JPanel pricePanel;
	
	JTextField txtCiderPrice;
	JTextField txtCokePrice;
	JTextField txtFantaPrice;
	JTextField txtPocariSweatPrice;

	JButton btnEditCiderPrice;
	JButton btnEditCokePrice;
	JButton btnEditFantaPrice;
	JButton btnEditPocariSweatPrice;
	
	public EditPrice(KioskDTO kdto) {
		Container ct = getContentPane();
		pricePanel = new JPanel();
		pricePanel.setLayout(null);
		
		txtCiderPrice = new JTextField("사이다 가격 : " + kdto.getCiderPrice());
		txtCiderPrice.setBounds(10, 10, 100, 20);
		txtCiderPrice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCiderPrice.setText("");
			}
		});
		
		txtCokePrice = new JTextField("콜라 가격 : " + kdto.getCokePrice());
		txtCokePrice.setBounds(10, 30, 100, 20);
		txtCokePrice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCokePrice.setText("");
			}
		});
		
		txtFantaPrice = new JTextField("환타 가격 : " + kdto.getFantaPrice());
		txtFantaPrice.setBounds(10, 50, 100, 20);
		txtFantaPrice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtFantaPrice.setText("");
			}
		});
		
		txtPocariSweatPrice = new JTextField("포카리스웨트 가격 : " + kdto.getPocariPrice());
		txtPocariSweatPrice.setBounds(10, 70, 100, 20);
		txtPocariSweatPrice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPocariSweatPrice.setText("");
			}
		});
		
		btnEditCiderPrice = new JButton("수정");
		btnEditCiderPrice.setBounds(110, 10, 100, 20);
		btnEditCiderPrice.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				KioskDAO kdao = new KioskDAO();
				kdao.editDrinkPrice(1, txtCiderPrice.getText());
			}
		});
		
		btnEditCokePrice = new JButton("수정");
		btnEditCokePrice.setBounds(110, 30, 100, 20);
		btnEditCokePrice.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				KioskDAO kdao = new KioskDAO();
				kdao.editDrinkPrice(2, txtCokePrice.getText());
			}
		});
		
		btnEditFantaPrice = new JButton("수정");
		btnEditFantaPrice.setBounds(110, 50, 100, 20);
		btnEditFantaPrice.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				KioskDAO kdao = new KioskDAO();
				kdao.editDrinkPrice(3, txtFantaPrice.getText());
			}
		});
		
		btnEditPocariSweatPrice = new JButton("수정");
		btnEditPocariSweatPrice.setBounds(110, 70, 100, 20);
		btnEditPocariSweatPrice.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				KioskDAO kdao = new KioskDAO();
				kdao.editDrinkPrice(4, txtPocariSweatPrice.getText());
			}
		});
		
		pricePanel.add(txtCiderPrice);
		pricePanel.add(txtCokePrice);
		pricePanel.add(txtFantaPrice);
		pricePanel.add(txtPocariSweatPrice);
		
		pricePanel.add(btnEditCiderPrice);
		pricePanel.add(btnEditCokePrice);
		pricePanel.add(btnEditFantaPrice);
		pricePanel.add(btnEditPocariSweatPrice);
		
		ct.add(pricePanel);
		
		setVisible(true);
		setTitle("Edit");
		setSize(235, 140);
		setResizable(false);
		setLocationRelativeTo(null);
	}
}