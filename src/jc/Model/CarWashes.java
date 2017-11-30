package jc.Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CarWashes implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public List<City> cities;
	
	public CarWashes() throws FileNotFoundException, IOException
	{
		try(ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(new File("Cities.ser"))))
		{
			try {
				cities = (List<City>)(objIn.readObject());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
