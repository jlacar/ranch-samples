package com.coderanch.livetdd;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;

@DisplayNameGeneration(ReplaceUnderscores.class)
final class ItemTest {

    @Nested
    class NewItem {

        @Test void new_Item_has_expected_name() {
            var item = new Item("Bread");

            assertThat(item.name()).isEqualTo("Bread");
        }
    }
}
