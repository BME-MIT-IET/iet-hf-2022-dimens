package asteroidgame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

/**
 * Represents a collection of materials.
 */

public class Inventory {
	/** The number of materials contained **/
	private int numOfMaterials = 0;
	/** The maximum number of materials can be contained **/
	private static int maxNumofMaterials = 10;

	/** The contained materials **/
	private HashMap<Integer, ArrayList<Material>> containedMaterials = new HashMap<>();

	/**
	 * Adds the given material to the inventory.
	 * 
	 * @param material The material to add.
	 */
	public void addMaterial(Material material) {
		if (!containedMaterials.containsKey(material.getinventoryID())) {
			containedMaterials.put(material.getinventoryID(), new ArrayList<>());
		}
		containedMaterials.get(material.getinventoryID()).add(material);
		numOfMaterials++;
	}

	/**
	 * Removes 1 material from the given argument's type.
	 * 
	 * @param material Material of the type we want to remove.
	 */
	public void removeMaterial(Material material) {
		containedMaterials.get(material.getinventoryID()).remove(0);
		numOfMaterials--;
	}

	/** Getter for maxNumofMaterials **/
	public static int getMaxNumofMaterials() {
		return maxNumofMaterials;
	}

	/** Getter for numOfMaterials **/
	public int getNumOfMaterials() {
		return numOfMaterials;
	}

	/**
	 * @return Returns an ArrayList which contains all the materials from the inventory
	 * **/
	public ArrayList<Material> materialsList()
	{
		ArrayList<Material> resultmaterials = new ArrayList<>();
		Collection<ArrayList<Material>> materials = containedMaterials.values();
		for (ArrayList<Material> eachlist : materials) {
			if (eachlist.isEmpty())
				continue;
			for(Material m: eachlist)
				resultmaterials.add(m);
		}
		return resultmaterials;
	}
	

	/**
	 * Check whether the inventory contains the specified amount of the specified
	 * material type.
	 * 
	 * @param material Material of the type we want to check
	 * @param amount   The amount we want to check
	 * @return Returns true if and only if the inventory contains the specified
	 *         amount of the specified type.
	 */
	public boolean hasMaterial(Material material, int amount) {
		if (!containedMaterials.containsKey(material.getinventoryID()))
			return false;
		return (containedMaterials.get(material.getinventoryID()).size() >= amount);
	}

	/**
	 * Check whether the inventory contains at least 1 of the specified material
	 * type.
	 * 
	 * @param material Material of the type we want to check
	 * @return Returns true if and only if the inventory contains 1 or more of the
	 *         specified type.
	 */
	public boolean hasMaterial(Material material) {
		return hasMaterial(material, 1);
	}

	/***
	 * Counts the contained materials and returns the result in string format.
	 * 
	 * @return Returns a string which is formatted as: �C:number of contained Coals
	 *         I: number of contained Irons W:number of contained WaterIces U:number
	 *         of contained Urans�
	 */
	public String list() {
		int nI = 0;
		int nC = 0;
		int nW = 0;
		int nU = 0;

		Collection<ArrayList<Material>> materials = containedMaterials.values();
		for (ArrayList<Material> eachlist : materials) {
			if (eachlist.isEmpty())
				continue;

			switch (eachlist.get(0).getinventoryID()) {
			case 0:
				nC = eachlist.size();
				break;
			case 1:
				nI = eachlist.size();
				break;
			case 2:
				nW = eachlist.size();
				break;
			case 3:
				nU = eachlist.size();
				break;
			default:
				break;
			}
		}
		return "C:" + nC + ", I:" + nI + ", W:" + nW + ", U:" + nU;
	}

}
