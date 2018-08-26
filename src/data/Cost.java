package data;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public enum Cost {
    LOCAL(0,"Praca w miejscu zamieszkania"), ARRIVAL(1,"Dojazd do miejsca pracy"), NORMAL(2,"Normalny koszty uzyskania przychody"),
    AUTHOR (3,"Autorskie koszty uzyskania przychodu"), NO(4,"Brak dodatkowych kosztow");

    private String description;
    private int value;

    Cost(int value, String desc) {
        this.value=value;
        this.description=desc;
    }

    @Override
    public String toString() {
        return value+" - "+description;
    }

    public static Cost createFromInt (int option)  {
        Scanner sc=new Scanner(System.in);
        Cost result=null;
        boolean error=true;
         do {
            try {
                System.out.println("input");
                sc.nextLine();
                result = Cost.values()[option];
                error = false;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(error);
                System.out.println("option: "+option);
                System.err.println("Podałeś indeks wykraczający poza rozmiar tablicy!");

            }
            catch(InputMismatchException ex) {
                System.out.println("option: "+option);
                System.out.println("Nie podałeś liczby całkowitej, spróbuj jeszcze raz: ");

            }
        }
        while (error);
        return result;
    }


}

