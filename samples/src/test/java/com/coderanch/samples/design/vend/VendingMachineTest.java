package com.coderanch.samples.design.vend;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

import org.junit.Test;

public class VendingMachineTest {

	@Test
	public void should_be_able_to_add_items_to_sell() {
		VendingMachine testSubject = new VendingMachine();
		boolean added = testSubject.add("Slot1", "M&Ms", 5);
		assertThat(added, is(true)); 
	}

}
