/**
 * This program is a driver file for the Car class
 *
 * CPSC 224-01, Fall 2019
 * Programming Assignment #3
 * Sources:
 *
 * @author Zac Foteff
 * @version v1.0 9/23/2019
 * @see No Borrowed Code
 */

package t2;

import java.util.*;

public class CarDriver
{
    public static void printList(Car[] c)
    {
        for (int i = 0; i < c.length; ++i)
        {
            System.out.println(c[i]);
            System.out.println("******************************************");
        }
    }

    public static void main(String[] args)
    {
        Car[] cars = new Car[10];
        cars[0] = new Car();
        cars[1] = new Car("Honda", "Accord", 1996, 250000);
        cars[2] = new Car("Chevy", "Tahoe", 2007, 206080);
        cars[3] = new Car("Toyota", "Camry", 2010, 150467);
        cars[4] = new Car("Subaru", "Impreza", 2005, 18000);
        cars[5] = new Car("Honda", "Prelude", 1980, 174000);
        cars[6] = new Car("Pontiac", "Firebird", 1968, 26780);
        cars[7] = new Car("Honda", "Civic", 1991, 187900);
        cars[8] = new Car("Cadillac", "El Camino", 1976, 123456);
        cars[9] = new Car("Mazda", "CX9", 2019, 12300);


        printList(cars);
        Arrays.sort(cars);
        System.out.println("\n\nSorted list -----\n\n");
        printList(cars);

        for (int i = 0; i < cars.length; i += 2)
        {
            cars[(int)(Math.random() * 9)+0].drive((int)(Math.random() * 1500) + 100);
        }

        System.out.println("\n\n");
        printList(cars);
    }
}
