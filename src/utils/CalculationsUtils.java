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
        System.out.println("Czy chcesz zapisac obliczenia? [0-yes/1-no]");
        int choice=-1;
        DataReader dataReader;
        dataReader = new DataReader();
        while (choice !=0 & choice != 1) {

            choice = dataReader.getInt();
            switch (choice) {
                case 0:
                    Record record=JobUtils.saveRecord(b2b);
                    calc.addRecord(record);
                    System.out.println("Zapisano obliczenia");
                    break;
                case 1:
                    break;
                default:
                    System.out.println("Podano niepoprawna wartosc");
            }
        }
    }

}