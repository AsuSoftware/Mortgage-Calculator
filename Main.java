package com.asusoftware;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // Principal
        System.out.println("Principal : ");
        String principalFromUser =  scanner.nextLine().trim();
        double principal = Double.parseDouble(principalFromUser);

        // Annual rate
        System.out.println("Annual interest rate : ");
        String annualRateFromUser = scanner.nextLine().trim();
        double annualRate = (Double.parseDouble(annualRateFromUser) / 100) / 12;

        // Period
        System.out.println("Period (Years) : ");
        String periodFromUser = scanner.nextLine().trim();
        double period = Double.parseDouble(periodFromUser) * 12;

        // Total
        double total = principal * ((annualRate * Math.pow((1 + annualRate), period)) / (Math.pow((1 + annualRate), period) - 1));

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String result = currency.format(total);
        System.out.println("Mortgage : " + result);
    }
}
