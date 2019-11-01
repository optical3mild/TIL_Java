package com.example.japp.util;

public class AppMenuMaker {
	InputStringChecker isc = new InputStringChecker();
	
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
			if(i == 0) sList[i] = "["+sList[i]+"]-"; //초기 header
			else sList[i] = ""+i+". "+sList[i];
			
			//문자열 길이계산
			int thisLength = isc.strLength(sList[i]);
			if(strLength < thisLength) strLength = thisLength; // 가장 긴 항목길이를 저장
		}
		
		//header
		int headerLength = isc.strLength(sList[0]);
		if(strLength >= headerLength) { // 가장 긴 메뉴길이보다 한칸 더, 길이가 동일한 경우에도 한칸 더
			int count = strLength - headerLength;
			for(int i=0; i<count+1; i++) {
				sList[0] = sList[0] + "-";
			}
		} 
		
		//footer
		headerLength = isc.strLength(sList[0]);
		if(strLength < headerLength) strLength = headerLength;
		for(int i=0; i<strLength; i++) {
			footer = footer + "-";
		}
		
		//출력
		for(String str : sList) {
			System.out.println(str);
		}
		System.out.println(footer);
		System.out.print("메뉴선택: ");
		
	}
	
	public void statusPrinter(String title, String[] iList, int[] pList) {
		String line1 = ""; //첫째줄
		String line2 = ""; //둘째줄
		String header = "";
		String footer = "";
		
		// 첫째줄, 둘째줄 문자열 구성
		for(int i = 0; i<iList.length; i++) {
			if(i < iList.length/2 - 1) {
				line1 += (i+1)+"."+iList[i]+": "+pList[i]+" | ";
			} else if(i == (iList.length/2-1)) {
				line1 += (i+1)+"."+iList[i]+": "+pList[i];
			} else if(i == (iList.length-1)) {
				line2 += (i+1)+"."+iList[i]+": "+pList[i];
			} else {
				line2 += (i+1)+"."+iList[i]+": "+pList[i]+" | ";
			}
		}
		
		// 문자열 길이계산
		int leng1 = isc.strLength(line1);
		int leng2 = isc.strLength(line2);
		int lengTitle = isc.strLength(title)+3; // 기본 추가 문자길이 : 3
		
		int strLength = (leng1 >= leng2) ? ((leng1 >= lengTitle) ? leng1 : lengTitle) : ((leng2 >= lengTitle) ? leng2 : lengTitle);
		
		// header : 가장 긴 메뉴길이보다 짧은경우, 차이만큼 '=' 추가
		header += "["+title+"]=";
		if(lengTitle <= strLength) {
			for(int i=0; i<(strLength - lengTitle)+1; i++) {
				header += "=";
			}
		}
		// footer
		for(int i=0; i<strLength+1; i++) {
			footer += "=";
		}
		
		//화면에 출력
		System.out.println(header);
		System.out.println(line1);
		System.out.println(line2);
		System.out.println(footer);
	}
	
	
}
