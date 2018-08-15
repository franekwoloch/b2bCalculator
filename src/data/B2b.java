package data;

public class B2b {

    private double zusBenefit; //swiadczenie zus
    private double invoice; //faktura netto
    private double profit; //dochod
    private double zusFee; //skladka ZUS
    private double pitFee; //podatek do zaplaty
    private double effectiveTax; //procentowe obciazenie kosztu pracodawcy

    //METHODS

    public B2b invoiceB2b(double zusBenefit, double invoice) {
        setZusBenefit(zusBenefit);
        setInvoice(invoice);
        Zus zus = new Zus();
        zus.zusBenefit(getZusBenefit());
        Pit pit = new Pit();
        pit.pitincome(invoice, zus.costFee(), zus.getHealthyDeprecation());
        profit = invoice - zus.totalFee() - pit.getTax();
        setProfit(profit);
        setPitFee(pit.getTax());
        setZusFee(zus.totalFee());
        setEffectiveTax(profit/invoice);
    }


    public B2b profitB2b(double zusBenefit, double profit) {
        private double invoice;
        setZusBenefit(zusBenefit);
        setProfit(profit);
        Zus zus = new Zus();
        zus.zusBenefit(getZusBenefit());
        Pit pit = new Pit();
        pit.pitprofit(profit,zus.costFee(),zus.getHealthyDeprecation());
        invoice=profit+zus.totalFee()+pit.getTax();
        setInvoice(invoice);
        setPitFee(pit.getTax());
        setZusFee(zus.totalFee());
        setEffectiveTax(profit/invoice);
    }


    //GETTERS&SETTERS

    public double getZusBenefit() {
        return zusBenefit;
    }

    public void setZusBenefit(double zusBenefit) {
        this.zusBenefit = zusBenefit;
    }

    public double getInvoice() {
        return invoice;
    }

    public void setInvoice(double invoice) {
        this.invoice = invoice;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getZusFee() {
        return zusFee;
    }

    public void setZusFee(double zusFee) {
        this.zusFee = zusFee;
    }

    public double getPitFee() {
        return pitFee;
    }

    public void setPitFee(double pitFee) {
        this.pitFee = pitFee;
    }

    public double getEffectiveTax() {
        return effectiveTax;
    }

    public void setEffectiveTax(double effectiveTax) {
        this.effectiveTax = effectiveTax;
    }
}
