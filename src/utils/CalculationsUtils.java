package utils;

import data.Calculations;
import data.Job;
import data.Record;

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

}