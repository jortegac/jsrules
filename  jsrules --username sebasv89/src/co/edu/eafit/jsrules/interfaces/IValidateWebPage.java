package co.edu.eafit.jsrules.interfaces;

import co.edu.eafit.jsrules.servicelocator.Service;

/**
 * <p>
 * This class defines the service for validating if a web page is valid and has
 * at least one form element.
 * </p>
 * 
 * @author Julian Ortega
 * @author Sebastian Velez
 * 
 */
public interface IValidateWebPage extends Service {

    /**
     * Determines if a web page is valid and contains at least one form element.
     * <p>
     * Preconditions:
     * <ol>
     * <li>The web page exists</li>
     * </ol>
     * </p>
     * <p>
     * Postconditions:
     * <ol>
     * <li>The HTML web page is valid and contains at least one form</li>
     * </ol>
     * </p>
     * 
     * @param webPageString
     *            The contents of the web page to be validated.
     * @return True - if the web page is valid and contains at least one form
     *         element.<br>
     *         False - otherwise
     */
    public boolean validateWebPage(String webPageString);
}
