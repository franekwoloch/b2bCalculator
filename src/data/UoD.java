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


     public void UoDSalary (double salary, double cost){
        setSalary(salary);
        setEmployeeCost(cost);
        setEmployerCost(salary);
        setZusBenefit(0);
        setZusFee(0);
        setProfit(cost+0.82*(salary-cost));
        setPitFee(getSalary()-getProfit());
        setEffectiveTax((getSalary()-getProfit())/getSalary()*100);
    }


    public void UoDProfit (double profit, double cost){
        setProfit(profit);
        setEmployeeCost(cost);
        setZusBenefit(0);
        setZusFee(0);
        setSalary(cost+1.18*profit);
        setEmployerCost(getSalary());
        setPitFee(getSalary()-getProfit());
        setEffectiveTax((getSalary()-getProfit())/getSalary()*100);

    }


}
