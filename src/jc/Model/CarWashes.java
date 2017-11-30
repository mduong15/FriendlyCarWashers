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
	
	/*** Used to create serial objects" ***/
//	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException
//	{
//		CarWashes washes = new CarWashes();
//		System.out.println(washes);
//		
//		for (City c: washes.cities)
//		{
//			System.out.println(c.name);
//		}
//		
//		
//		
//		
//		
//		
////		ArrayList<City> cits = new ArrayList<>();
////		ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("CostaMesa.ser")));
////		cits.add(new City("Costa Mesa", (ArrayList<CarWash>)(in.readObject())));
////		
////		
////		in = new ObjectInputStream(new FileInputStream(new File("GardenGrove.ser")));
////		cits.add(new City("Garden Grove", (ArrayList<CarWash>)(in.readObject())));
////		
////		in = new ObjectInputStream(new FileInputStream(new File("Westminster.ser")));
////		cits.add(new City("Westminster", (ArrayList<CarWash>)(in.readObject())));
////		
////		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File ("Cities.ser")));
////		out.writeObject(cits);
//	}
}
