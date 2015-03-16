package co.edu.eafit.jsrules.property;

import co.edu.eafit.jsrules.interfaces.IProperty;

/**
 * This class implements the services of the IProperty interface.
 * @author sebastian
 *
 */
public class PropertyService implements IProperty {

	@Override
	public void saveProperty(Property p) throws Exception {
		PropertyFacade pFacade = new PropertyFacade();
		pFacade.saveProperty(p);
	}

	@Override
	public Property getPropertyByKey(Integer key) throws Exception{
		PropertyFacade pFacade = new PropertyFacade();
		return pFacade.getPropertyByKey(key);
	}

}
