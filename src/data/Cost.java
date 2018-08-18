package data;

import java.util.NoSuchElementException;

public enum Cost {
    LOCAL(1,"Praca w miejscu zamieszkania"), ARRIVAL(2,"Dojazd do miejsca pracy"), NORMAL(3,"Normalny koszty uzyskania przychody"),
    AUTHOR (4,"Autorskie koszty uzyskania przychodu"), NO(5,"Brak dodatkowych kosztow");

    private String description;
    private int value;

    Cost(int value, String desc) {
        this.value=value;
        this.description=description;
    }

    @Override
    public String toString() {
        return value+" - "+description;
    }

    public static Cost createFromInt (int option) throws NoSuchElementException {
        Cost result=null;
        try {
            result= Cost.values()[option];
        }
        catch (ArrayIndexOutOfBoundsException e){
            throw new NoSuchElementException("Brak elementu o podanym ID ");
        }
        return result;
    }


}

