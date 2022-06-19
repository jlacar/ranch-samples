package com.coderanch.livetdd;

import java.math.BigDecimal;

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
}
