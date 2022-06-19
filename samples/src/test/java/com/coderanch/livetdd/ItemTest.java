package com.coderanch.livetdd;

import org.assertj.core.api.BigDecimalAssert;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void name_and_price_are_immutable() {
        var item = new Item("Foo", "5.00");

        assertThat(item.getName())
                .as("name is immutable, no setter")
                .isEqualTo("Foo");

        assertThat(item.getPrice())
                .as("price is immutable, no setter")
                .isEqualTo(new BigDecimal("5.00"));
    }
}