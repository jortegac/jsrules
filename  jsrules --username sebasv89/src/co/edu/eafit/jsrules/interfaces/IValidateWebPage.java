package co.edu.eafit.jsrules.interfaces;

import co.edu.eafit.jsrules.servicelocator.Service;

public interface IValidateWebPage extends Service {

    public boolean validateWebPage(String webPageString);
}
