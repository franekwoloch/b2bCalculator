package data;

import java.io.Serializable;
import java.util.Arrays;

public class Calculations implements Serializable {

        private static final long serialVersionUID = 2995794334600947814L;
        public static final int INITIAL_CAPACITY=1;


        private Job[] calculations;
        private int calculationNumber;


        public Calculations(){

            calculations=new Job[INITIAL_CAPACITY];
        }

        public Job[] getCalculations(){
            return calculations;
        }

        public int getCalculationNumber(){

            return calculationNumber;
        }

        public void addB2b(B2b b2b) {
            addJob(b2b);
        }

        public void addUoP(UoP uop) {
            addJob(uop);
        }

        public void addUz(Uz uz) {
            addJob(uz);
        }

        public void addUoD(UoD uoD) {
            addJob(uoD);
        }

        private void removeCalculation(Job job){
            if (job==null)
                return;
            final int NOT_FOUND=-1;
            int found=NOT_FOUND;
            int i=0;
            while (i<calculations.length&&found==NOT_FOUND){
                if (job.equals(calculations[i])){
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



        private void addJob(Job job)throws ArrayIndexOutOfBoundsException{
            if (calculationNumber==calculations.length) {
                calculations= Arrays.copyOf(calculations, calculations.length*2);
            }
            calculations[calculationNumber]=job;
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





