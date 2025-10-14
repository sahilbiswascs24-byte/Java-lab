import java.util.Scanner;

class quadratic
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        float a,b,c,d;
        double r1,r2;
        System.out.println("Enter coefficient of a:");
        a= s.nextFloat();
        System.out.println("Enter coefficient of b: ");
        b= s.nextFloat();
        System.out.println("Enter coefficient of c:");
        c= s.nextFloat();
        d= b*b - 4*a*c;
        if (a==0)
        {
            System.out.println("Not a quadratic equation");

        }
        else {

          if (d==0) {
             r1= (-b)/(2*a);
             r2=r1;
            System.out.println("Roots are real and equal:"+r1);
          }
          else if (d>0) {
             r1 = ((-b) + (Math.sqrt(d)))/(double)(2*a);
             r2 = ((-b) - (Math.sqrt(d)))/(double)(2*a);
            System.out.println("Roots are real and distinct R1:"+r1+ "and R2:"+r2);
          }
          else {
             System.out.println("Roots are imaginary");
             r1 = (-b)/(2*a);
             r2 = Math.sqrt(-d)/(2*a);
             System.out.println("Root 1:"+r1+"+"+r2+"i");
             System.out.println("Root 2:"+r1+"-"+r2+"i");
          }
        }
    System.out.println("USN:1BF24CS262 Name:Sahil Biswas");
     s.close();


    }
}
