package com.example.japp.util;

import java.util.Scanner;

import com.example.japp.model.VendingMachine;

public class MenuWriter {
	
	Scanner scan = new Scanner(System.in);
	
	public void mWriter(VendingMachine vm) {
		boolean subMenu = true;
		
		while(subMenu) {
			String[] menu = vm.getItemList();
			int[] pList = vm.getPriceList();

			
			System.out.println("판매메뉴=============================================");
			for(int i=0; i<menu.length; i++) {
				if(i == (menu.length-1) || i == 4) {
					
					System.out.println(""+i+". "+menu[i]+": "+pList[i]);
				} else {
					System.out.print(""+i+". "+menu[i]+": "+pList[i]+" | ");
				}
			}
			System.out.println("=====================================================");
			
			System.out.println("[3.판매메뉴 설정]----");
			System.out.println("1.판매목록 설정");
			System.out.println("2.판매가격 설정");
			System.out.println("3.돌아가기");
			System.out.println("---------------------");
			System.out.print("메뉴선택: ");
			
			int selectedMenu = Integer.parseInt(scan.nextLine());
			
			if(selectedMenu == 1) {
				
			}
		}
			
		
	}
}
