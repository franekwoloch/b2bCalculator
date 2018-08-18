package utils;

import data.B2b;
import data.Cost;
import data.UoP;


import java.util.InputMismatchException;
import java.util.Scanner;

public class DataReader {
    private Scanner sc;
    public DataReader(){
        sc=new Scanner(System.in);
    }

    public void close(){
        sc.close();
    }

    public B2b createB2bInvoice() throws InputMismatchException{
        double invoice;
        double zusBenefit;

        try {
            System.out.println("Wartosc faktury");
            invoice=sc.nextDouble();
            System.out.println("Wartosc swiadczenia ZUS (100%)");
            zusBenefit=sc.nextDouble();
        }
        catch (InputMismatchException e){
            sc.nextLine();
            throw e;
        }
        B2b b2b=new B2b();
        b2b.invoiceB2b(zusBenefit,invoice);
        return b2b;
    }

    public B2b createB2bProfit() throws InputMismatchException{
        double profit;
        double zusBenefit;

        try {
            System.out.println("Wartosc wynagrodzenia 'do reki' ");
            profit=sc.nextDouble();
            System.out.println("Wartosc swiadczenia ZUS (100%)");
            zusBenefit=sc.nextDouble();
        }
        catch (InputMismatchException e){
            sc.nextLine();
            throw e;
        }
        B2b b2b=new B2b();
        b2b.profitB2b(zusBenefit,profit);
        return b2b;
    }

    public UoP createUopBrutto() throws InputMismatchException{
        double salary;
        Cost cost1;
        Cost cost2;


        try {
            System.out.println("Wartosc wynagrodzenia brutto ");
            salary=sc.nextDouble();

        }
        catch (InputMismatchException e){
            sc.nextLine();
            throw e;
        }



        UoP uop=new UoP();
        uop.UoPBrutto(salary,cost1,cost2);
        return uop;
    }


    public int getInt()throws NumberFormatException{
        int number=0;
        try {
            number = sc.nextInt();
        }
        catch (InputMismatchException e){
            throw new NumberFormatException("Liczba wprowadzona jest spoza zakresu");
        }
        finally {
            sc.nextLine();
        }
        return number;
    }
}
