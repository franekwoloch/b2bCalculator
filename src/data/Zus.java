package data;

public class Zus {

    private double benefit;
    private double base;
    private double healthyFee;
    private double retireFee;
    private double disabilityFee;
    private double illnessFee;
    private double accidentFee;
    private double jobFound;
    private double costFee;
    private double totalFee;
    private double healthyBase=3554.93;
    private double fgspFee;
    public double healthyDeprecation=0.075*getHealthyBase(); //Pomniejszenie PIT



    //CONSTRUCOR

      public void zusBenefit (double benefit){
        setBenefit(benefit);
        setBase(1.413271752*benefit);
        setHealthyFee(0.09*getHealthyBase());
        setRetireFee(0.1952 * getBase()); //Składka emerytalna 19.52%
        setDisabilityFee(0.08*getBase()); //Składka rentowa 8%;
        setIllnessFee(0.0245*getBase()); //Składka chorobowa 2.45%
        setAccidentFee(0.018*getBase());//składka wypadkowa 1.8%
        setJobFound(0.0245*getBase()); //Fundusz pracy 2.45%
        setFgspFee(0.001*getBase());
    }

    public void zusBase (double base){
        setBenefit(0.707578*base);
        setBase(base);
        setHealthyFee(0.09*getHealthyBase());
        setRetireFee(0.1952 * getBase()); //Składka emerytalna 19.52%
        setDisabilityFee(0.08*getBase()); //Składka rentowa 8%;
        setIllnessFee(0.0245*getBase()); //Składka chorobowa 2.45%
        setAccidentFee(0.018*getBase());//składka wypadkowa 1.8%
        setJobFound(0.0245*getBase()); //Fundusz pracy 2.45%
        setFgspFee(0.001*getBase());
    }


//METHODS

    public double costFee() {

        setCostFee(getRetireFee()+getDisabilityFee()+getIllnessFee()+getAccidentFee()); //Składka stanowiąca koszt
        return getCostFee();
    }

    public double totalFee() {
        setTotalFee(getHealthyFee()+getCostFee()+getJobFound()+getFgspFee()); //Łączna suma składek
        return getTotalFee();
    }



    //SETTER&GETTERS:

    public double getBenefit() {
        return benefit;
    }

    public void setBenefit(double benefit) {
        this.benefit = benefit;
    }


    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHealthyFee() {
        return healthyFee;
    }

    public void setHealthyFee(double healthyFee) {
        this.healthyFee = healthyFee;
    }

    public double getRetireFee() {
        return retireFee;
    }

    public void setRetireFee(double retireFee) {
        this.retireFee = retireFee;
    }

    public double getDisabilityFee() {
        return disabilityFee;
    }

    public void setDisabilityFee(double disabilityFee) {
        this.disabilityFee = disabilityFee;
    }

    public double getIllnessFee() {
        return illnessFee;
    }

    public void setIllnessFee(double illnessFee) {
        this.illnessFee = illnessFee;
    }

    public double getAccidentFee() {
        return accidentFee;
    }

    public void setAccidentFee(double accidentFee) {
        this.accidentFee = accidentFee;
    }

    public double getJobFound() {
        return jobFound;
    }

    public void setJobFound(double jobFound) {
        this.jobFound = jobFound;
    }

    public double getCostFee() {
        return costFee;
    }

    public void setCostFee(double costFee) {
        this.costFee = costFee;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }

    public double getHealthyBase() {
        return healthyBase;
    }

    public void setHealthyBase(double healthyBase) {
        this.healthyBase = healthyBase;
    }

    public double getFgspFee() {
        return fgspFee;
    }

    public void setFgspFee(double fgspFee) {
        this.fgspFee = fgspFee;
    }

    public double getHealthyDeprecation() {
        return healthyDeprecation;
    }

    public void setHealthyDeprecation(double healthyDeprecation) {
        this.healthyDeprecation = healthyDeprecation;
    }
}
