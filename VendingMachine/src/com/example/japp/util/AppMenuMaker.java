package com.example.japp.util;

public class AppMenuMaker {
	
	public void menuPrinter(String[] oList) {
		//배열 복사 : 같은배열에 반복적으로 작업되어 저장되지 않기위해
		String[] sList = new String[oList.length];
		for(int i=0; i<oList.length; i++) {
			sList[i] = oList[i];
		}
		String footer = "";
		
		//메뉴항목을 조합하고 가장 긴 항목 길이를 저장.
		int strLength = 0;
		
		for(int i=0; i<sList.length; i++) {
			if(i == 0) sList[i] = "["+sList[i]+"]-";
			else sList[i] = ""+i+". "+sList[i];
			
			//문자열 길이계산
			int thisLength = 0;
			for(int j=0; j<sList[i].length(); j++) {
				int charCode = sList[i].charAt(j);
				if(charCode >= 0 && charCode <= 126) thisLength += 1; //숫자&특수문자
				//else if(charCode >= 65 && charCode <= 126) thisLength += 1; //영문자
				else thisLength += 2; //한글 등 그 외
			}
			if(strLength < thisLength) strLength = thisLength;
		}
		
		//header
		if(strLength > sList[0].length()) {
			int count = strLength - sList[0].length();
			for(int i=1; i<count; i++) { // 미리 1개 추가되어 있음.
				sList[0] = sList[0] + "-";
			}
		}
		
		//footer
		for(int i=0; i<=strLength; i++) {
			footer = footer + "-";
		}
		
		//출력
		for(String str : sList) {
			System.out.println(str);
		}
		System.out.println(footer);
		System.out.print("메뉴선택: ");
		
	}
	
	public void statusPrinter(String[] sList) {
		
	}
}
