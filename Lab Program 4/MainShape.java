import java.util.Scanner;

class InputScanner {
    Scanner sc = new Scanner(System.in);

    int getInt(String msg) {
        System.out.print(msg);
        return sc.nextInt();
    }

    double getDouble(String msg) {
        System.out.print(msg);
        return sc.nextDouble();
    }
}

abstract class Shape extends InputScanner {
    int a, b;
    abstract void printArea();  
}

class Rectangle extends Shape {
    void input() {
        a = getInt("Enter length: ");
        b = getInt("Enter breadth: ");
    }

    void printArea() {
        System.out.println("Area of Rectangle = " + (a * b));
    }
}

class Triangle extends Shape {
    void input() {
        a = getInt("Enter base: ");
        b = getInt("Enter height: ");
    }

    void printArea() {
        System.out.println("Area of Triangle = " + (0.5 * a * b));
    }
}

class Circle extends Shape {
    void input() {
        a = getInt("Enter radius: ");
    }

    void printArea() {
        System.out.println("Area of Circle = " + (3.1416 * a * a));
    }
}

public class MainShape {
    public static void main(String[] args) {
        System.out.println("Enter the dimensions of rectangle:");
        Rectangle r = new Rectangle();
        r.input();
        r.printArea();

        System.out.println("\nEnter the dimensions of triangle:");
        Triangle t = new Triangle();
        t.input();
        t.printArea();

        System.out.println("\nEnter the dimension of circle:");
        Circle c = new Circle();
        c.input();
        c.printArea();
    }
}
