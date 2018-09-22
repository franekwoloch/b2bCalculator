package utils;

import data.*;

public class Compare {
    public static void compareNetto(double netto){
        B2b b2b=new B2b();
        b2b.profitB2b(netto, netto);
        UoP uop =new UoP();
        uop.UoPNetto(netto, Cost.LOCAL, Cost.NO);
        Uz uz=new Uz();
        uz.setStudentStatus(false);
        uz.UzNetto(netto, Cost.NORMAL);
        UoD uod=new UoD();
        uod.UoDProfit(netto, Cost.NORMAL);
        System.out.println("Zarabiajac: "+netto+"zl do 'reki':");
        System.out.println("Koszty pracodawcy wyniosa:");
        System.out.println("Umowa firma-firma:"+b2b.getEmployerCost()+"zl");
        System.out.println("Umowa o prace:"+uop.getEmployerCost()+"zl");
        System.out.println("Umowa zlecenie:"+uz.getEmployerCost()+"zl");
        System.out.println("Umowa o dzielo:"+uod.getEmployerCost()+"zl");
        System.out.println();
        System.out.println("Efektywne opodatkowanie:");
        System.out.println("Umowa firma-firma:"+b2b.getEffectiveTax()+"%");
        System.out.println("Umowa o prace:"+uop.getEffectiveTax()+"%");
        System.out.println("Umowa zlecenie:"+uz.getEffectiveTax()+"%");
        System.out.println("Umowa o dzielo:"+uod.getEffectiveTax()+"&");
        System.out.println("- - - - - -");
        System.out.println("Przyjete zalozenia:");
        System.out.println("Praca w miejscu zamieszkania, brak autorskich kosztow uzyskania przychodu, swiadczenie ZUS w wysokosci faktury (b2b)");
        }

    public static void compareBrutto(double brutto){
        B2b b2b=new B2b();
        b2b.invoiceB2b(brutto, brutto);
        UoP uop =new UoP();
        uop.UoPBrutto(brutto, Cost.LOCAL, Cost.NO);
        Uz uz=new Uz();
        uz.setStudentStatus(false);
        uz.UzBrutto(brutto, Cost.NORMAL);
        UoD uod=new UoD();
        uod.UoDSalary(brutto, Cost.NORMAL);
        System.out.println("Zarabiajac: "+brutto+"zl do 'reki':");
        System.out.println("Koszty pracodawcy wyniosa:");
        System.out.println("Umowa firma-firma:"+b2b.getEmployerCost()+"zl");
        System.out.println("Umowa o prace:"+uop.getEmployerCost()+"zl");
        System.out.println("Umowa zlecenie:"+uz.getEmployerCost()+"zl");
        System.out.println("Umowa o dzielo:"+uod.getEmployerCost()+"zl");
        System.out.println();
        System.out.println("Efektywne opodatkowanie:");
        System.out.println("Umowa firma-firma:"+b2b.getEffectiveTax()+"%");
        System.out.println("Umowa o prace:"+uop.getEffectiveTax()+"%");
        System.out.println("Umowa zlecenie:"+uz.getEffectiveTax()+"%");
        System.out.println("Umowa o dzielo:"+uod.getEffectiveTax()+"%");
        System.out.println("- - - - - -");
        System.out.println("Przyjete zalozenia:");
        System.out.println("Praca w miejscu zamieszkania, brak autorskich kosztow uzyskania przychodu, swiadczenie ZUS w wysokosci faktury (b2b)");
    }
}
