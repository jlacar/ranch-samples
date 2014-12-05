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
		testSubject = new VendingMachine();
	}

	@Test
	public void should_instantiate_with_empty_trays() {
		assertThat(testSubject.isEmpty(FIRST_TRAY), is(true));
	}

	@Test
	public void should_instantiate_with_at_least_one_shelf() throws Exception {
		testSubject = new VendingMachine();
		assertThat(testSubject.isEmpty(VendingMachine.MAX_TRAYS_PER_SHELF - 1),
				is(true));
	}

	@Test
	public void should_instantiate_with_number_of_shelves() throws Exception {
		final int numberOfShelves = 4;
		final int lastTray = (VendingMachine.MAX_TRAYS_PER_SHELF * numberOfShelves) - 1;

		testSubject = new VendingMachine(numberOfShelves);
		assertThat(testSubject.isEmpty(lastTray), is(true));
	}

	@Test
	public void fill_should_fill_up_empty_tray() throws Exception {
		setup_fill_up_FIRST_TRAY();
		assertThat(testSubject.isEmpty(FIRST_TRAY), is(false));
	}

	@Test
	public void fill_should_return_number_of_items_added_to_empty_tray()
			throws Exception {
		int itemsAdded = testSubject.fill(FIRST_TRAY);
		assertThat(itemsAdded, is(VendingMachine.MAX_ITEMS_PER_TRAY));
	}

	@Test
	public void fill_should_return_number_of_items_added_to_partially_empty_tray()
			throws Exception {
		setup_fill_up_FIRST_TRAY();
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
	public void fill_with_specified_quantity_returns_valid_input_as_confirmation()
			throws Exception {
		setup_two_empty_spaces_in_FIRST_TRAY();

		int validInput = 1;

		int confirmation = testSubject.fill(FIRST_TRAY, validInput);

		assertThat(validInput, is(confirmation));
	}

	@Test
	public void fill_with_specified_quantity_returns_0_to_indicate_invalid_input() {
		setup_two_empty_spaces_in_FIRST_TRAY();

		int invalidInput = 4;

		int errorIndicator = testSubject.fill(FIRST_TRAY, invalidInput);

		assertThat(0, is(errorIndicator));
	}

	@Test
	public void dispense_reduces_quantity_in_a_tray_by_1() throws Exception {
		setup_fill_up_FIRST_TRAY();
		testSubject.dispense(FIRST_TRAY);
		
		assertThat(testSubject.getCurrentLevel(FIRST_TRAY), is(VendingMachine.MAX_ITEMS_PER_TRAY - 1));
	}
	
	@Test(expected=java.lang.IllegalStateException.class)
	public void dispense_when_tray_is_empty_should_throw_IllegalStateException() throws Exception {
		testSubject.dispense(FIRST_TRAY);
	}
	
	private void setup_fill_up_FIRST_TRAY() {
		testSubject.fill(FIRST_TRAY);
	}

	private void setup_two_empty_spaces_in_FIRST_TRAY() {
		testSubject.fill(FIRST_TRAY);
		testSubject.dispense(FIRST_TRAY);
		testSubject.dispense(FIRST_TRAY); // have 2 empty spaces
	}

}
