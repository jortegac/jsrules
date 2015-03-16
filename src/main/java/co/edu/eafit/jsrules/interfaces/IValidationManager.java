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
     * <li>There is at least one web form to be validated</li>
     * </ol>
     * </p>
     * <p>
     * Postconditions:
     * <ol>
     * <li>The validation schema is created</li>
     * </ol>
     * </p>
     * 
     * @param formList
     *            List of forms that exist in an HTML web page, which will be
     *            used to create the validation schema.
     * @return The XML that defines the validation schema . <br>
     *         In case of error an empty String is returned.
     */
    String createSchema(WebFormDetails[] formList);

    /**
     * Validates that the schema is valid, and is valid for the web page.
     * <p>
     * Preconditions:
     * <ol>
     * <li>The validation schema exists.</li>
     * <li>The validation schema contains only permitted validations</li>
     * <li>The web page exists</li>
     * <li>The web page is valid</li>
     * </ol>
     * </p>
     * <p>
     * Postconditions:
     * <ol>
     * <li>The validation schema is valid for the web page</li>
     * </ol>
     * </p>
     * 
     * @param schema
     *            Validation schema to be validated.
     * @param webPageString
     *            The contents of the HTML web page to be validated.
     * @return True - If the validation schema is valid for the web page. <br>
     *         False - Otherwise
     */
    boolean validateSchema(String schema, String webPageString);

    /**
     * Generates a script of validation with the given schema.
     * <p>
     * Preconditions:
     * <ol>
     * <li>The validation schema exists.</li>
     * <li>The validation schema contains only permitted validations</li>
     * </ol>
     * </p>
     * <p>
     * Postconditions:
     * <ol>
     * <li>The JavaScript code to validate the HTML form is created</li>
     * <li>The JavaScript code validates the restrictions established in the
     * validation schema</li>
     * </ol>
     * </p>
     * 
     * @param schema
     *            The validation schema for which the JavaScript will be
     *            created.
     * @return The JavaScript code to validate the HTML form, based on a
     *         validation schema.
     * @throws Exception
     *             If there is an error generating the script.
     */
    String generateScript(String schema) throws Exception;

}
