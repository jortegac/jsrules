package co.edu.eafit.jsrules.interfaces;

import co.edu.eafit.jsrules.servicelocator.Service;

/**
 * @author Julian
 *
 */
public interface IScriptGeneration extends Service {

    /**
     * @param validationSchema
     * @return
     * @throws Exception
     */
    public String generateScript(String validationSchema) throws Exception;
}
