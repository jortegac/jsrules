package co.edu.eafit.jsrules.interfaces;

import co.edu.eafit.jsrules.servicelocator.Service;

/**
 * Defines the services to be offered by the ValidationSchema entity.
 * 
 * @author Julian Ortega
 * @author Sebastian Velez
 */
public interface IValidationSchema extends Service {

    /**
     * Creates the validation schema according to the web page contents.
     * <p>
     * Preconditions:
     * <ol>
     * <li>The web page exists</li>
     * <li>The web page is valid</li>
     * </ol>
     * </p>
     * <p>
     * Postconditions:
     * <ol>
     * <li>The validation schema is created</li>
     * </ol>
     * </p>
     * 
     * @param webPageString
     *            The web page contents
     * @return The validation schema
     * @throws Exception If the is an error creating the schema
     */
    public String createSchema(String webPageString) throws Exception;
}
