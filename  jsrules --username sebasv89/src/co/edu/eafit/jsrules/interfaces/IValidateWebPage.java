package co.edu.eafit.jsrules.interfaces;

import co.edu.eafit.jsrules.servicelocator.Service;

/**
 * @author Julian Ortega
 * @author Sebastian Velez
 *
 */
public interface IValidateWebPage extends Service {

    /**
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
     * @param webPageString
     * @return
     */
    public boolean validateWebPage(String webPageString);
}
