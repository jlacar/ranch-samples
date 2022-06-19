package com.coderanch.livetdd;

import java.math.BigDecimal;
import java.util.function.Predicate;

class Item {

    private final String name;
    private final BigDecimal price;

    Item(String name, String price) {
        this.name = name;
        this.price = new BigDecimal(price);
    }

    String getName() {
        return name;
    }

    BigDecimal getPrice() {
        return price;
    }

    static Predicate<Item> queryOnName(String name) {
        return (Item e) -> e.getName().equals(name);
    }
}
