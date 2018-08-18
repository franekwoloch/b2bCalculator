package utils;

import data.Calculations;
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
            System.out.println("Brak ksiazek w bibliotece");
        }
    }

}