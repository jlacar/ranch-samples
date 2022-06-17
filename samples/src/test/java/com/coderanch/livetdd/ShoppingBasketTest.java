package com.coderanch.livetdd;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;

@DisplayNameGeneration(ReplaceUnderscores.class)
class ShoppingBasketTest {

    @Nested
    class New_Basket {
        @Test void is_going_to_be_empty() {
            assertThat(new ShoppingBasket().isEmpty()).isTrue();
        }

        @Test void count_is_0_when_its_empty() {
            assertThat(new ShoppingBasket().itemCount("Bread")).isEqualTo(0);
        }

        @Test void not_empty_when_Item_is_put_in_it() {
            ShoppingBasket basket = new ShoppingBasket();
            basket.add(new Item("Cologne"));

            assertThat(basket.isEmpty()).isFalse();
        }

        @Test void count_is_1_when_Item_is_put_in_it() {
            ShoppingBasket basket = new ShoppingBasket();
            basket.add(new Item("Shampoo"));

            assertThat(basket.itemCount("Shampoo")).isEqualTo(1);
        }

        @Test void item_count_matches_quantity_of_single_item_when_added_multiple_times() {
            ShoppingBasket basket = new ShoppingBasket();

            basket.add(new Item("Bread"));
            basket.add(new Item("Milk"));
            basket.add(new Item("Eggs"));

            basket.add(new Item("Milk"));
            basket.add(new Item("Milk"));

            assertThat(basket.itemCount("Milk")).isEqualTo(3);
        }
    }
}
