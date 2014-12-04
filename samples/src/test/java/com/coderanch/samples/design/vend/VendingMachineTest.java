package com.coderanch.samples.design.vend;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {

	private static final int FIRST_TRAY = 0;
	private VendingMachine testSubject;
	
	@Before 
	public void setup() {
		testSubject = new VendingMachine();
	}
	
	@Test
	public void should_instantiate_with_empty_trays() {
		assertThat(testSubject.isEmpty(FIRST_TRAY), is(true)); 
	}
	
	@Test
	public void fill_should_fill_up_empty_tray() throws Exception {
		testSubject.fill(FIRST_TRAY);
		assertThat(testSubject.isEmpty(FIRST_TRAY), is(false));
	}
	
	@Test
	public void fill_should_return_number_of_items_added_to_empty_tray() throws Exception {
		int itemsAdded = testSubject.fill(FIRST_TRAY);
		assertThat(itemsAdded, is(VendingMachine.MAX_ITEMS_PER_TRAY));
	}
}
