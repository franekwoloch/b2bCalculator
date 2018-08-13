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
    public static double healthyDeprecation=0.075*getHealthyBase(); //Pomniejszenie PIT



    //CONSTRUCOR

      public Zus (double benefit){
        setBenefit(benefit);
        setBase(1.413271752*benefit);
        setHealthyFee(0.09*getHealthyBase());
    }


//METHODS

    public double costFee() {
        setRetireFee(0.1952 * getBase()); //Składka emerytalna 19.52%
        setDisabilityFee(0.08*getBase()); //Składka rentowa 8%;
        setIllnessFee(0.0245*getBase()); //Składka chorobowa 2.45%
        setAccidentFee(0.018*getBase());//składka wypadkowa 1.8%
        setCostFee(getRetireFee()+getDisabilityFee()+getIllnessFee()+getAccidentFee()); //Składka stanowiąca koszt
        return getCostFee();
    }

    public double totalFee() {
        setJobFound(0.0245*getBase()); //Fundusz pracy 2.45%
        setTotalFee(getHealthyFee()+getCostFee()+getJobFound()); //Łączna suma składek
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

}
