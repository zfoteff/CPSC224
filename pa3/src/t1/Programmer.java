/**
 * This program initializes a subclass of Employee, Programmer
 * Each programmer inherits all attributes and methods from Employee, and has its own private attribute hasBusPass
 *
 * @author Zac Foteff
 * @version v1.0 9/23/2019
 * @see Employee
 */

package t1;

public class Programmer extends Employee
{
    //  class attribute: every Programmer is either given a bus pass by the company, or is not given one
    protected boolean hasBusPass;

    //  DVC
    public Programmer()
    {
        //  calls super object DVC
        super();
        this.salary += 20000;
        hasBusPass = false;
    }

    //  EVC
    public Programmer(String paramName, double paramSalary, boolean paramBusPass)
    {
        //  calls super object EVC to set salary and name
        super(paramName, paramSalary);
        hasBusPass = paramBusPass;
    }

    /**
     * Accessor method returns a boolean value indicating whether the employee has a bus pass or not
     *
     * @return boolean true if object has a bus pass, false otherwise
     */
    public boolean hasBusPass()
    {
        return hasBusPass;
    }

    /**
     * Setter method sets whether or not object has a bus pass or not
     *
     * @param hasBusPass boolean that will overwrite old value
     */
    public void setBusPass(boolean hasBusPass)
    {
        this.hasBusPass = hasBusPass;
    }

    /**
     * Method returns a string representation of the Programmer object
     * - Overrides employee toString method and adds information about hasBusPass
     *
     * @return String representation of Programmer object
     */
    @Override
    public String toString()
    {
        return super.toString()+", Bus pass: "+hasBusPass;
    }

    /**
     * Method overwrites abstract method reportSalary() and displays information about the specific Programmer salary
     * and perks
     */
    @Override
    public void reportSalary()
    {
        System.out.println("My name is "+name+". " +
                           "I am a programmer and I make $"+decimalFormat.format(salary)+" a year. " +
                           "Do I have a bus pass? "+hasBusPass);
    }
}
