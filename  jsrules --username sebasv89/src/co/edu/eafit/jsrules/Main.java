package co.edu.eafit.jsrules;

import co.edu.eafit.jsrules.servicelocator.ServiceLocator;
import co.edu.eafit.jsrules.webpage.IWebPage;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IWebPage iWebPage = ServiceLocator.getService(IWebPage.class);
		System.out.println(iWebPage.holaMundo());
		
		System.out.println("probando!!!");
		
	}

}
