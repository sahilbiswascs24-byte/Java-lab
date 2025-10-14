import java.util.Scanner;

class Student {
    String usn;
    String name;
    int[] credits;
    int[] marks;
    double sgpa;

    Student(int n) {
        credits = new int[n];
        marks = new int[n];
    }

    void acceptDetails(Scanner sc, int n) {
        System.out.print("Enter USN: ");
        usn = sc.nextLine();
        System.out.print("Enter Name: ");
        name = sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter credits for subject " + (i + 1) + ": ");
            credits[i] = sc.nextInt();
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }
        sc.nextLine(); 
    }

    void calculateSGPA(int n) {
        int totalCredits = 0;
        int totalPoints = 0;

        for (int i = 0; i < n; i++) {
            int gradePoint;

            if (marks[i] >= 90)
                gradePoint = 10;
            else if (marks[i] >= 80)
                gradePoint = 9;
            else if (marks[i] >= 70)
                gradePoint = 8;
            else if (marks[i] >= 60)
                gradePoint = 7;
            else if (marks[i] >= 50)
                gradePoint = 6;
            else if (marks[i] >= 40)
                gradePoint = 5;
            else
                gradePoint = 0;

            totalPoints += gradePoint * credits[i];
            totalCredits += credits[i];
        }

        sgpa = (double) totalPoints / totalCredits;
    }

    
    void displayDetails() {
        System.out.println("\n--- Student Details ---");
        System.out.println("USN: " + usn);
        System.out.println("Name: " + name);
        System.out.println("SGPA: " + String.format("%.2f", sgpa));
    }
}

public class SGPA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of subjects: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        Student s1 = new Student(n);
        Student s2 = new Student(n);

        System.out.println("\nEnter details for Student 1:");
        s1.acceptDetails(sc, n);
        s1.calculateSGPA(n);

        System.out.println("\nEnter details for Student 2:");
        s2.acceptDetails(sc, n);
        s2.calculateSGPA(n);

        s1.displayDetails();
        s2.displayDetails();

        sc.close();
    }
}
