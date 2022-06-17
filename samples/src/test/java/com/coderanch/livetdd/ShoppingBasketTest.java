package com.coderanch.livetdd;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;

@DisplayNameGeneration(ReplaceUnderscores.class)
class ShoppingBasketTest {

    ShoppingBasket basket = new ShoppingBasket();

    @Nested class New_Basket {

        @Test void its_total_price_is_zero() {
            assertThat(basket.totalPrice()).isEqualTo(0.0);
        }

        @Test void item_is_not_present() {
            assertThat(basket.getQuantity("Some Item")).isEqualTo(0);
        }
    }

    @Nested class Non_Empty {
        @Test void with_one_item_totalPrice_is_more_than_zero() {
            basket.add("Some Item", 5.00);

            assertThat(basket.totalPrice()).isGreaterThan(0.0);
        }

        @Test void with_one_item_quantity_is_one() {
            basket.add("Some Item", 5.00);

            assertThat(basket.getQuantity("Some Item")).isEqualTo(1);
        }

        @Test void getQuantity_matches_number_of_times_same_item_was_added() {
            int timesAdded = 5;
            addItem("Some Item", timesAdded);

            assertThat(basket.getQuantity("Some Item")).isEqualTo(timesAdded);
        }
    }

    private void addItem(String itemName, int timesAdded) {
        for (int i = 0; i < timesAdded; i++) {
            basket.add(itemName, 5.00);
        }
    }

    @Nested class Free_Items {

    }
}