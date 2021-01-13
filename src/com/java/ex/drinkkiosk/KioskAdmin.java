package com.java.ex.drinkkiosk;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import com.java.ex.dao.KioskDAO;
import com.java.ex.dto.KioskDTO;

public class KioskAdmin extends JFrame {
	
	JPanel kioskAdminPanel;
	
	JMenuBar menuBar;
	JMenu menuManagement;
	JMenuItem itemAddStock;
	JMenuItem itemSubStock;
	JMenuItem itemEditPrice;
	
	JTable drinkKioskTable;
	DefaultTableModel drinkModel;
	JScrollPane scroll;
	
	public KioskAdmin(KioskDTO kdto) {
		Container ct = getContentPane();
		kioskAdminPanel = new JPanel();
		kioskAdminPanel.setLayout(null);
		
		menuBar = new JMenuBar();
		menuManagement = new JMenu("����");
		menuBar.add(menuManagement);ㅁpackage com.java.ex.drinkkiosk;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import com.java.ex.dao.KioskDAO;
import com.java.ex.dto.KioskDTO;

public class KioskAdmin extends JFrame {
	
	JPanel kioskAdminPanel;
	
	JMenuBar menuBar;
	JMenu menuManagement;
	JMenuItem itemAddStock;
	JMenuItem itemSubStock;
	JMenuItem itemEditPrice;
	
	JTable drinkKioskTable;
	DefaultTableModel drinkModel;
	JScrollPane scroll;
	
	public KioskAdmin(KioskDTO kdto) {
		Container ct = getContentPane();
		kioskAdminPanel = new JPanel();
		kioskAdminPanel.setLayout(null);
		
		menuBar = new JMenuBar();
		menuManagement = new JMenu("관리");
		menuBar.add(menuManagement);
		
		itemAddStock = new JMenuItem("재고 등록");
		menuManagement.add(itemAddStock);
		itemAddStock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddStock();
			}
		});

		itemSubStock = new JMenuItem("재고 삭제");
		menuManagement.add(itemSubStock);
		itemSubStock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SubStock();
			}
		});
		
		menuManagement.addSeparator();
		
		itemEditPrice = new JMenuItem("가격 수정");
		menuManagement.add(itemEditPrice);
		itemEditPrice.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new EditPrice(kdto);
			}
		});
		
		String[] drinkLoopUp = {"사이다", "콜라", "환타", "포카리스웨트", "사이다 가격", "콜라 가격", "환타 가격"," 포카리스웨트 가격", "자판기 금액" };
		drinkModel = new DefaultTableModel(drinkLoopUp, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		drinkKioskTable = new JTable(drinkModel);
		drinkKioskTable.setRowHeight(25);
		drinkKioskTable.getTableHeader().setReorderingAllowed(false);
		scroll = new JScrollPane(drinkKioskTable);
		scroll.setBounds(10, 10, 1000, 400);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		kioskAdminPanel.add(scroll);
		
		//선 긋는 메소드
		//addSeparator();
		
		Thread tableList = new Thread(new Runnable() {
			@Override
			public void run() {
				KioskDAO kdao = new KioskDAO();
				while (true) {
					if (!kioskAdminPanel.isVisible()) {
						break;
					}
					drinkKioskTable.setModel(kdao.drinkTableList());
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		tableList.start();
		
		ct.add(kioskAdminPanel);
		
		setJMenuBar(menuBar);
		setTitle("Drink Kiosk Administator");
		setVisible(true);
		setSize(1035, 485);
		setResizable(false);
		setLocationRelativeTo(null);
	}
}
		
		itemAddStock = new JMenuItem("��� ���");
		menuManagement.add(itemAddStock);
		itemAddStock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddStock();
			}
		});

		itemSubStock = new JMenuItem("��� ����");
		menuManagement.add(itemSubStock);
		itemSubStock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SubStock();
			}
		});
		
		menuManagement.addSeparator();
		
		itemEditPrice = new JMenuItem("���� ����");
		menuManagement.add(itemEditPrice);
		itemEditPrice.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new EditPrice(kdto);
			}
		});
		
		String[] drinkLoopUp = {"���̴�", "�ݶ�", "ȯŸ", "��ī������Ʈ", "���̴� ����", "�ݶ� ����", "ȯŸ ����"," ��ī������Ʈ ����", "���Ǳ� �ݾ�" };
		drinkModel = new DefaultTableModel(drinkLoopUp, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		drinkKioskTable = new JTable(drinkModel);
		drinkKioskTable.setRowHeight(25);
		drinkKioskTable.getTableHeader().setReorderingAllowed(false);
		scroll = new JScrollPane(drinkKioskTable);
		scroll.setBounds(10, 10, 1000, 400);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		kioskAdminPanel.add(scroll);
		
		//�� �ߴ� �޼ҵ�
		//addSeparator();
		
		Thread tableList = new Thread(new Runnable() {
			@Override
			public void run() {
				KioskDAO kdao = new KioskDAO();
				while (true) {
					if (!kioskAdminPanel.isVisible()) {
						break;
					}
					drinkKioskTable.setModel(kdao.drinkTableList());
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		tableList.start();
		
		ct.add(kioskAdminPanel);
		
		setJMenuBar(menuBar);
		setTitle("Drink Kiosk Administator");
		setVisible(true);
		setSize(1035, 485);
		setResizable(false);
		setLocationRelativeTo(null);
	}
}