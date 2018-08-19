package utils;

import data.Job;
import data.Record;
import java.util.Scanner;


public class JobUtils {
    public static void showResult(Job job) {
        System.out.println("Wyplata 'na reke': " + job.getProfit());
        System.out.println("Koszt pracodawcy: " + job.getEmployerCost());
        System.out.println("Efektywne obciazenie podatkowe: " + job.getEffectiveTax() + "%");
    }

    public static Record saveRecord(Job job) {

        Scanner sc = new Scanner(System.in);
        String recordName;

        System.out.println("Podaj nazwe kalkulacji");
        recordName = sc.nextLine();
        Record record = new Record(recordName, job);
        Record.recordID++;
        record.setId(Record.recordID);

        return record;
    }


}
