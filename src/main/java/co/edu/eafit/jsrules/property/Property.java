package co.edu.eafit.jsrules.property;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the properties database table.
 * 
 */
/**
 *
 *Properties entity.
 * @author Sebastian Velez
 * @author Julian Ortega
 *
 */
@Entity
@Table(name="properties")
public class Property implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PRO_ID")
	private Integer propertyKey;

	@Column(name="PRO_VALUE")
	private String value;

    public Property() {
    }

	public Integer getPropertyKey() {
		return this.propertyKey;
	}

	public void setPropertyKey(Integer key) {
		this.propertyKey = key;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}