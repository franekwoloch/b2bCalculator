package data;

public class B2b extends Job {


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
     */

    //METHODS

    public void invoiceB2b(double zusBenefit, double invoice) {
        setZusBenefit(zusBenefit);
        setSalary(invoice);
        Zus zus = new Zus();
        zus.zusBenefit(getZusBenefit());
        Pit pit = new Pit();
        pit.pitincome(invoice, zus.getCostFee(), zus.getHealthyDeprecation());
        setProfit(invoice - zus.getTotalFee() - pit.getTax());
        setPitFee(pit.getTax());
        setZusFee(zus.getTotalFee());
        setEffectiveTax((invoice-getProfit())/invoice*100);
        setEmployerCost(invoice);

    }


    public void profitB2b(double zusBenefit, double profit) {
        double invoice;
        setZusBenefit(zusBenefit);
        setProfit(profit);
        Zus zus = new Zus();
        zus.zusBenefit(getZusBenefit());
        Pit pit = new Pit();
        pit.pitprofit(profit, zus.getCostFee(), zus.getHealthyDeprecation());
        invoice = profit + zus.getTotalFee() + pit.getTax();
        setSalary(invoice);
        setPitFee(pit.getTax());
        setZusFee(zus.getTotalFee());
        setEffectiveTax((invoice-getProfit())/invoice*100);
        setEmployerCost(getSalary());
    }


}
