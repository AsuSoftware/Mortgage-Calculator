package com.asusoftware;

public class CalculatorMortgage {

    private final float principal; // E un field che non cambia mai(costante(final))
    private final double annualRate;
    private final byte period;


    public CalculatorMortgage(float principal, double annualRate, byte period) {
        this.principal = principal;
        this.annualRate = annualRate;
        this.period = period;
    }

    private double calculateMortgage(){
        return principal * ((annualRate * Math.pow((1 + annualRate), period)) / (Math.pow((1 + annualRate), period) - 1));
    }


    private double calculatePayment(float principal, double annualInterest, byte period, short month){
        return principal * (Math.pow(1 + annualInterest, period) - Math.pow(1 + annualInterest, month))
                /(Math.pow(1 + annualInterest, period) - 1);
    }

    public double getMortgage() {
        return calculateMortgage();
    }

    public double getPayment(short months) {
        return calculatePayment(principal, annualRate, period, months);
    }

    public short getYears() {
        return period;
    }
}
