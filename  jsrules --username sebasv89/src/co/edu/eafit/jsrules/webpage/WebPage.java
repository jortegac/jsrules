package co.edu.eafit.jsrules.webpage;

import co.edu.eafit.jsrules.common.WebFormDetails;
import co.edu.eafit.jsrules.interfaces.IWebPage;

/**
 * Implements the interface IWebPage.
 * @author sebastian
 *
 */
public class WebPage implements IWebPage {

	@Override
	public WebFormDetails[] getFormList(String webPage) {
		/*TODO AQUI VOY A PONER COMO LEER LA PAGINA, PERO COMO AQUI USAMOS EL PARSER HTML
		 * ESTO DEBERIA IR CON UN PROXY O ALGO ASI.
		 */
		return null;
		
	}
	
	public String holaMundo() {
		return "hola mundo";
	}

}
