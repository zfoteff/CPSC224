/**
 * This program initializes a subclass of Employee, Lawyer
 * Each lawyer inherits all attributes and methods from Employee, and has its own private attribute stockOptions
 *
 * @author Zac Foteff
 * @version v1.0 9/23/2019
 * @see Employee
 */

package t1;

public class Lawyer extends Employee
{
    //  class attribute: every Lawyer is given stockOptions
    protected int stockOptions;

    //  DVC
    public Lawyer()
    {
        super();
        this.salary += 30000;
        stockOptions = 0;
    }

    //  EVC
    public Lawyer(String paramName, double paramSalary, int paramStockOptions)
    {
        super(paramName, paramSalary);
        stockOptions = paramStockOptions;
    }

    /**
     * Accessor method returns int of how many stock options the Lawyer object holds
     *
     * @return int number of stock options held by Lawyer object
     */
    public int getStockOptions()
    {
        return stockOptions;
    }

    /**
     * Setter method sets the number of stock options the Lawyer object has
     *
     * @param stockOptions int that will overwrite old number of holdings
     */
    public void setStockOptions(int stockOptions)
    {
        this.stockOptions = stockOptions;
    }

    /**
     * Method returns a string representation of the Lawyer object
     * - Overrides employee toString method and adds information about number of stockOptions
     *
     * @return
     */
    @Override
    public String toString()
    {
        return super.toString() + ", Stock Options Held: " + stockOptions;
    }

    /**
     * Method overwrites abstract method reportSalary() and displays information about the specific Accountant salary
     * and perks
     */
    @Override
    public void reportSalary()
    {
        System.out.println("My name is "+name+". " +
                           "I am a lawyer and I make $"+decimalFormat.format(salary)+" a year." +
                           "I have "+stockOptions+" number of stock options");
    }
}
