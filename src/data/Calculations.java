package data;

import java.io.Serializable;
import java.util.Arrays;

public class Calculations implements Serializable {

        private static final long serialVersionUID = 2995794334600947814L;
        public static final int INITIAL_CAPACITY=1;


        private Record[] calculations;
        private int calculationNumber;


    public Calculations(){

            calculations=new Record[INITIAL_CAPACITY];
        }

        public Record[] getCalculations(){
            return calculations;
        }

        public int getCalculationNumber(){

            return calculationNumber;
        }



        public void removeCalculation(Record record){
            if (record==null)
                return;
            final int NOT_FOUND=-1;
            int found=NOT_FOUND;
            int i=0;
            while (i<calculations.length&&found==NOT_FOUND){
                if (record.equals(calculations[i])){
                    found=i;
                }else {
                    i++;
                }
            }
            if (found!=NOT_FOUND){
                System.arraycopy(calculations, found+1,calculations, found,calculations.length-found-1);
                calculationNumber--;
            }
        }



    public void addRecord(Record record)throws ArrayIndexOutOfBoundsException{
        if (calculationNumber==calculations.length) {
            calculations= Arrays.copyOf(calculations, calculations.length*2);
        }
        calculations[calculationNumber]=record;
        calculationNumber++;
    }

       /*
        @Override
        public String toString() {
            StringBuilder builder=new StringBuilder();
            for (int i=0; i<calculationNumber; i++){
                builder.append(calculations[i]);
                builder.append("\n");
            }
            return builder.toString();
        }
        */
    }





