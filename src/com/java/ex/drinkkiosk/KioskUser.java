package com.java.ex.drinkkiosk;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.java.ex.dao.KioskDAO;
import com.java.ex.dto.KioskDTO;

public class KioskUser extends JFrame {
	int coin;
	String userCoin;
	
	JPanel kioskPanel;
	JLabel cider;
	JLabel coke;
	JLabel fanta;
	JLabel pocarisweat;
	JLabel inputCoin;
	
	ImageIcon ciderIcon;
	ImageIcon cokeIcon;
	ImageIcon fantaIcon;
	ImageIcon pocariIcon;
	ImageIcon coinIcon;
	
	JButton btncider;
	JButton btncoke;
	JButton btnfanta;
	JButton btnpocari;
		
	JLabel lblCurrentAmount;
	JTextField txtCurrentAmount;
	
	JButton smallChange;
	
	JLabel outlet;
	
	JLabel adminShow;
	
	public KioskUser(KioskDTO kdto) {
		
		Container ct = getContentPane();
		kioskPanel = new JPanel();
		kioskPanel.setLayout(null);

//		현재 프로젝트의 위치 구하기
//		File path = new File("");
//		System.out.println(path.getAbsolutePath());
		
		ciderIcon = new ImageIcon("./src/img/cider.png");
		cider = new JLabel(ciderIcon);
		cider.setBounds(10, 10, 100, 150);
		
		btncider = new JButton(String.valueOf(kdto.getCiderPrice()));
		btncider.setEnabled(false);
		btncider.setBounds(10, 170, 100, 30);
		btncider.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				KioskDAO kdao = new KioskDAO();
				if (coin >= kdto.getCiderPrice()) {
					outlet.setIcon(ciderIcon);
					coin -= kdto.getCiderPrice();
					txtCurrentAmount.setText(String.valueOf(coin));
					
					kdao.subDrinkStock(1);
					kdao.addRemainingAmount(kdto.getCiderPrice());
				}
			}
		});
		
		cokeIcon = new ImageIcon("./src/img/coke.png");
		coke = new JLabel(cokeIcon);
		coke.setBounds(120, 10, 100, 150);
		
		btncoke = new JButton(String.valueOf(kdto.getCokePrice()));
		btncoke.setEnabled(false);
		btncoke.setBounds(120, 170, 100, 30);
		btncoke.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				KioskDAO kdao = new KioskDAO();
				if (coin >= kdto.getCokePrice()) {
					outlet.setIcon(cokeIcon);
					coin -= kdto.getCokePrice();
					txtCurrentAmount.setText(String.valueOf(coin));
					
					kdao.subDrinkStock(2);
					kdao.addRemainingAmount(kdto.getCiderPrice());
				}
			}
		});
		
		fantaIcon = new ImageIcon("./src/img/fanta.png");
		fanta = new JLabel(fantaIcon);
		fanta.setBounds(240, 10, 100, 150);
		
		btnfanta = new JButton(String.valueOf(kdto.getFantaPrice()));
		btnfanta.setEnabled(false);
		btnfanta.setBounds(240, 170, 100, 30);
		btnfanta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				KioskDAO kdao = new KioskDAO();
				if (coin >= kdto.getFantaPrice()) {
					outlet.setIcon(fantaIcon);
					coin -= kdto.getFantaPrice();
					txtCurrentAmount.setText(String.valueOf(coin));
					
					kdao.subDrinkStock(3);
					kdao.addRemainingAmount(kdto.getCiderPrice());
				}
			}
		});
		
		pocariIcon = new ImageIcon("./src/img/pocari.png");
		pocarisweat = new JLabel(pocariIcon);
		pocarisweat.setBounds(360, 10, 100, 150);
		
		btnpocari = new JButton(String.valueOf(kdto.getPocariPrice()));
		btnpocari.setEnabled(false);
		btnpocari.setBounds(360, 170, 100, 30);
		btnpocari.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				KioskDAO kdao = new KioskDAO();
				if (coin >= kdto.getPocariPrice()) {
					outlet.setIcon(pocariIcon);
					coin -= kdto.getPocariPrice();
					txtCurrentAmount.setText(String.valueOf(coin));
					
					kdao.subDrinkStock(4);
					kdao.addRemainingAmount(kdto.getCiderPrice());
				}
			}
		});
		
		coinIcon = new ImageIcon("./src/img/coin.png");
		inputCoin = new JLabel(coinIcon);
		inputCoin.setBounds(410, 220, 50, 50);
		inputCoin.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseClicked(MouseEvent e) {
				userCoin = JOptionPane.showInputDialog("투입할 금액을 입력해주세요.\n숫자만 입력해야합니다.");

				if (userCoin != null) {
					coin += Integer.parseInt(userCoin);					
				}
				txtCurrentAmount.setText(String.valueOf(coin));
            }
		});
		
		lblCurrentAmount = new JLabel("현재 투입된 금액 : ");
		lblCurrentAmount.setBounds(10, 220, 100, 50);
		
		txtCurrentAmount = new JTextField("0");
		txtCurrentAmount.setBounds(110, 220, 200, 50);
		txtCurrentAmount.setEditable(false);
		txtCurrentAmount.setHorizontalAlignment(JTextField.CENTER);
		
		smallChange = new JButton("잔돈");
		smallChange.setBounds(320, 220, 80, 50);
		smallChange.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (0 == coin) {
					JOptionPane.showMessageDialog(null, "반환할 잔돈이 없습니다.", "Kiosk", JOptionPane.ERROR_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "잔돈 : " + coin + "입니다.", "Kiosk", JOptionPane.INFORMATION_MESSAGE);
					coin = 0;
					txtCurrentAmount.setText("0");
				}
			}
		});
		
		outlet = new JLabel();
		outlet.setBounds(70, 300, 330, 130);
		outlet.setHorizontalAlignment(JLabel.CENTER);
		outlet.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		adminShow = new JLabel();
		adminShow.setBounds(430, 430, 30, 30);
		adminShow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String password = JOptionPane.showInputDialog("관리자 비밀번호 입력");
				if (password != null && password.equals("1234")) {
					new KioskAdmin(kdto);
				}
				else {
					JOptionPane.showMessageDialog(null, "비밀번호가 틀렸거나 입력되지 않았습니다.", "Kiosk", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		Thread btnEnableThread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					if (!kioskPanel.isVisible()) {
						break;
					}
					if (0 < kdto.getCiderStock()) {
						if (coin >= kdto.getCiderPrice()) {
							btncider.setEnabled(true);
							btncider.setText("O");
						}
						else {
							btncider.setEnabled(false);
							btncider.setText(String.valueOf(kdto.getCiderPrice()));
						}
					}
					else {
						btncider.setEnabled(false);
						btncider.setText("X");
					}
					if (0 < kdto.getCokeStock()) {
						if (coin >= kdto.getCokePrice()) {
							btncoke.setEnabled(true);
							btncoke.setText("O");
						}
						else {
							btncoke.setEnabled(false);
							btncoke.setText(String.valueOf(kdto.getCokePrice()));
						}
					} else {
						btncoke.setEnabled(false);
						btncoke.setText("X");
					}
					
					if (0 < kdto.getFantaStock()) {
						if (coin >= kdto.getFantaPrice()) {
							btnfanta.setEnabled(true);
							btnfanta.setText("O");
						}
						else {
							btnfanta.setEnabled(false);
							btnfanta.setText(String.valueOf(kdto.getFantaPrice()));
						}
					} else {
						btnfanta.setEnabled(false);
						btnfanta.setText("X");
					}
					
					if (0 < kdto.getPocariStock()) {
						if (coin >= kdto.getPocariPrice()) {
							btnpocari.setEnabled(true);
							btnpocari.setText("O");
						}
						else {
							btnpocari.setEnabled(false);
							btnpocari.setText(String.valueOf(kdto.getPocariPrice()));
						}
					} else {
						btnpocari.setEnabled(false);
						btnpocari.setText("X");
					}
				}
			}
		});
		btnEnableThread.start();
		
		Thread loadPriceStock = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					KioskDAO kdao = new KioskDAO();
					kdao.loadStock(kdto);
					kdao.loadPrice(kdto);
					
					if (!kioskPanel.isVisible()) {
						break;
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		loadPriceStock.start();
		
		kioskPanel.add(cider);
		kioskPanel.add(coke);
		kioskPanel.add(fanta);
		kioskPanel.add(pocarisweat);
		kioskPanel.add(btncider);
		kioskPanel.add(btncoke);
		kioskPanel.add(btnfanta);
		kioskPanel.add(btnpocari);
		kioskPanel.add(inputCoin);
		kioskPanel.add(lblCurrentAmount);
		kioskPanel.add(txtCurrentAmount);
		kioskPanel.add(smallChange);
		kioskPanel.add(outlet);
		kioskPanel.add(adminShow);
		
		ct.add(kioskPanel);
		
		setVisible(true);
		setSize(485, 500);
		setTitle("Drink Kiosk");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}