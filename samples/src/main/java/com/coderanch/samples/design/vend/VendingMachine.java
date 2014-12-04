package com.coderanch.samples.design.vend;

public class VendingMachine {

	public static final int MAX_ITEMS_PER_TRAY = 8;
	
	private int[] trays = new int[4];
	
	public Boolean isEmpty(int tray) {
		return trays[tray] == 0;
	}

	public int fill(int tray) {
		trays[tray] = MAX_ITEMS_PER_TRAY;
		return MAX_ITEMS_PER_TRAY;
	}

	public void dispense(int tray) {
		
	}

}
