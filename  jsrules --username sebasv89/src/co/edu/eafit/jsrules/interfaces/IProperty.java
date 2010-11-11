package co.edu.eafit.jsrules.interfaces;

import co.edu.eafit.jsrules.property.Property;
import co.edu.eafit.jsrules.servicelocator.Service;

/**
 * This class defines the services for getting and saving properties in to the component.
 * The constants for properties are defined in PropertiesConstans.java
 * @author Sebastian Velez
 * @author Julian Ortega
 *
 */
public interface IProperty extends Service{


	/**
	 * This method saves a property in to the database.
	 * Preconditions: The property is not null.
	 * Postconditions: The value of the property is updated.
	 * @param p Property to update/save.
	 * @throws Exception in case of error connecting to the database.
	 */
	public void saveProperty(Property p) throws Exception;
	
	/**
	 * Gets the property with the given key.
	 * @param key key of the property to get.
	 * @exception Exception in case of error getting the key.
	 * @return the property.
	 */
	public Property getPropertyByKey(Integer key)  throws Exception;
	
}
