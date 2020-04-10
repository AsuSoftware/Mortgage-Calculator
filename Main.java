package com.asusoftware;

public class Main {

    static short percent = 100;
    static short monthsInAYear = 12;
    // Money you take from the bank
    private static float principal = (float) Console.readNumber("Principal($1k - $1M) : ", 1000, 1_000_000);
    // Annual Interest for the money
    private static double annualInterest = (Console.readNumber("Annual Rate : ", 1, 30) / percent) / monthsInAYear;
    // Years that you need to pay
    private static byte years = (byte)(Console.readNumber("Period(Years) : ", 1, 30) * monthsInAYear);
  


    public static void main(String[] args) {
        var calculatorMortgage = new CalculatorMortgage(principal, annualInterest, years);
        var mortgageReport = new MortgageReport(calculatorMortgage);
        mortgageReport.printMortgage();
        mortgageReport.printPaymentsSchedule();
    }

}

