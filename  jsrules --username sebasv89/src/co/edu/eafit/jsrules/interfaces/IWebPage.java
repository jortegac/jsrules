package co.edu.eafit.jsrules.interfaces;

import co.edu.eafit.jsrules.common.WebFormDetails;
import co.edu.eafit.jsrules.servicelocator.Service;

public interface IWebPage extends Service {

	WebFormDetails[] getFormList(String webPage);
	
	String holaMundo();
}
