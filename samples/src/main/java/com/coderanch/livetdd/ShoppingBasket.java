package com.coderanch.livetdd;

/*
    Marking start of solo exercise: 8:13pm 18 Jun 22
 */

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ShoppingBasket {
    private List<Item> contents = new ArrayList<>();

    public void add(Item item) {
        contents.add(item);
    }

    public long getCount(Predicate itemQuery) {
        return contents.stream().filter(itemQuery).count();
    }

    public boolean isEmpty() {
        return contents.isEmpty();
    }
}
