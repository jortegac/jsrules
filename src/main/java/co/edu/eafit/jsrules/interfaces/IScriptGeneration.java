package co.edu.eafit.jsrules.interfaces;

import co.edu.eafit.jsrules.servicelocator.Service;

/**
 * <p>
 * This class defines the service for generating the JavaScript code, according
 * to a validation schema.
 * </p>
 * 
 * @author Julian Ortega
 * @author Sebastian Velez
 * 
 */
public interface IScriptGeneration extends Service {

    /**
     * Generates the JavaScript code that validates the HTML, based on a
     * validation schema.
     * 
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
     * </ol>
     * </p>
     * 
     * @param validationSchema
     *            The schema that contains the validations defined for the HTML
     *            form.
     * @return The generated JavaScript code
     * @throws Exception If there is an error generating the JavaScript
     */
    public String generateScript(String validationSchema) throws Exception;
}
