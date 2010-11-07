package co.edu.eafit.jsrules.interfaces;

import co.edu.eafit.jsrules.common.WebFormDetails;
import co.edu.eafit.jsrules.servicelocator.Service;

/**Defines the services to be offered by the webPage entity.
 * 
 * @author Julian Ortega
 * @author Sebastian Velez
 */
public interface IWebPage extends Service {

	/**Returns a list of WebFormDetails.
	 * 
	 * @param webPageString - The contents of a HTML web page
	 * @return A list of WebFormDetails
	 */
	WebFormDetails[] getFormList(String webPageString);
	
	/**Validates if a HTML web page is valid
	 * 
	 * @param webPageString - The contents of a HTML web page
	 * @return    True - If the HTML webPage is valid<br>
	 *             False - Otherwise
	 */
	boolean isValidWebPage(String webPageString);
	
	/**Validates is a web page has at least one form
	 * 
	 * @param webPageString - The contents of an HTML web page
	 * @return    True - If the HTML web page has at least one form <br>
	 *             False - Otherwise
	 */         
	boolean hasAtLeastOneForm(String webPageString);
}
