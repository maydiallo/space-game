package acsse.csc2a;

/**
 * A class to represent the sensors 
 * 
 * @author Maimouna Diallo
 * @version P01
 */
public class Sensor extends Device
{
	private double	orientation;
	
	/**
	 * Create a sensor with a unique ID
	 * 
	 * @param id
	 *            The unique ID
	 */
	public Sensor(String DEV_ID)
	{
		this.DEV_ID = DEV_ID;
		orientation = 0.0;
	}
	
	@Override
	/**
	 *Displays information of Sensor
	 */
	public void displayInfo()
	{
		System.out.println("Sensor Info:");
		System.out.println(DEV_ID+ " " + DEV_TYPE+ " " + DEV_MANUFACTURE_DATE + " "+ DISPOSABLE);
	}
}
