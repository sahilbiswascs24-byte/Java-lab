class Car{
    int model;
    String make;
    int speed;

    Car(int model, String make, int speed){
        this.model = model;
        this.make = make;
        this.speed = speed;
    }
    int model(){
        return model;
    }

    String make(){
        return make;
    }

    int speed(){
        return speed;
    }

    void accelerate(){
        speed = speed + 5;
        System.out.println("Current speed after accelerating: ");
    }

    void brake(){
        speed = speed - 5;
        System.out.println("Current speed after braking: ");
    }
}

public class Main {
    public static void main(String[] args){
        Car c1 = new Car (1990, "SUV", 100);
        System.out.println("Car Model: " + c1.model());
        System.out.println("Car Make: " + c1.make());
        System.out.println("Speed: " + c1.speed());
        c1.accelerate();
        System.out.println(c1.speed());
        c1.accelerate();
        System.out.println(c1.speed());
        c1.accelerate();
        System.out.println(c1.speed());
        c1.accelerate();
        System.out.println(c1.speed());
        c1.accelerate();
        System.out.println(c1.speed());

        c1.brake();
        System.out.println(c1.speed());
        c1.brake();
        System.out.println(c1.speed());
        c1.brake();
        System.out.println(c1.speed());
        c1.brake();
        System.out.println(c1.speed());
        c1.brake();
        System.out.println(c1.speed());
    }
}