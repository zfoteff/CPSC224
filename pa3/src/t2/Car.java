/**
 * This program initializes a class object Car that implements the drivable and comparable interfaces
 *
 * @author Zac Foteff
 * @version v1.0 9/23/2019
 * @see Drivable
 */

package t2;

public class Car extends Object implements Drivable, Comparable<Car>
{
    private String make;
    private String model;
    private int year;
    private int odometerReading;

    /**
     * Default Value Constructor for Car objects
     */
    public Car()
    {
        make = "Suzuki";
        model = "Grand Vitara";
        year = 1999;
        odometerReading = 260570;
    }

    /**
     * Explicit Value Constructor for Car objects
     *
     * @param paramMake String user defined make of the Car object
     * @param paramModel String user defined model of the Car object
     * @param paramYear int user defined year of make of the Car object
     * @param paramOdometer int user defined odometer value for Car object
     */
    public Car(String paramMake, String paramModel, int paramYear, int paramOdometer)
    {
        make = paramMake;
        model = paramModel;
        year = paramYear;
        odometerReading = paramOdometer;
    }

    /**
     * Accessor function returns a String value representing the make of the Car object
     *
     * @return String value of the Car make
     */
    public String getMake()
    {
        return make;
    }


    /**
     * Setter function sets the make of the car
     *
     * @param make String that will overwrite old value
     */
    public void setMake(String make)
    {
        this.make = make;
    }


    /**
     * Accessor function returns a String value representing the model of the Car object
     *
     * @return String value of the Car make
     */
    public String getModel()
    {
        return model;
    }


    /**
     * Setter function sets the make of the car
     *
     * @param model String that will overwrite old value
     */
    public void setModel(String model)
    {
        this.model = model;
    }


    /**
     * Accessor function returns an int value representing the year of production of the Car object
     *
     * @return int value of the Car year
     */
    public int getYear()
    {
        return this.year;
    }


    /**
     * Setter function sets the make of the car
     *
     * @param year int that will overwrite old value
     */
    public void setYear(int year)
    {
        this.year = year;
    }


    /**
     * Accessor function returns an int value representing the odometer of the Car object
     *
     * @return int value of the Car odometer reading
     */
    public int getOdometerReading()
    {
        return odometerReading;
    }


    /**
     * Setter function sets the make of the car
     *
     * @param odometerReading int that will overwrite old value
     */
    public void setOdometerReading(int odometerReading)
    {
        this.odometerReading = odometerReading;
    }


    /**
     * Method overrides abstract method milesDriven. Odometer reading is increased by user specifed amount
     *
     * @param milesDriven miles that are driven by the car object
     */
    @Override
    public void drive(int milesDriven)
    {
        System.out.println("Driving "+make+" "+model+"...");
        odometerReading += milesDriven;
    }


    /**
     * Method overwrites toString method of the Object class. Returns a string representation the car object
     *
     * @return String representation of Car object
     */
    @Override
    public String toString()
    {
        return ""+year+" "+make+" "+model+" with "+odometerReading+" miles";
    }


    /**
     * Method overrides Comparable interface method
     *
     * @param c
     * @return int. -1 if left hand object is less than right hand object, 1 if left hand object is greater than
     * right hand object, 0 if the objects are equal
     */
    @Override
    public int compareTo(Car c)
    {
        if (this.year < c.year)
            return -1;

        if (this.year > c.year)
            return 1;

        if (this.year == c.year)
        {
            if (this.odometerReading < c.odometerReading)
                return -1;

            if (this.odometerReading > c.odometerReading)
                return 0;
        }

        //  If none of the other catches trigger, then that means that both cars have equal odometer readings and years
        return 0;
    }
}
