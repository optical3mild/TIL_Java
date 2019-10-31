package com.example.japp.model;

import java.util.Arrays;

public class Member {
	
	private String userid;
	private String passwd;
	private String name;
	private int wallet;
	private Object[] poket = new Object[10];
	private String key;
	private Object container;
	
	
	// key가 없는 일반유저
	public Member(String userid, String passwd, String name, int wallet) {
		super();
		this.userid = userid;
		this.passwd = passwd;
		this.name = name;
		this.wallet = wallet;
	}

	// 기계관리자
	public Member(String userid, String passwd, String name, String key, int wallet) {
		super();
		this.userid = userid;
		this.passwd = passwd;
		this.name = name;
		this.key = key;
		this.wallet = wallet;
	}
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public int getWallet() {
		return wallet;
	}
	public void setWallet(int wallet) {
		this.wallet = wallet;
	}
	public Object[] getPoket() {
		return poket;
	}
	public void setPoket(Object[] poket) {
		this.poket = poket;
	}
	public Object getContainer() {
		return container;
	}
	public void setContainer(Object container) {
		this.container = container;
	}

	public String toString() {
		return "Member [name=" + name + ", passwd=" + passwd + ", key=" + key + ", wallet=" + wallet + ", poket="
				+ (poket != null ? Arrays.asList(poket) : null) + ", container=" + container + "]";
	}
	
}
