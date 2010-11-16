package co.edu.eafit.jsrules.interfaces;

import co.edu.eafit.jsrules.servicelocator.Service;

/**
 * @author Julian Ortega
 * @author Sebastian Velez
 * 
 */
public interface IScriptGeneration extends Service {

    /**
     *
     * <p>
     * Preconditions:
     * <ol>
     * <li></li>
     * <li></li>
     * </ol>
     * </p>
     * <p>
     * Postconditions:
     * <ol>
     * <li></li>
     * <li></li>
     * </ol>
     * </p>
     * 
     * @param validationSchema
     * @return The generated JavaScript code
     * @throws Exception
     */
    public String generateScript(String validationSchema) throws Exception;
}
