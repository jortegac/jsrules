package co.edu.eafit.jsrules.webpage;

/**
 * Represents a web form.
 * 
 * @author Julian Ortega
 * @author Sebastian Velez
 * 
 */
class WebForm {

    private FormElement[] formElementList;

    private String id;

    private String name;

    /**
     * @return the formAttributeList
     */
    public FormElement[] getFormElementList() {
        return formElementList;
    }

    /**
     * @param formElementList
     *            the formAttributeList to set
     */
    public void setFormElementList(FormElement[] formElementList) {
        this.formElementList = formElementList;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
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
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}
