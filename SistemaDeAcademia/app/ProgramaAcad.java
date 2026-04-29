package app;

import entidade.Gym;
import entidade.Student;
import entidade.WorkOut;
import entities.Enum.GymPlan;
import entities.Enum.WorkoutType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ProgramaAcad {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/YY/mmmm");


        System.out.println("ENTER THE NAME GYM: ");
        String gymName = sc.nextLine();
        Gym gym = new Gym(gymName);


        System.out.println("HOW MANY STUDENTS? ");
        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            System.out.println("\nStudent#" + i + " data:");
            sc.nextLine();
            System.out.println("NAME: ");
            String name = sc.nextLine();
            System.out.println("EMAIL: ");
            String email = sc.next();
            System.out.println("Plan (BASIC/ STANDART/ PREMIUM): ");
            GymPlan plan = GymPlan.valueOf(sc.next());

            Student student = new Student(name, email, plan);

            System.out.println("HOW MANY WORKOUTS? ");
            int w = sc.nextInt();

            for(int j = 0; j <= w; j++){
                System.out.println("ENTER WORKOUT #" + j + " data: ");
                System.out.println("DATE (DD/MM/YYYY): ");
                Date date =  sdf.parse(sc.next());
                System.out.println("Duration(minutes): ");
                int duration = sc.nextInt();
                System.out.println("type(CARDIO/WEIGHT_TRAINING/YOGA/CROSSFIT); ");
                WorkoutType type = WorkoutType.valueOf(sc.next());
                student.addWorkout(new WorkOut(date,duration, type));
            }
            gym.addStudent(student);
        }

        System.out.println("\nGYM SUMMARY - " + gym.getName());
        System.out.println("TOTAL STUDENTS: " + gym.totStudents());
        System.out.printf("TOTAL REVENUE: $%.2f%n", gym.totRevenue());

        for(GymPlan plan: GymPlan.values()){
            List<Student> list = gym.listByPlan(plan);
            if(!list.isEmpty()){
                System.out.println("\n" + plan + " students:");
                for(Student s: list){
                    System.out.println(s.getName() + " - " + s.getEmail());
                    for(WorkOut w: s.getWorkouts()){
                        System.out.println(" " + w);
                    }
                }
            }
        }

        sc.close();
    }
}
