package acsse.csc2a;


/**
 * A class to represent all devices.
 * 
 * @author Maimouna Dialo
 * @version P03
 */
public abstract class Device
{
	protected  String		DEV_ID;
	protected  E_DEV_TYPE	DEV_TYPE;
	protected String				DEV_MANUFACTURE_DATE;
	protected boolean				DISPOSABLE;

	//Mutators
	public abstract void displayInfo();
	
	public void setID(String DEV_ID)
	{
		this.DEV_ID = DEV_ID;
	}
	public void setType(E_DEV_TYPE DEV_TYPE)
	{
		this.DEV_TYPE = DEV_TYPE;
	}
	public void setDate(String DEV_MANUFACTURE_DATE)
	{
		this.DEV_MANUFACTURE_DATE = DEV_MANUFACTURE_DATE;
	}
	public void setDisp(boolean DISPOSABLE)
	{
		this.DISPOSABLE = DISPOSABLE;
	}
	
	//Accessors
	public String getDate()
	{
		return this.DEV_MANUFACTURE_DATE;
	}
	
	public boolean getDisp()
	{
		return this.DISPOSABLE;
	}
	
	public E_DEV_TYPE getType()
	{
		return this.DEV_TYPE;
	}

	/**
	 * @return The unique ID of the device 
	 */
	public String getID()
	{
		return this.DEV_ID;
	}

}
