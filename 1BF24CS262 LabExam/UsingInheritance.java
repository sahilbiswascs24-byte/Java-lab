class Car{
    int model;
    String make;
    int speed;
}

class SUV extends Car{
    SUV(int model, String make, int speed){
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

public class UsingInheritance {
    public static void main(String[] args){
        SUV s1 = new SUV (2020, "Toyota", 120);
        System.out.println("Car Model: " + s1.model());
        System.out.println("Car Make: " + s1.make());
        System.out.println("Speed: " + s1.speed());
        s1.accelerate();
        System.out.println(s1.speed());
        s1.accelerate();
        System.out.println(s1.speed());
        s1.accelerate();
        System.out.println(s1.speed());
        s1.accelerate();
        System.out.println(s1.speed());
        s1.accelerate();
        System.out.println(s1.speed());

        s1.brake();
        System.out.println(s1.speed());
        s1.brake();
        System.out.println(s1.speed());
        s1.brake();
        System.out.println(s1.speed());
        s1.brake();
        System.out.println(s1.speed());
        s1.brake();
        System.out.println(s1.speed());
    }
}
