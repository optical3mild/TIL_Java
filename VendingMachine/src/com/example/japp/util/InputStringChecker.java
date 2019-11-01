package com.example.japp.util;

import java.util.Scanner;

public class InputStringChecker {
	Scanner scan = new Scanner(System.in);
	
	//문자열 길이 계산: 한글-2자리, 영문/숫자/특수문자-1자리
	public int strLength(String str) {
		int result = 0;
		for(int i=0; i<str.length(); i++) {
			int charCode = str.charAt(i);
			if(charCode >= 0 && charCode <= 126) result += 1; //숫자&특수문자&영문자
			else result += 2; //한글 등 그 외
		}
		return result;
	}
	
	//입력된 값이 정수인지 판별
	public boolean isNotInteger(String str) {
		boolean result = false;
		for(int i=0; i<str.length(); i++) {
			int charCode = str.charAt(i);
			if(charCode <= 48 && charCode >= 57) result = true; //한글자라도 숫자가 아닌경우
		}
		return result;
	}
	
	//입력된 문자열이 공백으로만 이루어져 있는지 확인
	public boolean isEmpty(String str) {
		boolean result = true;
		for(int i=0; i<str.charAt(i); i++) {
			if(str.charAt(i) != 32) result = false;
		}
		return result;
	}
	
	
	//숫자 입력기 : 공백/정수인지 확인
	public int intWriter(String str) {
		int result = 0;
		
		return result;
	}
	//문자 입력기
}
