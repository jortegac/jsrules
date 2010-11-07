package co.edu.eafit.jsrules.webpage;

/**
 * Represents a web form.
 * @author sebastian
 *
 */
class WebForm {

	private FormAttribute[] formAttributeList;
	private String id;
	private String name;
	/**
	 * @return the formAttributeList
	 */
	public FormAttribute[] getFormAttributeList() {
		return formAttributeList;
	}
	/**
	 * @param formAttributeList the formAttributeList to set
	 */
	public void setFormAttributeList(FormAttribute[] formAttributeList) {
		this.formAttributeList = formAttributeList;
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

	
}
