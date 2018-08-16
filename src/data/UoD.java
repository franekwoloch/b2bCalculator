package data;

public class UoD {
    private double salary; //wynagrodzenie brutto
    private double profit; //wynagrodzenie netto
    private double cost;

    public void UoDSalary (double salary, double cost){
        setSalary(salary);
        setCost(cost);
        setProfit(cost+0.82*(salary-cost));
    }


    public void UoDProfit (double profit, double cost){
        setProfit(profit);
        setCost(cost);
        setSalary(cost+1.18*profit);
    }






    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
