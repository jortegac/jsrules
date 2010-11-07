/**
 * 
 */
package co.edu.eafit.jsrules.webpage;

import co.edu.eafit.jsrules.common.WebFormDetails;

/**Defines the services to be offered by the HTMLParserProxy entity.
 * 
 * @author Julian Ortega
 * @author Sebastian Velez
 *
 */
public interface IHTMLParserProxy 
{
    /**Validates if a HTML web page is valid.
     * @param webPageString - The contents of the HTML web page
     * @return True - <br>
     *          False - Otherwise
     */
    boolean isValidWebPage(String webPageString);
    
    /**Returns a list of webFormDetails.
     * 
     * @param webPageString - The contents of a HTML web page
     * @return A list of webFormDetails
     */
    WebForm[] getFormList(String webPageString);    
    
}
