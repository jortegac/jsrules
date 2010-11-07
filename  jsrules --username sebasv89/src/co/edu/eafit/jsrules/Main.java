package co.edu.eafit.jsrules;

import co.edu.eafit.jsrules.interfaces.IWebPage;
import co.edu.eafit.jsrules.servicelocator.ServiceLocator;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IWebPage iWebPage = ServiceLocator.getService(IWebPage.class);
		System.out.println(iWebPage.holaMundo());
		
	}

}
