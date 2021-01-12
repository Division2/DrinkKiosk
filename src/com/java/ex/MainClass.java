package com.java.ex;

import com.java.ex.drinkkiosk.KioskUser;
import com.java.ex.dto.KioskDTO;

public class MainClass {
	public static void main(String[] args) {
		KioskDTO kdto = new KioskDTO();
		new KioskUser(kdto);
	}
}