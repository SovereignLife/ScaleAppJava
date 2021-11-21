package com.company;

import com.company.models.Scales;
import com.company.models.ScalingItem;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в мои весы");
        ArrayList<ScalingItem> items = ItemCollector.fillItems();
        Scales scales = new Scales(items);
        scales.scale();
    }
}
