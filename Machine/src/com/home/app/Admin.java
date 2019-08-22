package com.home.app;

import java.util.Scanner;

public class Admin {
	//권한필요?;;
	private boolean rights = true;
	
	//필드 -- 외부의 자판기 객체를 저장.
	private VendingMachine vm;
	
	public Admin(VendingMachine vm) {
		this.vm = vm;
	}
	
	public boolean inputDrink(String name, int cnt) {
		boolean result = vm.inputDrink(name, cnt);
		return result;
	}
	public boolean outputDrink(String name, int cnt) {
		boolean result = vm.outputDrink(name, cnt);
		return result;
	}
	
	//자판기 공간 비우기.
	public void emptySlot(String name) {
		
		
	}
	
	//자판기 거스름돈 채우기 --> 채운 잔돈 목록 출력...

	//정산
	
	//관리자 메뉴
	public void adminMenu() {
		Scanner scanner = new Scanner(System.in);
		
		boolean isRun = true;
		while(isRun) {
			System.out.println("------ AdminMenu ------");
			System.out.println("[물품관리]");

			//해당 항목의 개수를 확인하고 최대치로 채워넣기 : 채워넣은 항목 이름과 개수를 출력.
			System.out.println("1. 품목 채우기");
			
			//해당 항목의 이름과 개수를 출력하고 목록과 데이터 삭제.
			System.out.println("2. 품목 비우기");
			
			//현재 저장되어 있는 모든 항목의 이름, 개수, 가격을 출력.
			System.out.println("3. 품목 목록");
			
			//메인으로 돌아가기
			System.out.println("4. 메인화면으로");
			
			System.out.println("Select number : ");
			int selNum = Integer.parseInt(scanner.nextLine());
			
			switch(selNum) {
			case 1 :
				//현재 자판기의 아이템 키 값을 배열로 저장.
				//목록 출력 : 이름 남은갯수 단가
				
				//번호로 선택
				
				//선택하면 
				break;
			case 2 :
				break;
			case 3 :
				break;
			case 4 :
				break;	
			default :
				System.out.println("1 ~ 4 사이의 값을 입력하세요.");
				break;
			}
		}
	}
}


