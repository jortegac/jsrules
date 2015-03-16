/**
 * 
 */
package co.edu.eafit.jsrules.validatewebpage;

import co.edu.eafit.jsrules.interfaces.IValidateWebPage;
import co.edu.eafit.jsrules.interfaces.IWebPage;
import co.edu.eafit.jsrules.servicelocator.ServiceLocator;

/**
 * @author Julian Ortega
 * @author Sebastian Velez
 */
public class ValidateWebPage implements IValidateWebPage {

    /* (non-Javadoc)
     * @see co.edu.eafit.jsrules.interfaces.IValidateWebPage#validateWebPage(java.lang.String)
     */
    @Override
    public boolean validateWebPage(String webPageString) {
        IWebPage iWebPage = ServiceLocator.getService(IWebPage.class);

        return (iWebPage.isValidWebPage(webPageString) && iWebPage.hasAtLeastOneForm(webPageString));
    }

}
