package co.edu.eafit.jsrules.interfaces;

import co.edu.eafit.jsrules.property.Property;
import co.edu.eafit.jsrules.servicelocator.Service;

/**
 * This class defines the services for getting and saving properties in to the component.
 * The constants for properties are defined in PropertiesConstants.java
 * The script generation process reads the properties in order to customize the javascript result. 
 * @author Sebastian Velez
 * @author Julian Ortega
 *
 */
public interface IProperty extends Service {


	/**
	 * This method saves a property in to the database.
	 * Preconditions: 
	 * 1. The property to save is not null.
	 * 2. The property key and the property value are allowed values. (Defined in PropertyConstants class)
	 * Postconditions: 
	 * 1. The value of the property is updated.
	 * 2. When generating the script, the new value of the property is used. 
	 * @param p Property to update/save.
	 * @throws Exception in case of error connecting to the database.
	 */
	public void saveProperty(Property p) throws Exception;
	
	/**
	 * Gets the property with the given key.
	 * Preconditions: 
	 * 1. The key is valid and it is defined in PropertyConstant.
	 * 2. The property exists on the database.
	 * Postconditions: 
	 * 1. The method returns the current value of the property.
	 * 2. When generating the script, the new value of the property is used.
	 * @param key key of the property to get.
	 * @exception Exception in case of error getting the key.
	 * @return the property.
	 */
	public Property getPropertyByKey(Integer key)  throws Exception;
	
}
