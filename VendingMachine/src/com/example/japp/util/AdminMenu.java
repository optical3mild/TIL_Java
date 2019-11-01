package com.example.japp.util;

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
			String[] subMenu2 = {"잔고관리", "잔고출금", "잔고입금", "돌아가기"};
			String[] subMenu3 = {"판매메뉴", "판매목록 설정", "판매가격 설정", "돌아가기"};
			
			while(run) {
				
				//기계상태 출력
				System.out.println("전원: " + vm.displayPw());
				System.out.println("잔고: " + vm.getSafeBox());
				
				//관리자 메인메뉴
				amm.menuPrinter(adminMenu);
				
				selectedMenu = Integer.parseInt(scan.nextLine());
				
				System.out.println("");	//줄바꿈
				
				int selectedSetting = 0;	//서브메뉴 선택
				boolean subMenuRun = true;		//서브메뉴 종료
				
				switch(selectedMenu) {
					// 전원조작
					case 1:
						while(subMenuRun) {
							System.out.println("전원: " + vm.displayPw());
							amm.menuPrinter(subMenu1);
							selectedSetting = Integer.parseInt(scan.nextLine());
							
							if(selectedSetting == 1) {
								vm.setPower_on(true);
							} else if(selectedSetting == 2){
								vm.setPower_on(false);
							} else if(selectedSetting == 3){
								System.out.println("관리자메뉴로 돌아갑니다.");
								subMenuRun = false;
							} else {
								System.out.println("메뉴에서 선택하세요.");
							}
							System.out.println("");
						}
						break;
					
					// 잔고조작
					case 2:
						while(subMenuRun) {
							System.out.println("기계잔액 : " + vm.getSafeBox());
							System.out.println("소지금액 : " + vmAdmin.getWallet());
							amm.menuPrinter(subMenu2);
							
							selectedSetting = Integer.parseInt(scan.nextLine());
							
							if(selectedSetting == 1) {
								System.out.print("출금금액: ");
								int withdrawal = Integer.parseInt(scan.nextLine());
								
								if(vm.getSafeBox() >= withdrawal) {
									vm.setSafeBox(vm.getSafeBox() - withdrawal);
									vmAdmin.setWallet(vmAdmin.getWallet() + withdrawal);
								} else {
									System.out.println("기계잔액이 부족합니다");
								}
							} else if(selectedSetting == 2) {
								System.out.print("입금금액: ");
								int deposit = Integer.parseInt(scan.nextLine());
								if(vmAdmin.getWallet() >= deposit) {
									vm.setSafeBox(vm.getSafeBox() + deposit);
									vmAdmin.setWallet(vmAdmin.getWallet() - deposit);
								} else {
									System.out.println("소지금액이 부족합니다");
								}
							} else if(selectedSetting == 3) {
								System.out.println("관리자메뉴로 돌아갑니다.");
								subMenuRun = false;
							} else {
								System.out.println("메뉴에서 선택하세요.");
							}
							System.out.println("");
						}
						break;
					
					//판매메뉴설정
					case 3:
						while(subMenuRun) {
							//현재메뉴 출력
							String[] iList = vm.getItemList();
							int[] pList = vm.getPriceList();
							amm.statusPrinter("판매메뉴", iList, pList);;
							//subMenu3 출력
							amm.menuPrinter(subMenu3);
							
							selectedSetting = Integer.parseInt(scan.nextLine());
							InputStringChecker isc = new InputStringChecker();
							
							if(selectedSetting == 1) {
								//판매목록 설정
								for(int i=0; i<iList.length; i++) {
									System.out.print((i+1)+"번: ");
									String temp = scan.nextLine();
									if(isc.isEmpty(temp)) iList[i] = "Empty";
									else iList[i] = temp;
								}
							} else if(selectedSetting == 2) {
								//판매가격 설정
								for(int i=0; i<pList.length; i++) {
									boolean putPrice = true;
									String temp = "";
									while(putPrice) {
										System.out.print((i+1)+". "+iList[i]+": ");
										temp = scan.nextLine();
										if(isc.isEmpty(temp)) { //전체공백인지 확인
											temp = "0";
											putPrice = false;
										} else { //정수로 입력되었는지 확인
											putPrice = isc.isNotInteger(temp);
											if(putPrice == true) System.out.println("정수를 입력하세요.");
										}
									}
									pList[i] = Integer.parseInt(temp);
								}
							} else if(selectedSetting == 3) {
								System.out.println("관리자메뉴로 돌아갑니다.");
								subMenuRun = false;
							} else {
								System.out.println("메뉴에서 선택하세요.");
							}
							System.out.println("");
						}
						break;
					
					//제품 저장공간 조작
					case 4:
						while(subMenuRun) {
							
							System.out.println("");
						}
						break;
					
					//기계현황 출력
					case 5:
						while(subMenuRun) {
							
							System.out.println("");
						}
						break;
					
					//메인메뉴로 이동
					case 6:
						System.out.println("문을 닫고 메인메뉴로 이동합니다.");
						run = false;
						System.out.println("");
						break;
					
					//메뉴 이외의 값이 입력된 경우
					default :
						System.out.println("1 ~ 6 사이의 숫자를 입력하세요.");
						System.out.println("");
						break;
				}
			}
		}
	}
	
}
