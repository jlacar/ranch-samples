package com.coderanch.samples.design.vend;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

import org.junit.Test;

public class VendingMachineTest {

	@Test
	public void should_instantiate_with_empty_trays() {
		VendingMachine testSubject = new VendingMachine();
		assertThat(testSubject.isEmpty(0), is(true)); 
	}
}
