package com.company.models;

import java.io.*;
import java.util.EnumSet;
import java.util.Locale;
import java.util.Scanner;

interface IScalingItem {
    String name = "";
    Units units = Units.KILOGRAM;
    Double weight = 0.0;
}


public class ScalingItem implements IScalingItem {
    private String name;
    private Units units;
    private Double weight;
    private final InputStream inputStream = System.in;
    private final Reader inputStreamReader = new InputStreamReader(inputStream);
    private final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

    public ScalingItem() {
        ScalingItem item = getDataFromUser();
        this.name = item.name;
        this.weight = item.weight;
        this.units = item.units;
    }

    public ScalingItem(String name, Double weight, Units units) {
        this.name = name;
        this.weight = weight;
        this.units = units;
    }

    private ScalingItem getDataFromUser() {
        Double weight;
        String name;
        Units units;
        System.out.println("Введите наименование");
        try {
            name = bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("Проблема с чтением имени, будет что-то от меня");
            name = "Что-то от меня";
        }
        System.out.println("Окей, значит " + name);
        System.out.println("Выберите единицы измерения, только из предложенных, сори, не умею делать выбор");
        for (Units unit : EnumSet.allOf(Units.class)) {
            System.out.println(unit);
        }
        try {
            units = Units.valueOf(bufferedReader.readLine().toUpperCase(Locale.ROOT));
        } catch (Exception e) {
            System.out.println("Введеное значение не подходит(скорее всего мой косяк), так что будут килограммы");
            units = Units.KILOGRAM;
        }
        System.out.println("Введите вес");
        try {
            weight = Double.parseDouble(bufferedReader.readLine());
        } catch (Exception e) {
            System.out.println("Похоже это не число, придется попробовать еще раз");
            return getDataFromUser();
        }

        return new ScalingItem(name, weight, units);
    }

    public String getName() {
        return this.name;
    }

    public Units getUnits() {
        return this.units;
    }

    public Double getWeight() {
        return this.weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUnits(Units units) {
        this.units = units;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

}
