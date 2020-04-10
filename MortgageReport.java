package com.asusoftware;

import java.text.NumberFormat;

public class MortgageReport {

    private CalculatorMortgage calculator;

    public MortgageReport(CalculatorMortgage calculator) {
     this.calculator = calculator;
    }

    public void printMortgage() {
        System.out.println(" ");
        System.out.println("Mortgage");
        System.out.println("----------");
        System.out.println("Monthly Payments : " + NumberFormat.getCurrencyInstance().format(calculator.getMortgage()));
    }


    public void printPaymentsSchedule() {
        System.out.println(" ");
        System.out.println("Payments Schedule");
        System.out.println("----------------");
        for(short month = 1; month <= calculator.getYears(); month++) {
            System.out.println(NumberFormat.getCurrencyInstance().format(calculator.getPayment(month)));
        }
    }
}
