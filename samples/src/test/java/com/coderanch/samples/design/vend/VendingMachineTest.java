package com.coderanch.samples.design.vend;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

import org.junit.Test;

public class VendingMachineTest {

	private static final int FIRST_TRAY = 0;
	
	@Test
	public void should_instantiate_with_empty_trays() {
		VendingMachine testSubject = new VendingMachine();
		assertThat(testSubject.isEmpty(FIRST_TRAY), is(true)); 
	}
	
	@Test
	public void topUp_should_fill_up_empty_tray() throws Exception {
		VendingMachine testSubject = new VendingMachine();
		testSubject.fill(FIRST_TRAY);
		assertThat(testSubject.isEmpty(FIRST_TRAY), is(false));
	}
	
	@Test
	public void topUp_should_return_number_of_items_added_to_empty_tray() throws Exception {
		VendingMachine testSubject = new VendingMachine();
		int itemsAdded = testSubject.fill(FIRST_TRAY);
		assertThat(itemsAdded, is(8));
	}
}
