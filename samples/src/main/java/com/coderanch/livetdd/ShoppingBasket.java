package com.coderanch.livetdd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingBasket {
    double price;
    List<String> items = new ArrayList<>();

    public double totalPrice() {
        return price;
    }

    public long getQuantity(String someItem) {
        return items.stream().filter(e -> e.equals(someItem)).count();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void add(String item, double unitPrice) {
        price = unitPrice;
        items.add(item);
    }
}
