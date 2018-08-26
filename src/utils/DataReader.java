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

            System.out.println("Wartosc faktury");
            invoice=getDouble();
            System.out.println("Wartosc swiadczenia ZUS (100%)");
            zusBenefit=getDouble();

        B2b b2b=new B2b();
        b2b.invoiceB2b(zusBenefit,invoice);
        return b2b;
    }

    public B2b createB2bProfit() throws InputMismatchException{
        double profit;
        double zusBenefit;

            System.out.println("Wartosc wynagrodzenia 'do reki' ");
            profit=getDouble();
            System.out.println("Wartosc swiadczenia ZUS (100%)");
            zusBenefit=getDouble();

        B2b b2b=new B2b();
        b2b.profitB2b(zusBenefit,profit);
        return b2b;
    }

    public UoP createUopBrutto() throws InputMismatchException {
        double salary;
        Cost cost1 = null;
        Cost cost2 = null;
        UoP uop = new UoP();
        System.out.println("Wybierz skladowe kosztow uzyskania przychodu:");
        while ((cost1 == null) ||( cost2 == null)) {

            try {
2                System.out.println("Z uwagi na miejsce zamieszkania:");
                System.out.println(Cost.LOCAL.toString() + " lub " + Cost.ARRIVAL.toString());
                cost1 = Cost.createFromInt(getInt());
                System.out.println("Autorskie koszty uzyskania przuchodu:");
                System.out.println(Cost.AUTHOR.toString() + " lub " + Cost.NO.toString());
                cost2 = Cost.createFromInt(getInt());
            }
            catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Wybierz poprawne koszta ;)");
            }

        }
                System.out.println("Wartosc wynagrodzenia brutto ");
                salary = getDouble();

            uop.UoPBrutto(salary, cost1, cost2);
        return uop;

        }


    public UoP createUopNetto() throws InputMismatchException {
        double profit;
        Cost cost1 = null;
        Cost cost2 = null;
        UoP uop = new UoP();
        while ((cost1 == null) ||( cost2 == null)) {

                System.out.println("Wybierz skladowe kosztow uzyskania przuchodu:");
                try {
                    System.out.println("Z uwagi na miejsce zamieszkania:");
                    System.out.println(Cost.LOCAL.toString() + " lub " + Cost.ARRIVAL.toString());
                    cost1 = Cost.createFromInt(getInt());
                    System.out.println("Autorskie koszty uzyskania przuchodu:");
                    System.out.println(Cost.AUTHOR.toString() + " lub " + Cost.NO.toString());
                    cost2 = Cost.createFromInt(getInt());
                } catch (ArrayIndexOutOfBoundsException e){
                        System.err.println("Wybierz poprawne koszta ;)");
                }
            }

                System.out.println("Wartosc wynagrodzenia netto ");
                profit = getDouble();
                uop.UoPNetto(profit, cost1, cost2);
        return uop;
        }




    public Uz createUzNetto() throws InputMismatchException {
        double profit;
        double cost1=0;
        double cost2=0;

        Uz uz = new Uz();

                System.out.println("Wartosc wynagrodzenia 'do reki ");
                profit = getDouble();

        uz.UzNetto(profit,cost1,cost2);
        return uz;
    }

    public Uz createUzBrutto() throws InputMismatchException {
        double salary;
        double cost=0;
        Uz uz = new Uz();
                salary = getDouble();
        uz.UzBrutto(salary, cost);
        return uz;
    }

    public UoD createUoDNetto() throws InputMismatchException {
        double profit;
        double cost=0;

        UoD uod = new UoD();
        profit = getDouble();

        uod.UoDProfit(profit, cost);
        return uod;
    }

    public UoD createUoDBrutto() throws InputMismatchException {
        double salary;
        double cost=0;
        UoD uod = new UoD();

        System.out.println("Wartosc wynagrodzenia brutto: ");
        salary = getDouble();

        uod.UoDSalary(salary, cost);
        return uod;
    }


    public int getInt(){
        int number=0;
        boolean error=true;
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

    public double getDouble(){
        double number=0;
        boolean error=true;
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


    private void printCostsUCC(){
        System.out.println("Wybierz skladowe kosztow uzyskania przychodu:");
        System.out.println("Autorskie koszty uzyskania przuchodu:");
        System.out.println(Cost.AUTHOR.toString() +" lub "+Cost.NORMAL.toString());
    }



}

