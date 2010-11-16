package co.edu.eafit.jsrules.interfaces;

import co.edu.eafit.jsrules.property.Property;
import co.edu.eafit.jsrules.servicelocator.Service;

/**
 * <p>
 * This class defines the services for getting and saving properties into the
 * component.
 * </p>
 * <p>
 * The constants for properties are defined in PropertiesConstants.java
 * </p>
 * <p>
 * The script generation process reads the properties in order to customize the
 * JavaScript result.
 * </p>
 * 
 * @author Julian Ortega
 * @author Sebastian Velez
 */
public interface IProperty extends Service {

    /**
     * This method saves a property into the database.
     * <p>
     * Preconditions:
     * <ol>
     * <li>The property to save is not null.</li>
     * <li>The property key and the property value are allowed values. (Defined
     * in PropertyConstants class)</li>
     * </ol>
     * </p>
     * <p>
     * Postconditions:
     * <ol>
     * <li>The value of the property is updated.</li>
     * <li>When generating the script, the new value of the property is used.</li>
     * </ol>
     * </p>
     * 
     * @param p
     *            Property to update/save.
     * @throws Exception
     *             in case of error connecting to the database.
     * @see Properties
     */
    public void saveProperty(Property p) throws Exception;

    /**
     * Gets the property with the given key.
     * <p>
     * Preconditions:
     * <ol>
     * <li>The key is valid and it is defined in PropertyConstant.</li>
     * <li>The property exists on the database.</li>
     * </ol>
     * </p>
     * <p>
     * Postconditions:
     * <ol>
     * <li>The method returns the current value of the property.</li>
     * <li>When generating the script, the new value of the property is used.</li>
     * </ol>
     * </p>
     * 
     * @param key
     *            key of the property to get.
     * @exception Exception
     *                in case of error getting the key.
     * @return the property.
     */
    public Property getPropertyByKey(Integer key) throws Exception;

}
