package data;

public class UoP extends AddCost{

//salary - pensja=kwota netto na fakturze
    //invoice - kwota netto na fakturze


    /*
    ZMIENNE KLASY JOB:
    private double profit;  //dochod
    private double salary;  //pensja
    private double pitFee;  //podatek do zaplaty
    private double employerCost; //koszt pracodawcy
    private double effectiveTax; //procentowe obciazenie kosztu pracodawcy
    private double zusBenefit; //swiadczenie zus
    private double zusFee; //skladka ZUS

    ZMIENNA KLASY ADD_COST
    private double employeeCost;//koszty uzyskania przychodu
     */





    public void UoPBrutto (double salary, double cost){
        private double totalCost;
        private double employeeZus;
        setSalary(salary);
        setEmployeeCost(cost);
        Zus zus = new Zus();
        zus.zusBase(salary);
        employeeZus=zus.getRetireFee()/2+zus.getDisabilityFee()*0.1875+zus.getIllnessFee();
        zus.setHealthyBase(salary-employeeZus);
        totalCost=employeeZus+cost;
        Pit pit = new Pit();
        pit.pitincome(salary,totalCost, zus.getHealthyDeprecation());
        setPitFee(pit.getTax());
        setProfit(pit.getIncome()-zus.getHealthyFee());
        setZusBenefit(getProfit());
        setZusFee(zus.totalFee());
        setEmployerCost(salary+zus.getRetireFee()/2+zus.getAccidentFee()+zus.getDisabilityFee()*0.8125+zus.getJobFound()+zus.getFgspFee());
        setEffectiveTax((getEmployeeCost()-getProfit())/getEmployerCost()*100);

    }


    public void UoPNetto (double profit, double cost, double healthyDeprecation){
        private double totalCost;
        private double employeeZus;
        setProfit(profit);
        setEmployeeCost(cost);
        setZusBenefit(profit);
        Zus zus = new Zus();
        zus.zusBenefit(profit);
        employeeZus=zus.getRetireFee()/2+zus.getDisabilityFee()*0.1875+zus.getIllnessFee();
        totalCost=employeeZus+cost;
        setSalary(1.18*(profit+totalCost));
        zus.setHealthyBase(getSalary()-employeeZus);
        Pit pit = new Pit();
        pit.pitprofit(profit,totalCost,zus.getHealthyDeprecation());
        setPitFee(pit.getTax());
        setZusFee(zus.totalFee());
        setEmployerCost(getSalary()+zus.getRetireFee()/2+zus.getAccidentFee()+zus.getDisabilityFee()*0.8125+zus.getJobFound()+zus.getFgspFee());
        setEffectiveTax((getEmployeeCost()-getProfit())/getEmployerCost()*100);

    }


}
