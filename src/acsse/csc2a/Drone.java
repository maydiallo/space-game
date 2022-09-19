package acsse.csc2a;

/**
 * A class to represent drones 
 * 
 * @author Maimouna Diallo
 * @version P01
 */
public class Drone extends Device
{
	
	private final EDRONE_TYPE	type;
	/**
	 * Create a drone with a unique ID
	 * 
	 * @param id
	 *            The unique ID
	 */
	public Drone(String DEV_ID)
	{
		this.DEV_ID = DEV_ID;
		type = EDRONE_TYPE.GROUND; 
	}
	
	@Override
	/**
	 *Displays information of Drone
	 */
	public void displayInfo()
	{
		System.out.println("Drone Info:");
		System.out.println(DEV_ID+ " " + DEV_TYPE+ " " + DEV_MANUFACTURE_DATE + " "+ DISPOSABLE);
	}

	

}
