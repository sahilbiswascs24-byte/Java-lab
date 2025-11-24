import java.util.*;

class WrongAge extends Exception {
    WrongAge(String message) {
        super(message);
    }
}

class InputScanner {
    Scanner sc;

    InputScanner() {
        sc = new Scanner(System.in);
    }

    int getInt() {
        return sc.nextInt();
    }
}

class Father extends InputScanner {
    int fatherAge;

    Father() throws WrongAge {
        System.out.print("Enter Father's Age: ");
        fatherAge = getInt();

        if (fatherAge < 0) {
            throw new WrongAge("Age cannot be negative");
        }
    }

    void display() {
        System.out.println("Father's Age: " + fatherAge);
    }
}


class Son extends Father {
    int sonAge;

    Son() throws WrongAge {
        super(); 

        System.out.print("Enter Son's Age: ");
        sonAge = getInt();

        if (sonAge < 0) {
            throw new WrongAge("Age cannot be negative");
        }

        if (sonAge >= fatherAge) {
            throw new WrongAge("Son's age cannot be greater than or equal to father's age");
        }
    }

    void display() {
        super.display(); 
        System.out.println("Son's Age: " + sonAge);
    }
}


public class Main {
    public static void main(String[] args) {
        try {
            Son s = new Son();
            s.display();

        } catch (WrongAge e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
