package co.edu.eafit.jsrules.common;

/**
 * Abstraction of a web form element defining the element id for unique
 * identification and the element type.
 * 
 * @author Julian Ortega
 * @author Sebastian Velez
 * 
 */
public class FormElementDetails {

    private String id;

    private String type;

    /**
     * @return The web form element id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            The web form element id to be set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return The type of web form element
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     *            The type of web form element to be set
     */
    public void setType(String type) {
        this.type = type;
    }

}
