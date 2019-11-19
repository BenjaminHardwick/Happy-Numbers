/* Happy Numbers by Benjamin Hardwick
* Happy number, starting with any positive integer, replace the number by the sum of squares of it's digits, and then repeat the prces until the number equals 1. Or it loops endlessly
* in a cycle that does not include 1.
* An unhappy number is a number that is not happy.
* The first few unhappy numbers are: 2, 3, 4, 5, 6, 8, 9, 11, 12, 14, 15, 16, 17, 18, 20.
* Happy Number's are: 1, 7, 10, 13, 19, 23, 28, 31, 32, 44, 49, 68, 70, 79, 82, 86, 91, 94, 97, 100
*
*/
import java.util.Scanner;

public class HappyNumbers{
    

    // Method to return the actual sum of the square digital 'inputNumber'

    static int SquareNum(int inputNumber){
        int squareSum = 0;
        while(inputNumber != 0)
        {
            squareSum += (inputNumber % 10) * (inputNumber % 10);
            inputNumber /= 10;
        }
        return squareSum;
    }

    static boolean isHappy(int inputNumber)
    {
        int slow, fast;
        slow = fast = inputNumber;
        do{
            // This moves the slow number by a single iteration.
            slow = SquareNum(slow);
            
            fast= SquareNum(SquareNum(fast));

        }

        while(slow != fast);
        // if the numbers both meet at 1, then return true.
        return(slow == 1);
    }
    public static void main(String [] args){
        
        
        Scanner userNumber = new Scanner(System.in);
        int inputNumber;
        do
        {
            System.out.println("Insert your positive integer: ");
            while(!userNumber.hasNextInt())
            {
                System.out.println("Please insert a positive integer, elsewise it will not work: ");
                userNumber.next();
            
            
            }  
        inputNumber = userNumber.nextInt();
        }while(inputNumber <= 0);
        System.out.println("Positive intgers:");
            //int inputNumber = 13;
            if(isHappy(inputNumber))
            {
               System.out.println(inputNumber + " is a happy number.");
            }
            else{
                System.out.println(inputNumber + " is not a happy number.");
            }
        }

    }

