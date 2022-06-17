package com.coderanch.livetdd;

import java.util.ArrayList;
import java.util.List;

public class ShoppingBasket {

    List<Item> items = new ArrayList<>();

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void add(Item item) {
        items.add(item);
    }

    public int itemCount(String name) {
      return (int) items.stream().filter(e -> e.name().equals(name)).count();
    }
}
