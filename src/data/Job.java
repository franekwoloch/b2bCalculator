package data;

import utils.CalculationsUtils;

import java.io.Serializable;

public class Job implements Serializable {
    public final static double TAX=0.17; //w procentach

    private double profit;  //dochod
    private double salary;  //pensja
    private double pitFee;  //podatek do zaplaty
    private double employerCost; //koszt pracodawcy
    private double effectiveTax; //procentowe obciazenie kosztu pracodawcy
    private double zusBenefit; //swiadczenie zus
    private double zusFee; //skladka ZUS

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = CalculationsUtils.round(profit,2);

    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = CalculationsUtils.round(salary,2);
    }

    public double getPitFee() {
        return pitFee;
    }

    public void setPitFee(double pitFee) {
        this.pitFee = CalculationsUtils.round(pitFee,2);
    }

    public double getEmployerCost() {
        return employerCost;
    }

    public void setEmployerCost(double employerCost) {
        this.employerCost = CalculationsUtils.round(employerCost,2);
    }

    public double getEffectiveTax() {
        return effectiveTax;
    }

    public void setEffectiveTax(double effectiveTax) {
        this.effectiveTax = CalculationsUtils.round(effectiveTax,2);
    }

    public double getZusBenefit() {
        return zusBenefit;
    }

    public void setZusBenefit(double zusBenefit) {
        this.zusBenefit = CalculationsUtils.round(zusBenefit,2);
    }

    public double getZusFee() {
        return zusFee;
    }

    public void setZusFee(double zusFee) {
        this.zusFee = CalculationsUtils.round(zusFee,2);
    }



}
