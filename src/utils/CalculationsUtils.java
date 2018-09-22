package utils;

import data.Calculations;
import data.Job;
import data.Record;
import logic.AppControl;

public class CalculationsUtils {


    public static void printCalculations(Calculations calc) {
        Record[] calculations = calc.getCalculations();
        int calculationNumber = calc.getCalculationNumber();
        int countCalcs = 0;
        for (int i = 0; i < calculationNumber; i++) {
            if (calculations[i] instanceof Record) {
                System.out.println(calculations[i]);
                countCalcs++;
            }
        }

        if (countCalcs == 0) {
            System.out.println("Brak zapisanych obliczen");
        }
    }


    public static void saveCalculations(Job b2b, Calculations calc){
        System.out.println("Czy chcesz zapisac obliczenia? [1-yes/0-no]");
        int choice=-1;
        DataReader dataReader;
        dataReader = new DataReader();
        while (choice !=0 & choice != 1) {

            choice = dataReader.getInt();
            switch (choice) {
                case 0:
                    break;
                case 1:
                    Record record=JobUtils.saveRecord(b2b);
                    calc.addRecord(record);
                    System.out.println("Zapisano obliczenia");
                    break;
                default:
                    System.out.println("Podano niepoprawna wartosc");
            }
        }
    }

    public static double round(double number, int size){
        double force=Math.pow(10,size);
        double tempNumber=force*number;
        tempNumber=Math.round(tempNumber);
        number=tempNumber/force;
        return number;
    }

    public static void compareCalculations(boolean lastCalculation/*, Job job*/){
        int option=-1;
        DataReader dataReader=new DataReader();
        double netto=0;
        double brutto=0;
        /*
        if (lastCalculation==true) {
            netto= job.getProfit();
            brutto=job.getEmployerCost();
        }
        */
        while (option != 0) {
                System.out.println("Wybierz opcje:");
                System.out.println("0-EXIT");
                System.out.println("1 - Chce porownac wynagrodzenie 'do reki'");
                System.out.println("2 - Chce porownac koszty pracodawcy");
                option = dataReader.getInt();
                switch (option) {
                    case 0:
                        break;
                    case 1:
                        if (netto==0) {
                            System.out.println("Podaj wynagrodzenie do reki");
                            netto=dataReader.getDouble();
                        }
                        Compare.compareNetto(netto);
                        break;
                    case 2:
                        if (brutto==0) {
                            System.out.println("Podaj koszt pracodawcy");
                            brutto = dataReader.getDouble();
                        }
                        Compare.compareBrutto(brutto);
                        break;
                    default:
                        System.out.println("Nie ma takiej opcji");
                        break;

                }
            }

        //close of output stream
        dataReader.close();
    }

}




