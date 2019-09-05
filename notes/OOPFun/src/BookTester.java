public class BookTester
{
    public static void main(String[] args)
    {
        // a tester (AKA driver) is a program that exercises some code
        // test our book class .. run constructors + methods

        Book bookOne = new Book();      // initializes book with default values
        System.out.println(bookOne.toString());    // prints referance for Book object

        //  WHENEVER A STRING REPRESENTATION OF AN OBJECT IS NEEDED, .toString() IS IMPLICITLY CALLED
        //      - Object is superclass of every class

        Book bookTwo = new Book("Enders Game", "Orson Scott Card", 500);
        System.out.println(bookTwo.toString());

        bookOne.setTitle("Harry Potter and the Half-Blood Prince");
        bookOne.setAuthor("J.K. Rowling");
    }
}
