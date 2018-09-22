package data;

import java.io.Serializable;
import java.time.Instant;
import java.util.Arrays;

public class Record implements Serializable{

public static int recordID=0;
    private int id;
    private Instant time;
    private String description;
    private Job job;

    public Record(String desc,Job job){
        setTime(Instant.now());
        setDescription(desc);
        setJob(job);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return getDescription()+": wynagrodzenie do reki: "+job.getProfit()+" PLN | koszt pracodawcy: "+job.getEmployerCost()+" PLN | efektywne obciazenie podatkowe: "+job.getEffectiveTax()+"%";
    }
}
