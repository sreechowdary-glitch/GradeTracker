import java.util.ArrayList;
import java.util.Scanner;

// Helper class (Keep this outside the Main class)
class Student {
    String name;
    double grade;

    Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}

// Rename this class to 'Main' for the online compiler
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>();
        
        System.out.println("Welcome to the Classroom Grade Manager!");
        System.out.println("---------------------------------------");

        while (true) {
            System.out.print("Enter student name (or type 'done' to finish): ");
            String name = input.nextLine();
            
            if (name.equalsIgnoreCase("done")) break;

            System.out.print("Enter " + name + "'s grade: ");
            try {
                double grade = Double.parseDouble(input.nextLine());
                if (grade >= 0 && grade <= 100) {
                    studentList.add(new Student(name, grade));
                } else {
                    System.out.println("Grades should be 0-100.");
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
            }
        }

        if (!studentList.isEmpty()) {
            displaySummary(studentList);
        }
        input.close();
    }

    private static void displaySummary(ArrayList<Student> students) {
        double totalPoints = 0;
        Student top = students.get(0);
        Student low = students.get(0);

        for (Student s : students) {
            totalPoints += s.grade;
            if (s.grade > top.grade) top = s;
            if (s.grade < low.grade) low = s;
        }

        System.out.println("\n--- Class Summary ---");
        System.out.printf("Average: %.2f%%\n", (totalPoints / students.size()));
        System.out.println("Highest: " + top.name + " (" + top.grade + ")");
        System.out.println("Lowest: " + low.name + " (" + low.grade + ")");
    }
}
