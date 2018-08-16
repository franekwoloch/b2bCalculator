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
        pit.pitincome(invoice, zus.costFee(), zus.getHealthyDeprecation());
        setProfit(invoice - zus.totalFee() - pit.getTax());
        setPitFee(pit.getTax());
        setZusFee(zus.totalFee());
        setEffectiveTax(getProfit() / invoice);

    }


    public void profitB2b(double zusBenefit, double profit) {
        private double invoice;
        setZusBenefit(zusBenefit);
        setProfit(profit);
        Zus zus = new Zus();
        zus.zusBenefit(getZusBenefit());
        Pit pit = new Pit();
        pit.pitprofit(profit, zus.costFee(), zus.getHealthyDeprecation());
        invoice = profit + zus.totalFee() + pit.getTax();
        setSalary(invoice);
        setPitFee(pit.getTax());
        setZusFee(zus.totalFee());
        setEffectiveTax(profit / invoice);
    }


}
