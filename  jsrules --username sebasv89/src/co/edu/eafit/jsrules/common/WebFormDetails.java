package co.edu.eafit.jsrules.common;


/**
 * Abstraction of a web form defining the form id for unique
 * identification and the list of elements contained by the form.
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
	 * @param elementList List of elements to be set for the form
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
	 * @param id The form id to be set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	
}
