package co.edu.eafit.jsrules.interfaces;

import co.edu.eafit.jsrules.common.WebFormDetails;
import co.edu.eafit.jsrules.servicelocator.Service;

/**
 * Defines the services to be offered by the webPage entity.
 * 
 * @author Julian Ortega
 * @author Sebastian Velez
 */
public interface IWebPage extends Service {

    /**
     * Returns a list of WebFormDetails.
     * <p>
     * Preconditions:
     * <ol>
     * <li>The web page exists</li>
     * <li>The web page is valid</li>
     * <li>The web page contains at least one form</li>
     * </ol>
     * </p>
     * <p>
     * Postconditions:
     * <ol>
     * <li>A list of forms from the web page is created.</li>
     * <li>The list has information of at least one form.</li>
     * </ol>
     * </p>
     * 
     * @param webPageString
     *            - The contents of a HTML web page
     * @return A list of WebFormDetails
     * @throws Exception 
     */
    WebFormDetails[] getFormList(String webPageString) throws Exception;

    /**
     * Validates if a HTML web page is valid.
     * <p>
     * Preconditions:
     * <ol>
     * <li>The web page exists</li>
     * </ol>
     * </p>
     * <p>
     * Postconditions:
     * <ol>
     * <li>The web page is valid</li>
     * </ol>
     * </p>
     * 
     * @param webPageString
     *            - The contents of a HTML web page
     * @return True - If the HTML webPage is valid<br>
     *         False - Otherwise
     */
    boolean isValidWebPage(String webPageString);

    /**
     * Validates if a web page has at least one form.
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
     * <li>The web page has at least one form</li>
     * </ol>
     * </p>
     * 
     * @param webPageString
     *            - The contents of an HTML web page
     * @return True - If the HTML web page has at least one form <br>
     *         False - Otherwise
     */
    boolean hasAtLeastOneForm(String webPageString);
}
