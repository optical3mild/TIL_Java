package com.example.japp;

import com.example.japp.model.Member;
import com.example.japp.model.VendingMachine;
import com.example.japp.util.AdminMenu;

public class MainApp {

	public static void main(String[] args) throws Exception {
		
		Member member1 = new Member("user1", "1234", "kim", "vender_01", 10000);

		VendingMachine vm1 = new VendingMachine();
		
		AdminMenu am = new AdminMenu();
		
		am.openVmDoor(vm1, member1);
	}

}
