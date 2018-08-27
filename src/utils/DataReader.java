package utils;

import java.util.Scanner;


import data.*;


import java.util.InputMismatchException;
import java.util.NoSuchElementException;


public class DataReader {
    private Scanner sc;

    public DataReader() {
        sc = new Scanner(System.in);
    }

    public void close() {

    }

    public B2b createB2bInvoice()  {
        double invoice;
        double zusBenefit;

        System.out.println("Wartosc faktury");
        invoice = getDouble();
        System.out.println("Wartosc swiadczenia ZUS (100%)");
        zusBenefit = getDouble();

        B2b b2b = new B2b();
        b2b.invoiceB2b(zusBenefit, invoice);
        return b2b;
    }

    public B2b createB2bProfit()  {
        double profit;
        double zusBenefit;

        System.out.println("Wartosc wynagrodzenia 'do reki' ");
        profit = getDouble();
        System.out.println("Wartosc swiadczenia ZUS (100%)");
        zusBenefit = getDouble();

        B2b b2b = new B2b();
        b2b.profitB2b(zusBenefit, profit);
        return b2b;
    }

    public UoP createUopBrutto()  {
        double salary;
        UoP uop = new UoP();
        getCostsUoP();
        System.out.println("Wartosc wynagrodzenia brutto ");
        salary = getDouble();
        uop.UoPBrutto(salary, costs[0], costs[1]);
        return uop;
    }


    public UoP createUopNetto() {
        double profit;
        UoP uop = new UoP();
        getCostsUoP();
        System.out.println("Wartosc wynagrodzenia netto ");
        profit = getDouble();
        uop.UoPNetto(profit, costs[0], costs[1]);
        return uop;
    }


    public Uz createUzNetto()  {
        double profit;
        double cost1 = 0;
        double cost2 = 0;

        Uz uz = new Uz();

        System.out.println("Wartosc wynagrodzenia 'do reki ");
        profit = getDouble();

        uz.UzNetto(profit, cost1, cost2);
        return uz;
    }

    public Uz createUzBrutto()  {
        double salary;
        double cost = 0;
        Uz uz = new Uz();
        salary = getDouble();
        uz.UzBrutto(salary, cost);
        return uz;
    }

    public UoD createUoDNetto()  {
        double profit;
        Cost cost;
        UoD uod = new UoD();
        cost=getUccCost();
        System.out.println("Podaj wartosc wynagrodzenie netto -  -do 'reki");
        profit = getDouble();
        uod.UoDProfit(profit, cost);
        return uod;
    }

    public UoD createUoDBrutto()  {
        double salary;
        Cost cost;
        UoD uod = new UoD();
        cost=getUccCost();
        System.out.println("Wartosc wynagrodzenia brutto: ");
        salary = getDouble();
        uod.UoDSalary(salary, cost);
        return uod;
    }


    public int getInt() {
        int number = 0;
        boolean error = true;
        while (error) {
            try {
                number = sc.nextInt();
                error = false;
            } catch (NumberFormatException | NoSuchElementException e) {
                System.err.println("Podaj liczbe calkowita!");
            } finally {
                sc.nextLine();
            }
        }
        return number;
    }

    public double getDouble() {
        double number = 0;
        boolean error = true;
        while (error) {
            try {
                number = sc.nextDouble();
                error = false;
            } catch (NumberFormatException | NoSuchElementException e) {
                System.err.println("Podaj liczbe!");
            } finally {
                sc.nextLine();
            }
        }
        return number;
    }

    private Cost[] costs = new Cost[2];

    public Cost[] getCostsUoP() throws InputMismatchException {
        Cost cost1 = null;
        Cost cost2 = null;

        while ((cost1 == null) || (cost2 == null)) {

            System.out.println("Wybierz skladowe kosztow uzyskania przuchodu:");
            try {
                System.out.println("Z uwagi na miejsce zamieszkania:");
                System.out.println(Cost.LOCAL.toString() + " lub " + Cost.ARRIVAL.toString());
                cost1 = Cost.createFromInt(getInt());
                System.out.println("Autorskie koszty uzyskania przuchodu:");
                System.out.println(Cost.AUTHOR.toString() + " lub " + Cost.NO.toString());
                cost2 = Cost.createFromInt(getInt());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("Wybierz poprawne koszta ;)");
            }
            //Do napisania kontrola kosztow
            /*
            if ((cost2!=Cost.AUTHOR||cost1!=Cost.NO)||(cost1!=Cost.LOCAL||cost1!=Cost.ARRIVAL)){
                System.out.println("Niepoprawne dane");
                cost1=null;
                cost2=null;
            }
            */
        }

        costs[0] = cost1;
        costs[1] = cost2;
        return costs;
    }


    public Cost getUccCost() {
        Cost cost = null;
        while (cost == null) {
            System.out.println("Wybierz koszty uzyskania przychodu:");
            System.out.println(Cost.AUTHOR.toString() + " lub " + Cost.NORMAL.toString());
            try {
                cost = Cost.createFromInt(getInt());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("Wybierz poprawne koszta ;)");
            } //zaimplementowac kontrole kosztow
        }
        return cost;
    }


    private void printCostsUCC() {
        System.out.println("Wybierz skladowe kosztow uzyskania przychodu:");
        System.out.println("Autorskie koszty uzyskania przuchodu:");
        System.out.println(Cost.AUTHOR.toString() + " lub " + Cost.NORMAL.toString());
    }


}

