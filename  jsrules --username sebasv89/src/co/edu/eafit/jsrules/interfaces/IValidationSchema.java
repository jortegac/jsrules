package co.edu.eafit.jsrules.interfaces;

import co.edu.eafit.jsrules.servicelocator.Service;

/**Defines the services to be offered by the ValidationSchema entity.
 * @author Julian Ortega
 * @author Sebastian Velez
 */
public interface IValidationSchema extends Service {

    /**Creates the validation schema according to the web page contents.
     * @param webPageString The web page contents
     * @return The validation schema
     * @throws Exception 
     */
    public String createSchema(String webPageString) throws Exception;
}
