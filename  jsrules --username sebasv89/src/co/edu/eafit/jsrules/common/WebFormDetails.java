package co.edu.eafit.jsrules.common;


/**
 * DTO of a web form
 * @author Julian Ortega
 * @author Sebastian Velez
 *
 */
public class WebFormDetails {

	private String id;
	private FormElementDetails[] elementList;

	
	/**
	 * @return The web form element list
	 */
	public FormElementDetails[] getElementList() {
		return elementList;
	}
	/**
	 * @param List of elements to be set
	 */
	public void setAttributesList(FormElementDetails[] elementList) {
		this.elementList = elementList;
	}
	/**
	 * @return The form id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param Set the form id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	
}
