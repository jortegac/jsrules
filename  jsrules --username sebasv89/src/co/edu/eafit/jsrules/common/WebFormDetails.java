package co.edu.eafit.jsrules.common;


/**
 * 
 * @author sebastian
 *
 */
public class WebFormDetails {

	private String name;
	private FormAttributeDetails[] attributesList;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the attributesList
	 */
	public FormAttributeDetails[] getAttributesList() {
		return attributesList;
	}
	/**
	 * @param attributesList the attributesList to set
	 */
	public void setAttributesList(FormAttributeDetails[] attributesList) {
		this.attributesList = attributesList;
	}
	
	
}
