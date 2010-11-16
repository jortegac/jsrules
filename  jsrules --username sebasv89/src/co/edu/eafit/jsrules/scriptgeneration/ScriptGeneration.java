/**
 * 
 */
package co.edu.eafit.jsrules.scriptgeneration;

import java.util.ServiceLoader;

import co.edu.eafit.jsrules.interfaces.IScriptGeneration;
import co.edu.eafit.jsrules.interfaces.IValidationManager;
import co.edu.eafit.jsrules.servicelocator.ServiceLocator;

/**
 * @author Julian Ortega
 * @author Sebastian Velez
 *
 */
public class ScriptGeneration implements IScriptGeneration {

    /* (non-Javadoc)
     * @see co.edu.eafit.jsrules.interfaces.IScriptGeneration#generateScript(java.lang.String)
     */
    @Override
    public String generateScript(String validationSchema) throws Exception 
    {
        IValidationManager iValidationManager = ServiceLocator.getService(IValidationManager.class);        
        
        return iValidationManager.generateScript(validationSchema);
    }

}
