package data;

import utils.CalculationsUtils;

public class AddCost extends Job {
    private double employeeCost;//koszty uzyskania przychodu


    public double getEmployeeCost() {
        return employeeCost;
    }

    public void setEmployeeCost(double employeeCost) {
        this.employeeCost = CalculationsUtils.round(employeeCost,2);
    }

}
