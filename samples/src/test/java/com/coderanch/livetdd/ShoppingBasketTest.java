package com.coderanch.livetdd;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;

@DisplayNameGeneration(ReplaceUnderscores.class)
class ShoppingBasketTest {

    private ShoppingBasket basket = new ShoppingBasket();

    @Nested
    class Basic_Behaviors {
        @Test
        void check_if_it_contains_any_items_using_method_isEmpty() {
            assertTrue(new ShoppingBasket().isEmpty());
        }

        @Test
        void put_items_in_it_using_method_add() {
            basket.add(new Item("Dummy", "1.00"));

            assertFalse(basket.isEmpty());
        }
    }

    @Nested
    class Querying_for_quantity {
        private static final Item BALL = new Item("Ball", "9.99");
        private static final Predicate<Item> OF_BALL = Item.queryOnName(BALL.getName());

        private static final Item SPONGE = new Item("Sponge", "1.98");
        private static final Predicate<Item> OF_SPONGE = Item.queryOnName(SPONGE.getName());

        @Test
        void check_quantity_of_specific_item_in_it_using_method_howMany() {
            basket.add(BALL);
            basket.add(BALL);

            assertThat(basket.howMany(OF_BALL))
                    .as("Ball added twice")
                    .isEqualTo(2);

            assertThat(basket.howMany(OF_SPONGE))
                    .as("Sponge was not added")
                    .isEqualTo(0);
        }
    }
}