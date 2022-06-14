package com.coderanch.livetdd;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.*;

@DisplayNameGeneration(ReplaceUnderscores.class)
class ShoppingBasketTest {

    @Nested class zero {
        @Test void nothing_in_cart() {
            assertThat(1).isEqualTo(0);
        }
    }
}