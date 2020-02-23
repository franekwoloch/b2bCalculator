package data;

public class Pit {
    private double income; //dochód - kwota netto na fakturze
    private double cost; //koszty
    private double tax; //podatek do zapłaty
    private double profit; //dochod 'do reki'

    //CONSTRUCTOR


    //METHODS
    public void pitincome (double income, double cost, double healthyDeprecation ){
        double tax;
        double profit;
        setIncome(income);
        setCost(cost);
        tax=Job.TAX*(income-cost)-healthyDeprecation-46.33 ;
        setTax(tax);
        profit=income-cost-tax-healthyDeprecation*1.2;
        setProfit(profit);

    }

    public void pitprofit(double profit, double cost, double healthyDeprecation){
        double tax;
        double income;
        setProfit(profit);
        setCost(cost);
        income=profit/(1-Job.TAX)+cost+0.2*healthyDeprecation;
        tax=income-cost-profit-healthyDeprecation-46.33;
        setTax(tax);
        setIncome(income);
    }


    //SETTERS&GETTERS

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

}
