package co.edu.eafit.jsrules.common;


/**
 * DTO of a web form
 * @author sebastian
 *
 */
public class WebFormDetails {

	private String id;
	private FormElementDetails[] elementList;

	
	/**
	 * @return the attributesList
	 */
	public FormElementDetails[] getElementList() {
		return elementList;
	}
	/**
	 * @param elementList the attributesList to set
	 */
	public void setAttributesList(FormElementDetails[] elementList) {
		this.elementList = elementList;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	
}
