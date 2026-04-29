package entidade;

import entities.Enum.WorkoutType;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WorkOut {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private Date date;
    private Integer durantionMinutes;
    private WorkoutType type;

    public WorkOut(Date date, Integer durantionMinutes, WorkoutType type) {
        this.date = date;
        this.durantionMinutes = durantionMinutes;
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getDurantionMinutes() {
        return durantionMinutes;
    }

    public void setDurantionMinutes(Integer durantionMinutes) {
        this.durantionMinutes = durantionMinutes;
    }

    public WorkoutType getType() {
        return type;
    }

    public void setType(WorkoutType type) {
        this.type = type;
    }

    public double calories(){
        return durantionMinutes * type.getMetFactor();
    }

    public String toString(){

        return sdf.format(date) + " - " + type + " - " + durantionMinutes + "min - " + calories() + " calories";
    }
}
