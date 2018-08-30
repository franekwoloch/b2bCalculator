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
        setEffectiveTax((getEmployerCost()-getProfit())/getEmployerCost()*100);

    }

    public void UoPNetto(double profit, Cost cost1, Cost cost2){
        double tempSalary;
        double tempProfit;
        double difference;
        tempSalary=profit*1.4;
        do{UoPBrutto(tempSalary, cost1,cost2);
            tempProfit=getProfit();
            difference=profit-tempProfit;
            tempSalary=tempSalary+difference;

        } while ((Math.abs(difference)>0.001));
    }


}
