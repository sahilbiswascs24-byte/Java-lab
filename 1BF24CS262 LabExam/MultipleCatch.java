

public class MultipleCatch {
    public static void main(String[] args) {
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[5]);

            int a = 10;
            int b = 0;
            System.out.println(a/b);

            
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index is out of bounds!");
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!");
        } 
        
        
        
            

        
    }
    
}
