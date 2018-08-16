package data;

public enum Cost {
    LOCAL("Praca w miejscu zamieszkania"), ARRIVAL("Dojazd do miejsca pracy"), NORMAL("Normalny koszty uzyskania przychody"),
    AUTHOR ("Autorskie koszty uzyskania przychodu"), NO("Brak dodatkowych kosztow");

    private String description;

    Cost(String desc) {
        description = desc;
    }

    public String getDescription() {
        return description;
    }
}

