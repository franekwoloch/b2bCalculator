package utils;
import java.util.Scanner;


import data.*;


import java.util.InputMismatchException;
import java.util.NoSuchElementException;


public class DataReader {
    private Scanner sc;
    public DataReader(){
        sc=new Scanner(System.in);
    }

    public void close(){

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

    public UoP createUopBrutto() throws InputMismatchException {
        double salary;
        Cost cost1 = null;
        Cost cost2 = null;
        UoP uop = new UoP();
        while ((cost1 == null) ||( cost2 == null)) {

                System.out.println("Wybierz skladowe kosztow uzyskania przuchodu:");
                System.out.println("Z uwagi na miejsce zamieszkania:");
                System.out.println(Cost.LOCAL.toString() +" lub "+Cost.ARRIVAL.toString());
                cost1 = Cost.createFromInt(getInt());
                System.out.println("Autorskie koszty uzyskania przuchodu:");
                System.out.println(Cost.AUTHOR.toString() +" lub "+Cost.NO.toString());
                cost2 = Cost.createFromInt(getInt());

            }


            try {
                System.out.println("Wartosc wynagrodzenia brutto ");
                salary = sc.nextDouble();

            } catch (InputMismatchException e) {
                sc.nextLine();
                throw e;
            }



            uop.UoPBrutto(salary, cost1, cost2);
        return uop;

        }


    public UoP createUopNetto() throws InputMismatchException {
        double profit;
        Cost cost1 = null;
        Cost cost2 = null;
        int localOption;
        UoP uop = new UoP();
        while ((cost1 == null) ||( cost2 == null)) {

                System.out.println("Wybierz skladowe kosztow uzyskania przuchodu:");
                System.out.println("Z uwagi na miejsce zamieszkania:");
                System.out.println(Cost.LOCAL.toString() +" lub "+Cost.ARRIVAL.toString());
                localOption=getInt();
                System.out.println(localOption);
                cost1 = Cost.createFromInt(localOption);
                System.out.println("Autorskie koszty uzyskania przuchodu:");
                System.out.println(Cost.AUTHOR.toString() +" lub "+Cost.NO.toString());
                localOption=getInt();
                cost2 = Cost.createFromInt(localOption);


            }

            try {
                System.out.println("Wartosc wynagrodzenia netto ");
                profit = sc.nextDouble();

            } catch (InputMismatchException e) {
                sc.nextLine();
                throw e;
            }



            uop.UoPNetto(profit, cost1, cost2);
        return uop;
        }




    public Uz createUzNetto() throws InputMismatchException {
        double profit;
        double cost1=0;
        double cost2=0;

        Uz uz = new Uz();

            try {
                System.out.println("Wartosc wynagrodzenia 'do reki ");
                profit = sc.nextDouble();

            } catch (InputMismatchException e) {
                sc.nextLine();
                throw e;
            }

        uz.UzNetto(profit,cost1,cost2);
        return uz;
    }

    public Uz createUzBrutto() throws InputMismatchException {
        double salary;
        double cost=0;
        Uz uz = new Uz();

            try {
                System.out.println("Wartosc wynagrodzenia brutto: ");
                salary = sc.nextDouble();

            } catch (InputMismatchException e) {
                sc.nextLine();
                throw e;
            }
        uz.UzBrutto(salary, cost);
        return uz;
    }

    public UoD createUoDNetto() throws InputMismatchException {
        double profit;
        double cost=0;

        UoD uod = new UoD();

        try {
            System.out.println("Wartosc wynagrodzenia 'do reki ");
            profit = sc.nextDouble();

        } catch (InputMismatchException e) {
            sc.nextLine();
            throw e;
        }

        uod.UoDProfit(profit, cost);
        return uod;
    }

    public UoD createUoDBrutto() throws InputMismatchException {
        double salary;
        double cost=0;
        UoD uod = new UoD();

        try {
            System.out.println("Wartosc wynagrodzenia brutto: ");
            salary = sc.nextDouble();

        } catch (InputMismatchException e) {
            sc.nextLine();
            throw e;
        }
        uod.UoDSalary(salary, cost);
        return uod;
    }


    public int getInt()throws NumberFormatException{
        int number;
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


    private void printCostsUCC(){
        System.out.println("Wybierz skladowe kosztow uzyskania przuchodu:");
        System.out.println("Autorskie koszty uzyskania przuchodu:");
        System.out.println(Cost.AUTHOR.toString() +" lub "+Cost.NORMAL.toString());
    }



}

