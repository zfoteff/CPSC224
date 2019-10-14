import java.util.InputMismatchException;
import java.util.Scanner;

public class t1
{
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        int userNum = 0;
        boolean valid;
        System.out.println("Enter an integer: ");

        do
        {
            valid = true;
            try{
                userNum = kb.nextInt();
            } catch(InputMismatchException e){
                valid = false;
                System.out.println("Not an integer try again");
            } finally {
                kb.nextLine(); // refresh buffer
            }
        } while (!valid);




    }
}
