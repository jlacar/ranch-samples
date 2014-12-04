package com.coderanch.samples.design.vend;

public class VendingMachine {

	private int[] trays = new int[4];
	
	public Boolean isEmpty(int tray) {
		return trays[tray] == 0;
	}

	public void topUp(int tray) {
		trays[tray] = 8;
	}

}
