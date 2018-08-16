package utils;

import data.B2b;
import data.Magazine;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataReader {
    private Scanner sc;
    public DataReader(){
        sc=new Scanner(System.in);
    }

    public void close(){
        sc.close();
    }

    public B2b createB2b() throws InputMismatchException{
        System.out.println("Tittle:");
        String tittle=sc.nextLine();
        System.out.println("Author:");
        String author=sc.nextLine();
        System.out.println("Publisher:");
        String publisher=sc.nextLine();
        System.out.println("ISBN:");
        String isbn=sc.nextLine();
        int releaseDate=0;
        int pages=0;
        try {
            System.out.println("Year");
            releaseDate = sc.nextInt();
            System.out.println("Pages:");
            pages = sc.nextInt();
        }
        catch (InputMismatchException e){
            sc.nextLine();
            throw e;
        }
        return new Book(tittle, author, releaseDate, pages, publisher, isbn);
    }

    public Magazine readAndCreateMagazine()throws InputMismatchException{
        System.out.println("Tittle:");
        String title=sc.nextLine();
        System.out.println("Publisher:");
        String publisher=sc.nextLine();
        System.out.println("Language:");
        String language=sc.nextLine();
        int year=0;
        int month=0;
        int day=0;
        try {
            System.out.println("Year:");
            year = sc.nextInt();
            System.out.println("Month:");
            month = sc.nextInt();
            System.out.println("Day:");
            day = sc.nextInt();
            sc.nextLine();
        }
        catch (InputMismatchException e){
            sc.nextLine();
            throw e;
        }
        return new Magazine(title, publisher, language, year, month, day);
    }

    public int getInt()throws NumberFormatException{
        int number=0;
        try {
            number = sc.nextInt();
        }
        catch (InputMismatchException e){
            throw new NumberFormatException("Liczba wprowadzona jest spoza zakresu");
        }
        finally {
            sc.nextLine();
        }
        return number;
    }
}
