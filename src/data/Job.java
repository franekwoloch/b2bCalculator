package data;

public class Job {

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
        this.profit = profit;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getPitFee() {
        return pitFee;
    }

    public void setPitFee(double pitFee) {
        this.pitFee = pitFee;
    }

    public double getEmployerCost() {
        return employerCost;
    }

    public void setEmployerCost(double employerCost) {
        this.employerCost = employerCost;
    }

    public double getEffectiveTax() {
        return effectiveTax;
    }

    public void setEffectiveTax(double effectiveTax) {
        this.effectiveTax = effectiveTax;
    }

    public double getZusBenefit() {
        return zusBenefit;
    }

    public void setZusBenefit(double zusBenefit) {
        this.zusBenefit = zusBenefit;
    }

    public double getZusFee() {
        return zusFee;
    }

    public void setZusFee(double zusFee) {
        this.zusFee = zusFee;
    }



}
