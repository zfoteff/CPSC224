import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.util.Arrays;

public class Main
{
    // Every public type in java has to be in its own file
    // there are 4 access modifiers
    // 1. public
    // 2. private
    // 3. protected
    // 4. package-protected
    public static void main(String[] args)
    {
        // static means class level (don't need object to invoke main())
        // static means no 'this' reference

        // String[] args stores command line arguments
        // When program is run commands can be passed in the command line

        System.out.println(args.length);

        // VARIABLES: either primitives or reference
        //8 primitives
        //  - 1. Char
        char myChar = 'a';
        // Can concatenate strings with primitives
        System.out.println("myChar: " + myChar);
        //  - 2. Int
        //  - 3. Double (double precision floating point number)
        double myDouble = Math.PI;
        System.out.println("myDouble: " + myDouble);
        // use DecimalFormat to round decimals to two places (need to import package to do this)
        DecimalFormat df = new DecimalFormat("#0.00"); // creates reference variables
        System.out.println("DecimalFormat: " + df.format(myDouble));
        //  - 4. Boolean (0 = false, otherwise = true, true and false keywords exist)
        boolean myBool = true;
        System.out.println("myBool: " + myBool);
        //  - 5. Short 6. long 7. float 8. byte

        // STRINGS
        String myString = "hello";
        System.out.println("myString: " + myString);

        // task 1: declare two variables: one for first name, one for last name
        // display <firstname> <lastname> has <#> of characters in it
        String s1 = "Zachary";
        String s2 = "Foteff";
        System.out.println(s1+ " " +s2+ " has " +(s1.length()+s2.length())+ " characters in it");
        //Some String methods: trim(), split(char delimiter), charAt(int index), toCharArray()

        // CONSTANTS
        // Exact same as c++ use 'final' keyword
        // use MACRO_CASE
        final int SIZE = 10;

        // ARRAYS
        // declare and initialize at the same time
        int[] myInts = {6, 10, 9, 8, 7, 2, 1};
        System.out.println(myInts); // returns memory address of the array object
        // every class in Java inherits directly or indirectly from Object
        // Object has method .toString() that returns a string hashcode
        // needs to be overridden with Array object method .toString() which gives the desired output
        System.out.println("myInts: " + Arrays.toString(myInts));

        // task 2 declare, then initialize an array of 4 of your friends names
        // print out the array, size, and the last element
        final int NUM_FRIENDS = 4;
        String[] friends = new String[NUM_FRIENDS];
        friends[0] = "Jackson";
        friends[1] = "Brendan";
        friends[2] = "Ian";
        friends[3] = "Lauren";
        System.out.println("My friends: " + Arrays.toString(friends));
        System.out.println("Size: " + friends.length);
        System.out.println("Last element: " + friends[friends.length - 1]);

        // CONTROL FLOW
        //if/else/elseif/switch statements are all the same as C++
        //for/while/do-while loops same as C++
    }
}
