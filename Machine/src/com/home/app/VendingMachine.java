package com.home.app;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class VendingMachine {
	//자판기의 최대 제품종류 제한 필요. --> map의 갯수조회 후 최대값 제한.
	
	//거스름돈
	
	//음료수 등 자판기의 내용물
	private Map<String, Item> items;
	
	//가격목록
	private Map<String, Integer> priceList;
	
	//전원상태
	private boolean power;
	
	public void init() {
		items = new HashMap<String, Item>();
	}
	
	public void turnOn() {
		power = true;
	}
	
	public void turnOff() {
		power = false;
	}
	
	// 아이템 투입 -- 조회이후 갯수확인, 기존의 개수에 투입개수를 더하고 저장.
	public boolean inputDrink(String itemName, int itemCnt) {
		//존재여부 확인.
		if(items.containsKey(itemName)) {
			//현재 갯수에 입력값을 계산하여 결과 확인.
			int calCnt = items.get(itemName).getItemCnt() + itemCnt;
			
			if(calCnt > Item.MAX_VAL) {
				// 최대치 보다 많은경우, false 반환
				return false;
			} else {
				// 적정값인 경우, 객체를 새로 생성하여 목록에 업데이트 후 True 반환.
				Item newItem = new Item(itemName, calCnt);
				items.put(itemName, newItem);
				return true;
			}
		} else {
			//새로 넣는경우, 아이템이름과 갯수로 객체를 생성하고 map에 저장하고 true반환.
			Item newItem = new Item(itemName, itemCnt);
			items.put(itemName, newItem);
			return true;
		}
		
	}
	
	// 아이템 꺼내기 -- 조회이후 개수확인, 기존의 개수에서 꺼내는 개수를 차감하고 저장.
	public boolean outputDrink(String itemName, int itemCnt) {
		//존재여부 확인.
		if(items.containsKey(itemName)) {
			//현재 갯수에 입력값을 계산하여 결과 확인.
			int calCnt = items.get(itemName).getItemCnt() - itemCnt;
			
			if(calCnt < Item.MIN_VAL) {
				// 최소값 보다 적은경우, false 반환
				return false;
			} else {
				// 적정값인 경우, 아이템이름과 갯수로 객체를 생성하고 map에 저장하고 true반환.
				Item newItem = new Item(itemName, calCnt);
				items.put(itemName, newItem);
				return true;
			}
		} else {
			//아이템이 없는 경우 false반환.
			return false;
		}
	}
	
	// 목록출력
	public String[] getDrinkList() {
		String[] itemList = new String[9];
		System.out.println("-------상품목록-------");
		
		if(items.size() > 0) {
			Set<String> keySet = items.keySet();
			Iterator<String> keyIterator = keySet.iterator();
			int itemNo = 0;
			while(keyIterator.hasNext()) {
				String thisKey = keyIterator.next();
				Item thisItem = items.get(thisKey);
				System.out.println(itemNo + ". " + thisItem.getItemName() +" : "+ thisItem.getItemCnt() +"개");
				itemList[itemNo] = thisItem.getItemName();
			}
			return itemList;
		} else {
			System.out.println("상품이 없습니다.");
			return itemList;
		}
	}
}
