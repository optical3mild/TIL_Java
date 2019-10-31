package com.example.japp.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.example.japp.model.Member;
import com.example.japp.model.VendingMachine;

public class AdminMenu {
	
	Scanner scan = new Scanner(System.in);

	// 관리자 메뉴 진입
	public void openVmDoor(VendingMachine vm, Member member) throws Exception {
		if(member.getKey() != vm.getMachineKey()) {
			System.out.println("맞는 열쇠가 없습니다.");
		} else {
			boolean run = true;
			AppMenuMaker amm = new AppMenuMaker();
			
			int selectedMenu = 0;
			
			Member vmAdmin = member;
			
			
			String[] adminMenu = {"기계관리","전원조작","잔고관리","판매메뉴","제품적재","기계현황","기계관리 종료"};
			String[] subMenu1 = {"전원조작","켜기","끄기","돌아가기"};
			
			while(run) {
				//현재 기계전원
				String pw; 
				if(vm.isPower_on()) pw = "POWER ON";
				else pw = "POWER OFF";
				
				//현재 기계잔고
				int vmSafeBox = vm.getSafeBox();
				
				//기계상태 출력
				System.out.println("전원: " + pw);
				System.out.println("잔고: " + vmSafeBox);
				
				//관리자 메인메뉴
				amm.menuPrinter(adminMenu);
				
				
				/*
				System.out.println("[기계관리]---------");
				System.out.println("1.전원조작");
				System.out.println("2.잔고관리");
				System.out.println("3.판매메뉴");
				System.out.println("4.제품적재");
				System.out.println("5.기계현황");
				System.out.println("6.기계관리 종료");
				System.out.println("-------------------");
				System.out.print("메뉴선택: ");
				*/
				selectedMenu = Integer.parseInt(scan.nextLine());
				
				int selectedSetting = 0;	//서브메뉴 선택
				boolean subMenu = true;		//서브메뉴 종료
				
				switch(selectedMenu) {
					// 전원조작
					case 1:
						while(subMenu) {
							/*
							System.out.println("전원 : " + vm.isPower_on());
							System.out.println("[1.전원조작]--");
							System.out.println("1.켜기");
							System.out.println("2.끄기");
							System.out.println("3.돌아가기");
							System.out.println("------------");
							System.out.print("메뉴선택: ");
							*/
							amm.menuPrinter(subMenu1);
							
							selectedSetting = Integer.parseInt(scan.nextLine());
							
							if(selectedSetting == 1) {
								vm.setPower_on(true);
								System.out.println("전원 : 켜짐");
							} else if(selectedSetting == 2){
								vm.setPower_on(false);
								System.out.println("전원 : 꺼짐");
							} else if(selectedSetting == 3){
								System.out.println("관리자메뉴로 돌아갑니다.");
								subMenu = false;
							} else {
								System.out.println("메뉴에서 선택하세요.");
							}
						}
						break;
					
					//잔고조작
					case 2:
						while(subMenu) {
							System.out.println("[2.잔고관리]-----");
							System.out.println("현재잔고: " + vm.getSafeBox());
							System.out.println("1.잔고출금");
							System.out.println("2.잔고입금");
							System.out.println("3.돌아가기");
							System.out.println("-----------------");
							System.out.print("메뉴선택: ");
							
							selectedSetting = Integer.parseInt(scan.nextLine());
							
							if(selectedSetting == 1) {
								System.out.print("출금금액: ");
								int withdrawal = Integer.parseInt(scan.nextLine());
								
								if(vm.getSafeBox() >= withdrawal) {
									vm.setSafeBox(vm.getSafeBox() - withdrawal);
									System.out.println("잔액 : " + vm.getSafeBox());
								} else {
									System.out.println("잔고가 부족합니다");
								}
							} else if(selectedSetting == 2) {
								System.out.print("입금금액: ");
								int withdrawal = Integer.parseInt(scan.nextLine());
								vm.setSafeBox(vm.getSafeBox() + withdrawal);
								System.out.println("잔액 : " + vm.getSafeBox());
							} else if(selectedSetting == 3) {
								System.out.println("관리자메뉴로 돌아갑니다.");
								subMenu = false;
							} else {
								System.out.println("메뉴에서 선택하세요.");
							}
						}
						break;
					
					//판매메뉴설정
					case 3:
						while(subMenu) {
							MenuWriter mw = new MenuWriter();
							mw.mWriter(vm);
							subMenu = false;
						}
						break;
					
					//제품 저장공간 조작
					case 4:
						while(subMenu) {
							
						}
						break;
					
					//기계현황 출력
					case 5:
						while(subMenu) {
							
						}
						break;
					
					//메인메뉴로 이동
					case 6:
						System.out.println("문을 닫고 메인메뉴로 이동합니다.");
						run = false;
						break;
					
					//메뉴 이외의 값이 입력된 경우
					default :
						System.out.println("1 ~ 6 사이의 숫자를 입력하세요.");
						break;
				}
			}
		}
	}
}
