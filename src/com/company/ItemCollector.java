package com.company;

import com.company.exceptions.InsufficientAmountOfItemsException;
import com.company.models.ScalingItem;

import java.io.InputStream;
import java.io.BufferedReader;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class ItemCollector {
    private static int amount;
    private static final ArrayList<ScalingItem> items = new ArrayList<>();
    private static final InputStream inputStream = System.in;
    private static final Reader inputStreamReader = new InputStreamReader(inputStream);
    private static final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

    public static ArrayList<ScalingItem> fillItems() {
        System.out.println("Сколько предметов будем сравнивать?");
        String sAmount;

        try {
            sAmount = bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("Что-то пошло не так");
            return fillItems();
        }

        try {
            amount = Integer.parseInt(sAmount);
        } catch (NumberFormatException e) {
            System.out.println("Это было не число, давай еще раз");
            return fillItems();
        }

        try {
            if (amount < 2) throw new InsufficientAmountOfItemsException("Ну не, это слишком мало, надо побольше");
        } catch (InsufficientAmountOfItemsException e) {
            System.out.println(e.getMessage());
            return fillItems();
        }

        for (int i = 0; i < amount; i++) {
            items.add(new ScalingItem());
        }

        return items;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public ArrayList<ScalingItem> getItems() {
        return items;
    }


}
