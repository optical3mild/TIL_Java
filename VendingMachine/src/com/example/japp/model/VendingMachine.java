package com.example.japp.model;

import java.util.List;

public class VendingMachine {

	private static final String MACHINE_KEY = "vender_01";
	private boolean power_on = false;
	
	private int deposit;	// 투입금액
	private int safeBox;	// 기계잔고
	private int refund;		// 반환금
	
	private String[] itemList = new String[10];	// 각 슬롯별 아이템 이름
	private int[] priceList = new int[10];	// 각 슬롯별 가격정보
	
	private List[] stocker = new List[10];	// 제품 저장공간. 인덱스별로 ArrayList에 동일 아이템을 담아 저장한다.
	private Object[] outlet = new Object[20]; // 물건 배출구
	
	//전원표시
	public String displayPw() {
		String pw; 
		if(isPower_on()) pw = "켜짐";
		else pw = "꺼짐";
		
		return pw;
	}
	
	
	public VendingMachine() {
		super();
	}

	public VendingMachine(boolean power_on, int safeBox) {
		super();
		this.power_on = power_on;
		this.safeBox = safeBox;
	}

	// getter/setter/toString
	public boolean isPower_on() {
		return power_on;
	}

	public void setPower_on(boolean power_on) {
		this.power_on = power_on;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getSafeBox() {
		return safeBox;
	}

	public void setSafeBox(int safeBox) {
		this.safeBox = safeBox;
	}

	public int getRefund() {
		return refund;
	}

	public void setRefund(int refund) {
		this.refund = refund;
	}

	public String[] getItemList() {
		return itemList;
	}

	public void setItemList(String[] itemList) {
		this.itemList = itemList;
	}

	public int[] getPriceList() {
		return priceList;
	}

	public void setPriceList(int[] priceList) {
		this.priceList = priceList;
	}

	public List[] getStocker() {
		return stocker;
	}

	public void setStocker(List[] stocker) {
		this.stocker = stocker;
	}

	public Object[] getOutlet() {
		return outlet;
	}

	public void setOutlet(Object[] outlet) {
		this.outlet = outlet;
	}

	public String getMachineKey() {
		return MACHINE_KEY;
	}

	
}
