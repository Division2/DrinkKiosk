package com.java.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.java.ex.database.DBConnection;
import com.java.ex.dto.KioskDTO;

public class KioskDAO {

	Connection dbConn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public KioskDAO() {
	}

	public void loadPrice(KioskDTO kdto) {
		dbConn = DBConnection.getInstance();

		String sql = "SELECT * FROM drinkkiosk";

		try {
			pstmt = dbConn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				kdto.setCiderPrice(Integer.parseInt(rs.getString("ciderPrice")));
				kdto.setCokePrice(Integer.parseInt(rs.getString("cokePrice")));
				kdto.setFantaPrice(Integer.parseInt(rs.getString("fantaPrice")));
				kdto.setPocariPrice(Integer.parseInt(rs.getString("pocariPrice")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loadStock(KioskDTO kdto) {
		dbConn = DBConnection.getInstance();

		String sql = "SELECT * FROM drinkkiosk";

		try {
			pstmt = dbConn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				kdto.setCiderStock(Integer.parseInt(rs.getString("cider")));
				kdto.setCokeStock(Integer.parseInt(rs.getString("coke")));
				kdto.setFantaStock(Integer.parseInt(rs.getString("fanta")));
				kdto.setPocariStock(Integer.parseInt(rs.getString("pocarisweat")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loadRemainingAmount(KioskDTO kdto) {
		dbConn = DBConnection.getInstance();

		String sql = "SELECT * FROM drinkkiosk WEHERE = ?";

		try {
			pstmt = dbConn.prepareStatement(sql);
			pstmt.setString(1, "remainingAmount");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				kdto.setRemainingAmount(Integer.parseInt(rs.getString("remainingAmount")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addRemainingAmount(int price) {
		dbConn = DBConnection.getInstance();

		String sql = "UPDATE drinkkiosk SET remainingAmount = remainingAmount + ?";

		try {
			pstmt = dbConn.prepareStatement(sql);
			pstmt.setInt(1, price);
			int result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addDrinkStock(int type, String count) {
		dbConn = DBConnection.getInstance();

		String sql;
		
		try {
			if (type == 1) {
				sql = "UPDATE drinkkiosk SET cider = cider + ?";
				pstmt = dbConn.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(count));
				
				int result = pstmt.executeUpdate();
				if (1 == result) {
					JOptionPane.showMessageDialog(null, "���̴� ��� ����Ǿ����ϴ�.", "Kiosk", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else if (type == 2) {
				sql = "UPDATE drinkkiosk SET coke = coke + ?";
				pstmt = dbConn.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(count));
				
				int result = pstmt.executeUpdate();
				if (1 == result) {
					JOptionPane.showMessageDialog(null, "�ݶ� ��� ����Ǿ����ϴ�.", "Kiosk", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else if (type == 3) {
				sql = "UPDATE drinkkiosk SET fanta = fanta + ?";
				pstmt = dbConn.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(count));
				
				int result = pstmt.executeUpdate();
				if (1 == result) {
					JOptionPane.showMessageDialog(null, "ȯŸ ��� ����Ǿ����ϴ�.", "Kiosk", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else if (type == 4) {
				sql = "UPDATE drinkkiosk SET pocarisweat = pocarisweat + ?";
				pstmt = dbConn.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(count));
				
				int result = pstmt.executeUpdate();
				if (1 == result) {
					JOptionPane.showMessageDialog(null, "��ī������Ʈ ��� ����Ǿ����ϴ�.", "Kiosk", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "���ڸ� �Է��ϼ���.", "Admin", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void subDrinkStock(int type) {
		dbConn = DBConnection.getInstance();

		String sql;
		
		try {
			if (type == 1) {
				sql = "UPDATE drinkkiosk SET cider = cider - 1";
				pstmt = dbConn.prepareStatement(sql);
				int result = pstmt.executeUpdate();
			}
			else if (type == 2) {
				sql = "UPDATE drinkkiosk SET coke = coke - 1";
				pstmt = dbConn.prepareStatement(sql);
				int result = pstmt.executeUpdate();
			}
			else if (type == 3) {
				sql = "UPDATE drinkkiosk SET fanta = fanta - 1";
				pstmt = dbConn.prepareStatement(sql);
				int result = pstmt.executeUpdate();
			}
			else if (type == 4) {
				sql = "UPDATE drinkkiosk SET pocarisweat = pocarisweat - 1";
				pstmt = dbConn.prepareStatement(sql);
				int result = pstmt.executeUpdate();
			}
			} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void subDrinkStock(int type, String count) {
		dbConn = DBConnection.getInstance();

		String sql;
		
		try {
			if (type == 1) {
				sql = "UPDATE drinkkiosk SET cider = cider - ?";
				pstmt = dbConn.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(count));
				
				int result = pstmt.executeUpdate();
				if (1 == result) {
					JOptionPane.showMessageDialog(null, "���̴� ��� ����Ǿ����ϴ�.", "Kiosk", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else if (type == 2) {
				sql = "UPDATE drinkkiosk SET coke = coke - ?";
				pstmt = dbConn.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(count));
				
				int result = pstmt.executeUpdate();
				if (1 == result) {
					JOptionPane.showMessageDialog(null, "�ݶ� ��� ����Ǿ����ϴ�.", "Kiosk", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else if (type == 3) {
				sql = "UPDATE drinkkiosk SET fanta = fanta - ?";
				pstmt = dbConn.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(count));
				
				int result = pstmt.executeUpdate();
				if (1 == result) {
					JOptionPane.showMessageDialog(null, "ȯŸ ��� ����Ǿ����ϴ�.", "Kiosk", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else if (type == 4) {
				sql = "UPDATE drinkkiosk SET pocarisweat = pocarisweat - ?";
				pstmt = dbConn.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(count));
				
				int result = pstmt.executeUpdate();
				if (1 == result) {
					JOptionPane.showMessageDialog(null, "��ī������Ʈ ��� ����Ǿ����ϴ�.", "Kiosk", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "���ڸ� �Է��ϼ���.", "Admin", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void editDrinkPrice(int type, String price) {
		dbConn = DBConnection.getInstance();

		String sql;
		
		try {
			if (type == 1) {
				sql = "UPDATE drinkkiosk SET ciderPrice = ?";
				pstmt = dbConn.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(price));
				
				int result = pstmt.executeUpdate();
				if (1 == result) {
					JOptionPane.showMessageDialog(null, "���̴� ������ ����Ǿ����ϴ�.", "Kiosk", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else if (type == 2) {
				sql = "UPDATE drinkkiosk SET cokePrice = ?";
				pstmt = dbConn.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(price));
				
				int result = pstmt.executeUpdate();
				if (1 == result) {
					JOptionPane.showMessageDialog(null, "�ݶ� ������ ����Ǿ����ϴ�.", "Kiosk", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else if (type == 3) {
				sql = "UPDATE drinkkiosk SET fantaPrice = ?";
				pstmt = dbConn.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(price));
				
				int result = pstmt.executeUpdate();
				if (1 == result) {
					JOptionPane.showMessageDialog(null, "ȯŸ ������ ����Ǿ����ϴ�.", "Kiosk", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else if (type == 4) {
				sql = "UPDATE drinkkiosk SET pocariPrice = ?";
				pstmt = dbConn.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(price));
				
				int result = pstmt.executeUpdate();
				if (1 == result) {
					JOptionPane.showMessageDialog(null, "��ī������Ʈ ������ ����Ǿ����ϴ�.", "Kiosk", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "���ڸ� �Է��ϼ���.", "Admin", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public DefaultTableModel drinkTableList() {
		dbConn = DBConnection.getInstance();
		
		String[] drinkLoopUp = {"���̴�", "�ݶ�", "ȯŸ", "��ī������Ʈ", "���̴� ����", "�ݶ� ����", "ȯŸ ����"," ��ī������Ʈ ����", "���Ǳ� �ݾ�" };
		DefaultTableModel drinkModel = new DefaultTableModel(drinkLoopUp, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		String sql = "SELECT * FROM drinkkiosk";
		
		try {
			pstmt = dbConn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Object data[] = {
						rs.getString("cider"), rs.getString("coke"), rs.getString("fanta"), rs.getString("pocarisweat"),
						rs.getString("ciderPrice"), rs.getString("cokePrice"), rs.getString("fantaPrice"), rs.getString("pocariPrice"),
						rs.getString("remainingAmount")};
				drinkModel.addRow(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return drinkModel;
	}
}