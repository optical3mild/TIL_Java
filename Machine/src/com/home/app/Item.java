package com.home.app;

public class Item {
	private String itemName;
	private int itemCnt = 0;
	//private int itemValue = 0;
	public static final int MIN_VAL = 0;
	public static final int MAX_VAL = 10;
	public static final int NOT_ENOUGH = 501;
	public static final int TOO_MANY = 502;
	
	
	public Item(String name, int cnt) {
		this.itemName = name;
		this.itemCnt = cnt;
		//this.itemValue = value;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemCnt() {
		return itemCnt;
	}

	// item의 총 갯수가 0개 미만, 10개 초과일 경우 return false, 저장x.
	public int setItemCnt(int itemCnt) {
		if(itemCnt < MIN_VAL) {
			return NOT_ENOUGH;
		} else if(itemCnt > MAX_VAL) {
			return TOO_MANY;
		} else {
			this.itemCnt = itemCnt;
			return this.itemCnt;
		}
	}

//	public int getItemValue() {
//		return itemValue;
//	}
//
//	public void setItemValue(int itemValue) {
//		this.itemValue = itemValue;
//	}
}
