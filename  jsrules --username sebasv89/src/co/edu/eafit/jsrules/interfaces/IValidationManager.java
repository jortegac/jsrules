package co.edu.eafit.jsrules.interfaces;

import co.edu.eafit.jsrules.common.WebFormDetails;
import co.edu.eafit.jsrules.servicelocator.Service;

/**
 * Interface that defines the services of validation.
 * 
 * @author Julian Ortega
 * @author Sebastian Velez
 */
public interface IValidationManager extends Service {

    /**
     * Create an XML schema for a list of forms given as a parameter.
     * <p>
     * Preconditions:
     * <ol>
     * <li></li>
     * <li></li>
     * </ol>
     * </p>
     * <p>
     * Postconditions:
     * <ol>
     * <li></li>
     * <li></li>
     * </ol>
     * </p>
     * 
     * @param formList
     *            list of forms to create the schema.
     * @return The string of the xml, or an empty String in case of error.
     */
    String createSchema(WebFormDetails[] formList);

    /**
     * Validates that the schema is valid, and is valid for the web page.
     * <p>
     * Preconditions:
     * <ol>
     * <li></li>
     * <li></li>
     * </ol>
     * </p>
     * <p>
     * Postconditions:
     * <ol>
     * <li></li>
     * <li></li>
     * </ol>
     * </p>
     * 
     * @param schema
     *            schema to be validated.
     * @param webPageString
     *            web page to be validated.
     * @return if the schema is valid for the web page.
     */
    boolean validateSchema(String schema, String webPageString);

    /**
     * Generates a script of validation with the given schema.
     * <p>
     * Preconditions:
     * <ol>
     * <li></li>
     * <li></li>
     * </ol>
     * </p>
     * <p>
     * Postconditions:
     * <ol>
     * <li></li>
     * <li></li>
     * </ol>
     * </p>
     * 
     * @param schema
     *            Schema of validation.
     * @return String with the script
     */
    String generateScript(String schema) throws Exception;

}
