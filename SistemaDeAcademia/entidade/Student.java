package entidade;

import entities.Enum.GymPlan;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private String email;
    private GymPlan plan;
    private List<WorkOut> workOuts = new ArrayList<>();

    public Student(String name, String email, GymPlan plan) {
        this.name = name;
        this.email = email;
        this.plan = plan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public GymPlan getPlan() {
        return plan;
    }

    public void setPlan(GymPlan plan) {
        this.plan = plan;
    }

    public List<WorkOut> getWorkouts(){
        return workOuts;
    }

    public void addWorkout(WorkOut workOut){
        workOuts.add(workOut);
    }
}
