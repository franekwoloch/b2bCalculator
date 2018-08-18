package data;

public class CostCalculator {
    Cost cost1;
    Cost cost2;
    double pitBase;
    double totalCost;



    public CostCalculator(Cost cost1, Cost cost2, double pitBase){
    setCost1(cost1);
    setCost2(cost2);
    setPitBase(pitBase);
    }

    public double calculateCost(){
        private double factor1=0;
        private double factor2=0;

        if getCost1()==Cost.LOCAL{
            factor1=111.25;
        }

        if getCost2()==Cost.ARRIVAL{
            factor1=139.06;
        }

        if getCost2()==Cost.AUTHOR{
            factor2=0.5*getPitBase()
        }

        if getCost2()==Cost.NORMAL{
            factor2=0.2*getPitBase()
        }

        if getCost1()==Cost.NO{
            factor1=0;
        }

        if getCost2()==Cost.NO{
            factor2=0;
        }


        setTotalCost(factor1+factor2);
    }

    //GETTERS&SETTERS
    public Cost getCost1() {
        return cost1;
    }

    public void setCost1(Cost cost1) {
        this.cost1 = cost1;
    }

    public Cost getCost2() {
        return cost2;
    }

    public void setCost2(Cost cost2) {
        this.cost2 = cost2;
    }

    public double getPitBase() {
        return pitBase;
    }

    public void setPitBase(double pitBase) {
        this.pitBase = pitBase;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

}