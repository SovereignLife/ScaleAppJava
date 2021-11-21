package com.company.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Scales {
    private ArrayList<ScalingItem> items;

    public Scales(ArrayList<ScalingItem> items) {
        this.items = items;
    }

    public void scale() {
        System.out.println("Согласно мои расчетам");
        String sortedList = items.stream()
                .sorted(Comparator.comparing(o -> convertWeight(o.getWeight(), o.getUnits())))
                .map(ScalingItem::getName)
                .collect(Collectors.joining(" < "));
        System.out.println(sortedList);
    }

    public Double convertWeight(Double weight, Units units) {
        switch (units) {
            case TON:
                return weight * 1000;
            case GRAM:
                return weight / 1000;
            default:
                return weight;
        }
    }

    public void setItems(ArrayList<ScalingItem> items) {
        this.items = items;
    }

    public ArrayList<ScalingItem> getItems() {
        return items;
    }

}
