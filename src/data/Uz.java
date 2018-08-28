package data;

public class Uz extends AddCost {


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
    private boolean studentStatus;


    public void UzBrutto (double salary, Cost cost){
        double totalCost;
        double employeeZus;
        setSalary(salary);
        Zus zus = new Zus();
        if (isStudentStatus()){
            zus.zusBase(salary);
        }
        else zus.zusBase(salary) ;
        employeeZus=zus.getRetireFee()/2+zus.getDisabilityFee()*0.1875+zus.getIllnessFee();
        zus.setHealthyBase(salary-employeeZus);
        CostCalculator calcCost=new CostCalculator(cost,Cost.NO);
        calcCost.calculateCost(salary);
        setEmployeeCost(calcCost.getTotalCost());
        totalCost=employeeZus+getEmployeeCost();
        Pit pit = new Pit();
        pit.pitincome(salary,totalCost, zus.getHealthyDeprecation());
        setPitFee(pit.getTax());
        setProfit(pit.getIncome()-zus.getHealthyFee());
        setZusBenefit(getProfit());
        setEmployerCost(salary+zus.getRetireFee()/2+zus.getAccidentFee()+zus.getDisabilityFee()*0.8125+zus.getJobFound()+zus.getFgspFee());
        setEffectiveTax((getEmployeeCost()-getProfit())/getEmployerCost()*100);
        setZusFee(zus.getTotalFee());

    }

    public void UzNetto (double profit, Cost cost){
        double totalCost;
        double employeeZus;
        setProfit(profit);
        Zus zus = new Zus();
        if (isStudentStatus()){
            zus.zusBenefit(0);
        }
        else zus.zusBenefit(profit);
        employeeZus=zus.getRetireFee()/2+zus.getDisabilityFee()*0.1875+zus.getIllnessFee();
        CostCalculator calcCost=new CostCalculator(cost,Cost.NO);
        calcCost.calculateCost((profit*1.18+employeeZus));//do poprawy
        setEmployeeCost(calcCost.getTotalCost());
        totalCost=employeeZus+getEmployeeCost();
        setSalary(1.18*(profit+totalCost));
        zus.setHealthyBase(getSalary()-employeeZus);
        Pit pit = new Pit();
        pit.pitprofit(profit,totalCost,zus.getHealthyDeprecation());
        setPitFee(pit.getTax());
        setZusFee(zus.getTotalFee());
        setEmployerCost(getSalary()+zus.getRetireFee()/2+zus.getAccidentFee()+zus.getDisabilityFee()*0.8125+zus.getJobFound()+zus.getFgspFee());
        setEffectiveTax((getEmployeeCost()-getProfit())/getEmployerCost()*100);
        setZusFee(zus.getTotalFee());
    }

    public boolean isStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(boolean studentStatus) {
        this.studentStatus = studentStatus;
    }


}
