package com.home.app;

import java.util.Scanner;

public class App {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		VendingMachine machine = new VendingMachine();
		
		// 자판기 초기화
		machine.init();
		
		// 자판기 전원켜기
		machine.turnOn();
		
		//프로세스 시작.
		boolean isRun = true;
			
		while(isRun) {
			System.out.println("------- VendingMachine ------");
			System.out.println("1. Admin");
			System.out.println("2. Customer");
			System.out.println("3. Quit");
			
			System.out.println("Select number : ");
			int selNum = Integer.parseInt(scanner.nextLine());
			
			switch(selNum) {
			// 관리자 객체 생성, 메뉴 호출
			case 1 :
				Admin admin = new Admin(machine);
				admin.adminMenu();
				break;
			// 고객 객체 생성, 메뉴 호출
			case 2 :
				Customer customer = new Customer(machine);
				break;
			// 종료
			case 3 :
				isRun = false;
				break;
			default :
				System.out.println("1 ~ 3 사이의 값을 입력하세요.");
				break;
			}
			
		}
		scanner.close();
	}
	
	
}

