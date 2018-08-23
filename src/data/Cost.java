package data;

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
        System.out.println("start fromInt");
        try {
            result= Cost.values()[option];
        }
        catch(ArrayIndexOutOfBoundsException e) {
        System.err.println("Podałeś indeks wykraczający poza rozmiar tablicy!");
            sc.nextLine();
        }
        return result;
    }


}

