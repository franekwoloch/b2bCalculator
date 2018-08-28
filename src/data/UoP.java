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


    public void UoPBrutto (double salary, Cost cost1, Cost cost2){
        double totalCost;
        double employeeZus;
        setSalary(salary);
        Zus zus = new Zus();
        zus.zusBase(salary);
        employeeZus=zus.getRetireFee()/2+zus.getDisabilityFee()*0.1875+zus.getIllnessFee();
        zus.setHealthyBase(salary-employeeZus);
        CostCalculator calcCost=new CostCalculator(cost1,cost2);
        calcCost.calculateCost((salary-employeeZus));
        setEmployeeCost(calcCost.getTotalCost());
        totalCost=employeeZus+calcCost.getTotalCost();
        Pit pit = new Pit();
        pit.pitincome(salary,totalCost, zus.getHealthyDeprecation());
        setPitFee(pit.getTax());
        setProfit(getSalary()-employeeZus-zus.getHealthyFee()-getPitFee());
        setZusFee(zus.getTotalFee());
        setEmployerCost(salary+zus.getRetireFee()/2+zus.getAccidentFee()+zus.getDisabilityFee()*0.8125+zus.getJobFound()+zus.getFgspFee());
        setEffectiveTax((getEmployeeCost()-getProfit())/getEmployerCost()*100);

    }


    public void UoPNetto (double profit, Cost cost1, Cost cost2){
        double totalCost;
        double employeeZus;
        setProfit(profit);
        setZusBenefit(profit);
        Zus zus = new Zus();
        zus.zusBenefit(profit);
        employeeZus=zus.getRetireFee()/2+zus.getDisabilityFee()*0.1875+zus.getIllnessFee();
        CostCalculator calcCost=new CostCalculator(cost1,cost2);
        calcCost.calculateCost((profit*1.18+employeeZus));//do poprawy
        setEmployeeCost(calcCost.getTotalCost());
        totalCost=employeeZus+calcCost.getTotalCost();
        setSalary(1.18*(profit+totalCost)); //do zweryfikowania
        zus.setHealthyBase(getSalary()-employeeZus);
        Pit pit = new Pit();
        pit.pitprofit(profit,totalCost,zus.getHealthyDeprecation());
        setPitFee(pit.getTax());
        setZusFee(zus.getTotalFee());
        setEmployerCost(getSalary()+zus.getRetireFee()/2+zus.getAccidentFee()+zus.getDisabilityFee()*0.8125+zus.getJobFound()+zus.getFgspFee());
        setEffectiveTax((getEmployeeCost()-getProfit())/getEmployerCost()*100);

    }

    public void AlterUoPNetto(double profit, Cost cost1, Cost cost2){
        double tempSalary;
        double tempProfit;
        tempSalary=1.4*profit;
        do{UoPBrutto(tempSalary, cost1,cost2);
            tempProfit=getProfit();
            tempSalary=tempSalary+1.4*(profit-tempProfit);

        } while ((Math.abs(tempProfit-profit))<=0.02);
    }


}
