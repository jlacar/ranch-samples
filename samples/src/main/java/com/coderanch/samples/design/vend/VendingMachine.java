package com.coderanch.samples.design.vend;

public class VendingMachine {

	public static final int MAX_ITEMS_PER_TRAY = 8;
	
	private int[] trays = new int[4];
	
	public Boolean isEmpty(int tray) {
		return trays[tray] == 0;
	}

	public int fill(int tray) {
		int howManyAdded = MAX_ITEMS_PER_TRAY - trays[tray];
		trays[tray] = MAX_ITEMS_PER_TRAY;
		return howManyAdded;
	}

	public void dispense(int tray) {
        trays[tray] -= 1;		
	}

}
