package data;

public class UoP {



    private double salary; //wynagrodzenie brutto
    private double employerCost; //koszt pracodawcy
    private double employeeCost;//koszt pracownika
    private double profit;


    public UoP UoPBrutto (double salary, double cost){
        protected double totalCost;
        protected double employeeZus;
        setSalary(salary);
        setEmployeeCost(cost);
        Zus zus = new Zus();
        zus.zusBase(salary);
        employeeZus=zus.getRetireFee()/2+zus.getDisabilityFee()*0.1875+zus.getIllnessFee();
        zus.setHealthyBase(salary-employeeZus);
        totalCost=employeeZus+cost;
        Pit pit = new Pit();
        pit.pitincome(salary,totalCost, zus.getHealthyDeprecation());
        setProfit(pit.getIncome()-zus.getHealthyFee());
        setEmployerCost(salary+zus.getRetireFee()/2+zus.getAccidentFee()+zus.getDisabilityFee()*0.8125+zus.getJobFound()+zus.getFgspFee());

    }


    public UoP UoPNetto (double profit, double cost, double healthyDeprecation){
        protected double totalCost;
        protected double employeeZus;
        setProfit(profit);
        Zus zus = new Zus();
        zus.zusBenefit(profit);
        employeeZus=zus.getRetireFee()/2+zus.getDisabilityFee()*0.1875+zus.getIllnessFee();
        totalCost=employeeZus+cost;
        Pit pit = new Pit();
        zus.setHealthyBase(profit);
        pit.pitprofit(profit,totalCost,zus.getHealthyDeprecation());
        setSalary(profit+employeeZus+pit.getTax());
        setEmployerCost(getSalary()+zus.getRetireFee()/2+zus.getAccidentFee()+zus.getDisabilityFee()*0.8125+zus.getJobFound()+zus.getFgspFee());

    }




    //SETTERS&GETTERS

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

    public double getEmployerCost() {
        return employerCost;
    }

    public void setEmployerCost(double employerCost) {
        this.employerCost = employerCost;
    }


    public double getEmployeeCost() {
        return employeeCost;
    }

    public void setEmployeeCost(double employeeCosy) {
        this.employeeCost = employeeCosy;
    }


}
