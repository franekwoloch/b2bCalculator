package data;

import java.io.Serializable;
import java.util.Arrays;

public class Calculations implements Serializable {

        private static final long serialVersionUID = 2995794334600947814L;
        public static final int INITIAL_CAPACITY=10;


        private Record[] calculationsDataBase;
        private int calculationNumber;


    public Calculations(){

            calculationsDataBase=new Record[INITIAL_CAPACITY];
        }

        public Record[] getCalculations(){
            return calculationsDataBase;
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
            while (i<calculationsDataBase.length&&found==NOT_FOUND){
                if (record.equals(calculationsDataBase[i])){
                    found=i;
                }else {
                    i++;
                }
            }
            if (found!=NOT_FOUND){
                System.arraycopy(calculationsDataBase, found+1,calculationsDataBase, found,calculationsDataBase.length-found-1);
                calculationNumber--;
            }
        }



    public void addRecord(Record record)throws ArrayIndexOutOfBoundsException{
        if (calculationNumber==calculationsDataBase.length) {
            calculationsDataBase= Arrays.copyOf(calculationsDataBase, calculationsDataBase.length*2);
        }
        calculationsDataBase[calculationNumber]=record;
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





