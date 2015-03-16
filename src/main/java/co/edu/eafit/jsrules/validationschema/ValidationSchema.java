package co.edu.eafit.jsrules.validationschema;

import co.edu.eafit.jsrules.interfaces.IValidateWebPage;
import co.edu.eafit.jsrules.interfaces.IValidationManager;
import co.edu.eafit.jsrules.interfaces.IValidationSchema;
import co.edu.eafit.jsrules.interfaces.IWebPage;
import co.edu.eafit.jsrules.servicelocator.ServiceLocator;

/**
 * @author Julian Ortega
 * @author Sebastian Velez
 */
public class ValidationSchema implements IValidationSchema
{

    @Override
    public String createSchema(String webPageString) throws Exception 
    {
        IValidateWebPage iValidateWebPage = ServiceLocator.getService(IValidateWebPage.class);
        
        if (!iValidateWebPage.validateWebPage(webPageString))
        {
            throw new Exception("La página web no es válida");
        }
        
        IValidationManager iValidationManager = ServiceLocator.getService(IValidationManager.class);
        
        IWebPage iWebPage = ServiceLocator.getService(IWebPage.class);        
        
        return iValidationManager.createSchema(iWebPage.getFormList(webPageString));
    }

}
