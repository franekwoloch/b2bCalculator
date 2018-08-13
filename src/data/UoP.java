package data;

public class UoP {

    private double payment; //wynagrodzenie netto
    private double salary; //wynagrodzenie brutto
    private double employerCost; //koszt pracodawcy
    private double employeeCost;//koszt pracownika



    public UoP UoPBrutto (double salary, double cost){
        protected double totalCost;
        protected double employeeZus;
        setSalary(salary);
        setEmployeeCost(cost);
        Zus zus = new Zus(salary);
        employeeZus=zus.getRetireFee()/2+zus.getDisabilityFee()*0.1875+zus.getIllnessFee();
        zus.setHealthyBase(salary-employeeZus);
        totalCost=zus.getHealthyFee()+employeeZus+cost;
        Pit pit = new Pit(salary, totalCost);
        setPayment(pit.getIncome());
        setEmployerCost(salary+zus.getRetireFee()/2+zus.getAccidentFee()+zus.getDisabilityFee()*0.8125+zus.getJobFound()+zus.getFgspFee());

    }


    public UoP UoPNetto (double payment, double cost){
        protected double totalCost;
        protected double employeeZus;
        setSalary(salary);
        setEmployeeCost(cost);
        Zus zus = new Zus(salary);
        employeeZus=zus.getRetireFee()/2+zus.getDisabilityFee()*0.1875+zus.getIllnessFee();
        zus.setHealthyBase(salary-employeeZus);
        totalCost=zus.getHealthyFee()+employeeZus+cost;
        Pit pit = new Pit(salary, totalCost);
        setPayment(pit.getIncome());
        setEmployerCost(salary+zus.getRetireFee()/2+zus.getAccidentFee()+zus.getDisabilityFee()*0.8125+zus.getJobFound()+zus.getFgspFee());

    }







    //SETTERS&GETTERS

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
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
