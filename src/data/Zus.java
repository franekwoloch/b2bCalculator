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
    public static final double healthyDeprecation=275.51; //Pomniejszenie PIT

    //CONSTRUCOR

    public Zus (double benefit){
        setBenefit(benefit);
        base=1.413271752*benefit;
    }

    //SETTER&GETTERS:
    public double getBenefit() {
        return benefit;
    }

    public void setBenefit(double benefit) {
        this.benefit = benefit;
    }

    public double costFee() {
        healthyFee = 319.94;
        retireFee = 0.1952 * base; //Składka emerytalna 19.52%
        disabilityFee=0.08*base; //Składka rentowa 8%;
        illnessFee=0.0245*base; //Składka chorobowa 2.45%
        accidentFee=0.018*base;//składka wypadkowa 1.8%
        costFee=retireFee+disabilityFee+illnessFee+accidentFee; //Składka stanowiąca koszt
        return costFee;
    }

    public double totalFee() {
        jobFound=0.0245*base; //Fundusz pracy 2.45%
        totalFee=healthyFee+costFee+jobFound; //Łączna suma składek
        return totalFee;
    }

}
