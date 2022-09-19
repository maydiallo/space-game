package acsse.csc2a;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import acsse.csc2a.E_DEV_TYPE;

/**
 * A class that manages the sensors and drones through the device
 * 
 * @author Maimouna Dialo
 * @version P03
 */
public class DeviceFileHandler
{	
	
	/**
	 * @param FileToRead
	 * 					The file that is read and validated
	 * @return
	 * 			return a device array after completion
	 * method to @return an array of Devices after validation has occured
	 */
	public static Device[] readDevice (File FileToRead)
	{
		boolean test = false ;
		int index = 0;
		Device[] DeviceArr = new Device[1];
		
		try 
		{
			Scanner FileScanner = null;
			FileScanner = new Scanner(FileToRead);
			while (FileScanner.hasNextLine())
			{ 
				String FileInfo = FileScanner.nextLine();
				index+=1;
				//Matcher that will ensure that the string matches with the pattern with regular expressions
			
				//Checking the drones in file match the regex
					StringTokenizer tabDTokens = new StringTokenizer (FileInfo, "	");
					String DeviceID = tabDTokens.nextToken();
					String DeviceType = tabDTokens.nextToken();
					String DeviceDate = tabDTokens.nextToken();
					String DeviceDisp = tabDTokens.nextToken();
					Device[] device = new Device[index];
					DeviceArr = Arrays.copyOf(device, 1);
					
					for (int i = 1; i <= index; i++)
					{
						if(DeviceType == "DRONE")
						{
							System.out.println(DeviceID);
							Drone[] drone = new Drone[1];
							drone[i].setID(DeviceID);
							drone[i].setType(E_DEV_TYPE.DRONE);
							drone[i].setDate(DeviceDate);
							drone[i].setDisp(Boolean.parseBoolean(DeviceDisp));
							drone[i].displayInfo();
							
						}else if(DeviceType == "SENSOR")
						{
							Sensor[] sensor = new Sensor[1];
							sensor[i].setID(DeviceID);
							sensor[i].setType(E_DEV_TYPE.DRONE);
							sensor[i].setDate(DeviceDate);
							sensor[i].setDisp(Boolean.parseBoolean(DeviceDisp));
							sensor[i].displayInfo();
						}
					}
					//
					
			}				
			
				FileScanner.close();
		}catch(FileNotFoundException fnfe)
		{
			fnfe.printStackTrace();
		}
		// Close file
		
		return DeviceArr;
	}
	
}