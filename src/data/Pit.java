package data;

public class Pit {
    private double income; //dochód - kwota netto na fakturze
    private double cost; //koszty
    private double tax; //podatek do zapłaty


    //CONSTRUCTOR

    public Pit (double income, double cost){
        setIncome(income);
        setCost(cost);
    }

    //METHODS

    public double payPit(){
        tax=0.18*(income-cost)-Zus.healthyDeprecation;
        return tax;
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


}
