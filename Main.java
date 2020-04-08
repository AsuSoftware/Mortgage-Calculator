package com.asusoftware;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    static short percent = 100;
    static short monthsInAYear = 12;
    // Money you take from the bank
    static float principal = (float)readNumber("Principal($1k - $1M) : ", 1000, 1_000_000);
    // Annual Interest for the money
    static double annualInterest = (readNumber("Annual Rate : ", 1, 30) / percent) / monthsInAYear;
    // Years that you need to pay
    static byte years = (byte)(readNumber("Period(Years) : ", 1, 30) * monthsInAYear);
    // Money that you need to pay every month
    static double mortgage = calculateMortgage(principal, annualInterest, years);

    public static void main(String[] args) {

            NumberFormat currency = NumberFormat.getCurrencyInstance();
            String result = currency.format(mortgage);
            System.out.println(" ");
            System.out.println("Mortgage");
            System.out.println("----------");
            System.out.println("Monthly Payments : " + result);
            System.out.println(" ");
            System.out.println("Payments Schedule");
            System.out.println("----------------");
            for(short month = 1; month <= years; month++) {
                double paymentSchedule = calculatePayment(principal, annualInterest, years, month);
                String payment = currency.format(paymentSchedule);
                System.out.println(payment);
            }

    }

    public static double readNumber(String prompt, double min, double max){
        Scanner scanner = new Scanner(System.in);
        double value; // Is the user input
        while(true) {
            System.out.print(prompt);
            value = scanner.nextFloat();
            if(value >= min && value <= max)
                break;
            System.out.println("Enter a value between " + min + " and " + max); // else
        }
        return value;
    }

    public static double calculateMortgage(float principal, double annualRate, byte period){
        return principal * ((annualRate * Math.pow((1 + annualRate), period)) / (Math.pow((1 + annualRate), period) - 1));
    }

    public static double calculatePayment(float principal, double annualInterest, byte period, short month){
        return principal * (Math.pow(1 + annualInterest, period) - Math.pow(1 + annualInterest, month))
            /(Math.pow(1 + annualInterest, period) - 1);
    }
}

