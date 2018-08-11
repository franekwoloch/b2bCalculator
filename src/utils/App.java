package utils;

import data.Pit;
import data.Zus;

import java.util.Scanner;

public class App {
    public static void main (String args []){
        Scanner sc = new Scanner(System.in);
        double zusBenefit;
        double invoice;
        double profit;

        System.out.println("Podaj oczekiwane świadczenie ZUS 100%");
        zusBenefit=sc.nextDouble();
        System.out.println("Podaj kwotę netto na fakturze");
        invoice=sc.nextDouble();
        Zus zus=new Zus(zusBenefit);
        Pit pit=new Pit (invoice,zus.costFee());
        profit = invoice-zus.totalFee()-pit.payPit();
        System.out.println("Składka ZUS łącznie: "+zus.totalFee());
        System.out.println("Twój dochód wyniesie: "+profit);
        System.out.println("Twój podatek do zapłaty wynienie: "+pit.payPit());
        sc.nextLine();
    }
}
