package com.example.japp;

import java.util.List;

public class VendingMachine {

	private static final String MACHINE_KEY = "vender_01";
	private boolean power_on = false;
	
	private int deposit;	// 투입금액
	private int safeBox;	// 기계잔고
	
	private String[] itemList = new String[10];	// 각 슬롯별 아이템 이름
	private int[] priceList = new int[10];	// 각 슬롯별 가격정보
	
	private List[] stocker = new List[10];	// 제품 저장공간. 인덱스별로 ArrayList에 동일 아이템을 담아 저장한다.

	
	
	// getter/setter
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

	public static String getMachineKey() {
		return MACHINE_KEY;
	}

	public String toString() {
		return "VendingMachine [power_on=" + power_on + ", deposit=" + deposit + ", safeBox=" + safeBox + ", itemList="
				+ (itemList != null ? arrayToString(itemList, itemList.length) : null) + ", priceList="
				+ (priceList != null ? arrayToString(priceList, priceList.length) : null) + ", stocker="
				+ (stocker != null ? arrayToString(stocker, stocker.length) : null) + "]";
	}

	private String arrayToString(Object array, int len) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[");
		for (int i = 0; i < len; i++) {
			if (i > 0)
				buffer.append(", ");
			if (array instanceof int[])
				buffer.append(((int[]) array)[i]);
			if (array instanceof Object[])
				buffer.append(((Object[]) array)[i]);
		}
		buffer.append("]");
		return buffer.toString();
	}
	
	
	
	
}
