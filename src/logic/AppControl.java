package logic;

import data.Calculations;
import utils.DataReader;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class AppControl {
    //variables to interaction with user
    private DataReader dataReader;
    //private FileManager fileManager;

    //database
    private Calculations calculations;

    public AppControl(){
        dataReader=new DataReader();
        //fileManager=new FileManager();
        try {
            library=fileManager.readLibraryFromFile();
            System.out.println("Wczytano dane z biblioteki");
        } catch (ClassNotFoundException|IOException e){
            calculations=new Calculations();
            System.out.println("Utworzona nowa baze danych");
        }
    }



    //main loop - choose option and interaction

    public void controlLoop(){
        Option option=null;
        while (option!=Option.EXIT){
            try {

                printOptions();
                option = Option.createFromInt(dataReader.getInt());
                switch (option) {
                    case ADD_BOOK:
                        addBook();
                        break;
                    case ADD_MAGAZINE:
                        addMagazine();
                    case PRINT_BOOKS:
                        printBooks();
                        break;
                    case PRINT_MAGAZINES:
                        printMagazines();
                        break;
                    case EXIT:
                        exit();
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Wprowadzono niepoprawne dane");
            }
            catch (NumberFormatException | NoSuchElementException e){
                System.out.println("Wybrana opcja nie istnieje");
            }
        }
        //close of output stream
        dataReader.close();
    }

    private void addBook(){
        Book book=dataReader.readAndCreateBook();
        library.addBook(book);
    }

    private void addMagazine(){
        Magazine magazine=dataReader.readAndCreateMagazine();
        library.addMagazine(magazine);
    }

    private void printBooks(){
        LibraryUtils.printBooks(library);
    }
    private void printMagazines(){LibraryUtils.printMagazines(library);}

    private void printOptions(){
        System.out.println("Wybierz opcje:");
        for (Option o:Option.values()){
            System.out.println(o);
        }

    }
    private void exit (){
        fileManager.writeLibraryToFile(library);
    }

    private enum Option {
        EXIT(0,"Wyjscie z programu"),
        ADD_BOOK(1,"Dodanie nowej ksiazki"),
        ADD_MAGAZINE(2, "Dodanie nowego czasopisma"),
        PRINT_BOOKS(3, "Wyswietlenie wszystkich ksiazek"),
        PRINT_MAGAZINES(4,"Wyswietlenie wszystkich czasopism");

        private int value;
        private String description;


        Option(int value, String description){
            this.value=value;
            this.description=description;
        }

        @Override
        public String toString() {
            return value+" - "+description;
        }

        public static Option createFromInt (int option) throws NoSuchElementException{
            Option result=null;
            try {
                result= Option.values()[option];
            }
            catch (ArrayIndexOutOfBoundsException e){
                throw new NoSuchElementException("Brak elementu o podanym ID ");
            }
            return result;
        }
    }

}

