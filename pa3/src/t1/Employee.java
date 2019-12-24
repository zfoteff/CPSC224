/**
 * This file initializes the Employee superclass and methods
 * Each employee object has a name and a salary, as well as an abstract method reportSalary()
 *
 * @author Zac Foteff
 * @version v1.0 9/23/2019
 * @see No Borrowed Code
 */

package t1;

import java.text.DecimalFormat;

public abstract class Employee extends Object
{
    protected final String pattern = "###,###.##";
    protected DecimalFormat decimalFormat = new DecimalFormat(pattern);

    protected String name;
    protected double salary;
    //  a concrete baseSalary that will be used by subclasses as a basis for pay structure
    private final double baseSalary = 40000;


    /**
     * Default value constructor for Employee object
     */
    public Employee()
    {
        this.name = "John Johnson";
        this.salary = baseSalary;
    }


    /**
     * Explicit Value Constructor for Employee object
     *
     * @param paramName String user defined name for Employee object
     * @param paramSalary double user defined salary for Employee object
     */
    public Employee(String paramName, double paramSalary)
    {
        this.name = paramName;
        this.salary = paramSalary;
    }


    /**
     * Accessor method returns the name of the employee object
     *
     * @return String representation of employee name
     */
    public String getName()
    {
        return name;
    }


    /**
     * Setter method sets the name of the employee object
     *
     * @param name String that will overwrite old name
     */
    public void setName(String name)
    {
        this.name = name;
    }


    /**
     * Accessor method returns a double of the employee object's salary
     *
     * @return double representation of employee salary
     */
    public double getSalary()
    {
        return baseSalary;
    }


    /**
     * Setter method sets the salary of the employee object
     *
     * @param paramSalary double that will overwrite old salary
     */
    public void setSalary(double paramSalary)
    {
        this.salary = paramSalary;
    }


    /**
     * Method returns a string representation of the employee object
     *
     * @return String representation of employee object
     */
    public String toString()
    {
        return this.name + ", Salary: $ "+decimalFormat.format(this.salary);
    }


    /**
     * Abstract method will be overwritten by subclasses to return specific employee salary and perks
     */
    public abstract void reportSalary();
}
