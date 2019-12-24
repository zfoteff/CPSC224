/**
 * This program is a driver file for the Employee class and all its subclasses
 *
 * CPSC 224-01, Fall 2019
 * Programming Assignment #3
 * Sources:
 *
 * @author Zac Foteff
 * @version v1.0 9/23/2019
 * @see No Borrowed Code
 */

package t1;

public class EmployeeDriver
{
   public static void main(String[] args)
   {
       Employee[] employeeList = new Employee[8];
       employeeList[0] = new Programmer("Zac Foteff", 500000, true);
       employeeList[1] = new Accountant("Jerry Smith", 30000, 3.0);
       employeeList[2] = new Lawyer("Jimmy McGill", 100000, 34);
       employeeList[3] = new Programmer();
       employeeList[4] = new Accountant("OJ Simpson", 75000, 75.0);
       employeeList[5] = new Lawyer("Ace Ventura", 275000, 145);
       employeeList[6] = new Lawyer();
       employeeList[7] = new Accountant();

       for (int i = 0; i < employeeList.length; ++i)
       {
           System.out.println(employeeList[i]);
           employeeList[i].reportSalary();
           System.out.println("**************************");
       }

       System.out.println("**************************");
   }
}
