package com.java.ex.dto;

public class KioskDTO {
	int ciderStock = 0;
	int cokeStock = 0;
	int fantaStock = 0;
	int pocariStock = 0;

	int ciderPrice = 0;
	int cokePrice = 0;
	int fantaPrice = 0;
	int pocariPrice = 0;
	
	int remainingAmount = 0;

	public int getCiderStock() {
		return ciderStock;
	}
	public void setCiderStock(int ciderStock) {
		this.ciderStock = ciderStock;
	}
	public int getCokeStock() {
		return cokeStock;
	}
	public void setCokeStock(int cokeStock) {
		this.cokeStock = cokeStock;
	}
	public int getFantaStock() {
		return fantaStock;
	}
	public void setFantaStock(int fantaStock) {
		this.fantaStock = fantaStock;
	}
	public int getPocariStock() {
		return pocariStock;
	}
	public void setPocariStock(int pocariStock) {
		this.pocariStock = pocariStock;
	}
	public int getCiderPrice() {
		return ciderPrice;
	}
	public void setCiderPrice(int ciderPrice) {
		this.ciderPrice = ciderPrice;
	}
	public int getCokePrice() {
		return cokePrice;
	}
	public void setCokePrice(int cokePrice) {
		this.cokePrice = cokePrice;
	}
	public int getFantaPrice() {
		return fantaPrice;
	}
	public void setFantaPrice(int fantaPrice) {
		this.fantaPrice = fantaPrice;
	}
	public int getPocariPrice() {
		return pocariPrice;
	}
	public void setPocariPrice(int pocariPrice) {
		this.pocariPrice = pocariPrice;
	}
	public int getRemainingAmount() {
		return remainingAmount;
	}
	public void setRemainingAmount(int remainingAmount) {
		this.remainingAmount = remainingAmount;
	}
}