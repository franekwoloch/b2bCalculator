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
        Cost cost;
        Uz uz = new Uz();
        cost=getUccCost();
        uz.setStudentStatus(Student());
        System.out.println("Wartosc wynagrodzenia 'do reki ");
        profit = getDouble();

        uz.UzNetto(profit, cost);
        return uz;
    }

    public Uz createUzBrutto()  {
        double salary;
        Cost cost;
        Uz uz = new Uz();
        cost=getUccCost();
        System.out.println("Podaj oczekiwane wynagrodzenie brutto");
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

            if (!(cost2==Cost.AUTHOR||cost1==Cost.NO)||!(cost1==Cost.LOCAL||cost1==Cost.ARRIVAL)){
                System.err.println("Wybierz poprawne koszta!");;
                cost1=null;
                cost2=null;
            }

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
            }
            if (!((cost==Cost.AUTHOR)||(cost==Cost.NORMAL))){
                System.err.println("Wybierz poprawne koszta!");
                cost=null;
            }
        }
        return cost;
    }


    public boolean Student(){
        System.out.println("Czy jestes studentem? | 0-no | 1 - yes");
        int choice=-1;
        boolean result=false;
        do{
            choice = getInt();
            switch (choice) {
                case 0:
                    result= false;
                    System.out.println("save");
                    break;
                case 1:
                    result=true;
                    System.out.println("save");
                    break;
                default:
                    System.out.println("Podano niepoprawna wartosc");
            }
        }
        while (choice !=0 & choice != 1);
        return result;
    }


}

