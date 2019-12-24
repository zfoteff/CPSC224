/**
 * This program initializes a subclass of Employee, Accountant
 * Each programmer inherits all attributes and methods from Employee, and has its own private attribute parkingAllowance
 *
 * @author Zac Foteff
 * @version v1.0 9/23/2019
 * @see Employee
 */

package t1;

public class Accountant extends Employee
{
    //  class attribute: every accountant is given a parkingAllowance
    protected double parkingAllowance;

    /**
     * Default Value Constructor for Accountant object
     */
    public Accountant()
    {
        //  calls super class DVC
        super();
        this.parkingAllowance = 0.0;
    }


    /**
     * Explicit Value Constructor for an Accountant object
     *
     * @param paramName user defined name for Accountant object
     * @param paramSalary user defined salary for Accountant object
     * @param paramAllowance user defined parking allowance for Accountant object
     */
    public Accountant(String paramName, double paramSalary, double paramAllowance)
    {
        //  calls super class EVC
        super(paramName, paramSalary);
        this.parkingAllowance = paramAllowance;
    }


    /**
     * Accessor method returns a double value representing the amount of money the Accountant object has in their
     * parking allowance
     *
     * @return double dollar value of parking allowance
     */
    public double getParkingAllowance()
    {
        return parkingAllowance;
    }


    /**
     * Setter method sets how much money the Accounting object has in their parking allowance
     *
     * @param parkingAllowance double that will overwrite old balance
     */
    public void setParkingAllowance(double parkingAllowance)
    {
        this.parkingAllowance = parkingAllowance;
    }


    /**
     * Method returns a string representation of the Accountant object
     *
     * @return String representation of Accountant object
     */
    @Override
    public String toString()
    {
        return super.toString()+" Parking allowance: $"+parkingAllowance;
    }


    /**
     * Method overwrites abstract method reportSalary() and displays information about the specific Accountant salary
     * and perks
     */
    @Override
    public void reportSalary()
    {
        System.out.println("My name is "+name+". " +
                           "I am an accountant and I make $"+decimalFormat.format(salary)+" a year. " +
                           "I have $"+parkingAllowance+" in parking allowance");
    }
}
