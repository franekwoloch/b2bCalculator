package logic;

import data.*;
import utils.CalculationsUtils;
import utils.DataReader;
import utils.FileManager;
import utils.JobUtils;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class AppControl {
    //variables to interaction with user
    private DataReader dataReader;
    private FileManager fileManager;

    //database
    private Calculations calculations;

    public AppControl() {
        dataReader = new DataReader();
        fileManager = new FileManager();


        try {
            calculations = fileManager.readCalculationsFromFile();
            System.out.println("Wczytano dane z bazy danych");
        } catch (ClassNotFoundException | IOException e) {
            calculations = new Calculations();
            System.out.println("Utworzona nowa baze danych");
        }

    }


    //main loop - choose option and interaction

    public void controlLoop() {
        Option option = null;
        while (option != Option.EXIT) {
            try {

                printOptions();
                option = Option.createFromInt(dataReader.getInt());
                switch (option) {
                    case B2B:
                        addB2b();
                        break;
                    case UOP:
                        addUoP();
                    case UZ:
                        addUz();
                        break;
                    case UOD:
                        addUoD();
                        break;
                    case PRINT:
                        printCalculations();
                        break;
                    case EXIT:
                        exit();
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Wprowadzono niepoprawne dane");
            } catch (NumberFormatException | NoSuchElementException e) {
                System.out.println("Wybrana opcja nie istnieje");
            }
        }
        //close of output stream
        dataReader.close();
    }

    private void addB2b() {

        int option=0;
        System.out.println("1-znam wartosc faktury || 2- wiem ile chce zarobic ");
        B2b b2b = new B2b();
        while (option != 1 & option != 2){

                option = dataReader.getInt();
                switch (option) {
                    case 1:
                        b2b = dataReader.createB2bInvoice();
                        break;
                    case 2:
                        b2b = dataReader.createB2bProfit();
                        break;
                    default:
                        System.out.println("Podano niepoprawna wartosc");
                    }
            }
        JobUtils.showResult(b2b);
        CalculationsUtils.saveCalculations(b2b,calculations);

    }


    private void addUoP() {

        int option=-1;
        System.out.println("1-znam wynagrodzenie netto || 2- znam wynagrodzenie brutto ");
        UoP uop=new UoP();
        while (option != 1 & option != 2) {

            option = dataReader.getInt();

            switch (option) {
                case 1:
                    uop = dataReader.createUopNetto();
                    break;
                case 2:
                    uop = dataReader.createUopBrutto();
                default:
                    System.out.println("Podano niepoprawna wartosc");
            }

        }

            JobUtils.showResult(uop);
            CalculationsUtils.saveCalculations(uop,calculations);
    }


    private void addUz() {
        int option=-1;
        System.out.println("1-znam wynagrodzenie netto || 2- znam wynagrodzenie brutto ");
        Uz uz=new Uz();
        while (option != 1 & option != 2) {

            option = dataReader.getInt();

            switch (option) {
                case 1:
                    uz = dataReader.createUzNetto();
                    break;
                case 2:
                    uz = dataReader.createUzBrutto();
                default:
                    System.out.println("Podano niepoprawna wartosc");
            }

        }

        JobUtils.showResult(uz);
        CalculationsUtils.saveCalculations(uz,calculations);
    }


    private void addUoD() {
        int option=-1;
        System.out.println("1-znam wynagrodzenie netto || 2- znam wynagrodzenie brutto ");
        UoD uod=new UoD();
        while (option != 1 & option != 2) {

            option = dataReader.getInt();

            switch (option) {
                case 1:
                    uod = dataReader.createUoDNetto();
                    break;
                case 2:
                    uod = dataReader.createUoDBrutto();
                default:
                    System.out.println("Podano niepoprawna wartosc");
            }

        }

        JobUtils.showResult(uod);
        CalculationsUtils.saveCalculations(uod,calculations);
    }


    private void printCalculations() {
        CalculationsUtils.printCalculations(calculations);
    }


    private void printOptions() {
        System.out.println("Wybierz opcje:");
        for (Option o : Option.values()) {
            System.out.println(o);
        }

    }


    private void exit (){
        fileManager.writeCalculationsToFile(calculations);
    }



    private enum Option {
        EXIT(0, "Wyjscie z programu"),
        B2B(1, "Umowa b2b"),
        UOP(2, "Umowa o prace"),
        UZ(3, "Umowa zlecenie"),
        UOD(4, "Umowa o dzielo"),
        PRINT(5, "Pokaz zapisane kalkulacje");

        private int value;
        private String description;


        Option(int value, String description) {
            this.value = value;
            this.description = description;
        }

        @Override
        public String toString() {
            return value + " - " + description;
        }

        public static Option createFromInt(int option) throws NoSuchElementException {
            Option result = null;
            try {
                result = Option.values()[option];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchElementException("Brak elementu o podanym ID ");
            }
            return result;
        }
    }

}

