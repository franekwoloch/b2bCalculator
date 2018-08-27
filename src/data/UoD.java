package data;

public class UoD extends AddCost {



    /*
    ZMIENNE KLASY JOB:
    private double profit;  //dochod --> wartosc netto
    private double salary;  //pensja --> wartosc brutto
    private double pitFee;  //podatek do zaplaty
    private double employerCost; //koszt pracodawcy
    private double effectiveTax; //procentowe obciazenie kosztu pracodawcy
    private double zusBenefit; //swiadczenie zus
    private double zusFee; //skladka ZUS

    ZMIENNA KLASY ADD_COST
    private double employeeCost;//koszty uzyskania przychodu

     */


     public void UoDSalary (double salary, Cost cost){
        setSalary(salary);
        CostCalculator calcCost=new CostCalculator(cost,null);
        calcCost.calculateCost(salary);
        setEmployeeCost(calcCost.getTotalCost());
        setEmployerCost(salary);
        setZusBenefit(0);
        setZusFee(0);
        setProfit(getEmployeeCost()+0.82*(salary-getEmployeeCost()));
        setPitFee(getSalary()-getProfit());
        setEffectiveTax((getSalary()-getProfit())/getSalary()*100);
    }


    public void UoDProfit (double profit, Cost cost){
        setProfit(profit);
        CostCalculator calcCost=new CostCalculator(cost,null,0);
        calcCost.nettoUccCost(profit);
        setEmployeeCost(calcCost.getTotalCost());
        setZusBenefit(0);
        setZusFee(0);
        setSalary(getEmployeeCost()+1.18*profit);
        setEmployerCost(getSalary());
        setPitFee(getSalary()-getProfit());
        setEffectiveTax((getSalary()-getProfit())/getSalary()*100);

    }


}
