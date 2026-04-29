package entidade;

import entities.Enum.GymPlan;

import java.util.ArrayList;
import java.util.List;

public class Gym {

    private String name;
    private List<Student> students = new ArrayList<>();

    public Gym(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public Double totRevenue(){
        double sum = 0.0;
        for(Student s: students){
            sum += s.getPlan().getMonthlyFree();
        }
        return sum;
    }

    public List<Student> listByPlan(GymPlan plan){
        List<Student> result = new ArrayList<>();
        for(Student s: students){
            if(s.getPlan() == plan){
                result.add(s);
            }
        }
        return result;
    }

    public int totStudents(){
        return students.size();
    }
}
