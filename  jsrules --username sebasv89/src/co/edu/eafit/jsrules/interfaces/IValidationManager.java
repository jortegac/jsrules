package co.edu.eafit.jsrules.interfaces;

import co.edu.eafit.jsrules.common.WebFormDetails;
import co.edu.eafit.jsrules.servicelocator.Service;

/**
 * Interface that defines the services of validation.
 * @author sebastian
 */
public interface IValidationManager extends Service {

	/**
	 * Create an XML schema for a web page given as a parameter. 
	 * @param webPageString web page String to be validated.
	 * @param formList list of forms to create the schema.
	 * @return The string of the xml, or an empty String in case of error.
	 */
	String createSchema(WebFormDetails[] formList, String webPageString);
	
	/**
	 * Validates that the schema is valid, and is valid for the web page. 
	 * @param schema schema to be validated.
	 * @param webPageString web page to be validated.
	 * @return if the schema is valid for the web page. 
	 */
	boolean validateSchema (String schema, String webPageString);
	
	
}
