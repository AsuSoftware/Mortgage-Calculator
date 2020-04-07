package com.asusoftware;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // Principal

            float principal = 0;
            double annualRate = 0;

            while(true) {
                System.out.print("Principal ($1k - $1M) : ");
                principal = Float.parseFloat(scanner.nextLine().trim());

                if (principal >= 1000 && principal <= 1_000_000) {
                    break;
                } else {
                    System.out.println("Enter a number between 1,000 and 1,000,000");
                    continue;
                }
            }

            while(true) {

                System.out.print("Annual interest rate : ");
                annualRate = Double.parseDouble(scanner.nextLine().trim());

                if (annualRate > 0 && annualRate <= 30) {
                    annualRate = (annualRate / 100) / 12;
                    break;
                } else {
                    System.out.println("Enter a value greater than 0 and less than or equal 30.");
                    continue;
                }
            }

            while (true) {

                // Period
                System.out.print("Period (Years) : ");
                double period = Double.parseDouble(scanner.nextLine().trim());
                if(period >= 1 && period <= 30) {

                    period *= 12;
                    // Total
                    double total = principal * ((annualRate * Math.pow((1 + annualRate), period)) / (Math.pow((1 + annualRate), period) - 1));

                    NumberFormat currency = NumberFormat.getCurrencyInstance();
                    String result = currency.format(total);
                    System.out.println("Mortgage : " + result);
                    break;

                } else {
                    System.out.println("Enter a value between 1 and 30.");
                    continue;
                }
            }

    }
}
