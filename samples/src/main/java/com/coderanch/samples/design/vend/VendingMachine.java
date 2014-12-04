package com.coderanch.samples.design.vend;

public class VendingMachine {

	public static final int MAX_ITEMS_PER_TRAY = 8;
	public static final int MAX_TRAYS_PER_SHELF = 4;
	
	private int[] trays;
	
	public VendingMachine(int shelves) {
		trays = new int[shelves * MAX_TRAYS_PER_SHELF];
	}

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
