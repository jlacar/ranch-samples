package com.coderanch.samples.design.vend;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;
import static org.hamcrest.core.IsNot.*;

import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {

	private static final int FIRST_TRAY = 0;
	private VendingMachine testSubject;
	
	@Before 
	public void setup() {
		testSubject = new VendingMachine(1);
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
	
	@Test
	public void fill_should_return_number_of_items_added_to_partially_empty_tray() throws Exception {
		testSubject.fill(FIRST_TRAY);
		testSubject.dispense(FIRST_TRAY);
		
		int itemsAdded = testSubject.fill(FIRST_TRAY);
		assertThat(itemsAdded, is(1));
	}
	
	@Test
	public void fill_should_not_overfill_a_tray() throws Exception {
		int itemsInitiallyAdded = testSubject.fill(FIRST_TRAY);
		int itemsSubsequentlyAdded = testSubject.fill(FIRST_TRAY);
		
		assertThat(itemsInitiallyAdded, is(not(0)));
		assertThat(itemsSubsequentlyAdded, is(0));
	}
	
	@Test
	public void should_instantiate_with_number_of_shelves() throws Exception {
		final int numberOfShelves = 4;
		final int lastTray = (VendingMachine.MAX_TRAYS_PER_SHELF * numberOfShelves) - 1;
		
		testSubject = new VendingMachine(numberOfShelves);
		assertThat(testSubject.isEmpty(lastTray), is(true));
	}
	
}
