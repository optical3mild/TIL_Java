package com.example.japp.model;

public class Item {
	private String name;
	private String type;
	private String info;
	
	
	public Item(String name, String type, String info) {
		this.name = name;
		this.type = type;
		this.info = info;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}

	public String toString() {
		return "Item [name=" + name + ", type=" + type + ", info=" + info + "]";
	}
	
}
