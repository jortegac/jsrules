package co.edu.eafit.jsrules.servicelocator;

import java.util.HashMap;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

/**
 * Localize the service implementations for each interface.
 * @author Julian Ortega
 * @author Sebastian Velez
 *
 */
public class ServiceLocator {

	private static final String SERVICE_LOCATOR_PATH = "resources/serviceLocator.xml";
	
	private static HashMap<Class<? extends Service>, String> serviceDefinition;

	/**
	 * gets a service by reflection.
	 * @param <T> Type of interface to get.
	 * @param c interface Class
	 * @return The implementation object.
	 */
	@SuppressWarnings("unchecked")
	public  static synchronized <T extends Service> T getService(Class<? extends Service> c) {
		if (serviceDefinition == null) {
			try {
				loadServiceDefinition();
			} catch (Exception e) {
				System.out.println("error!");
				throw new RuntimeException("error loading services!");
				
			}
		}
		String className = serviceDefinition.get(c);
		try {
			
			T resultClass;
			resultClass = (T) Class.forName(className).newInstance();
			return resultClass;
		} catch (Exception e) {
			throw new RuntimeException("class not found!");
		}
	}

	/**
	 * Load the services definition. This method reads the xml file and load all the definitions in memory.
	 * @throws Exception in case of error loading services.
	 */
	private static void loadServiceDefinition() throws Exception {
		serviceDefinition = new HashMap<Class<? extends Service>, String>();
		SAXBuilder sb = new SAXBuilder(false);
		Document doc1 = sb.build(SERVICE_LOCATOR_PATH);
		Element root = doc1.getRootElement();
		@SuppressWarnings("unchecked")
		List<Element> availableServicesList = root.getChildren();
		for (Element service : availableServicesList) {
			String interfaceName = service.getChild("interface").getText(); 
			String className = service.getChild("className").getText();
			@SuppressWarnings("unchecked")
			Class<? extends Service> interfaceClass = (Class<? extends Service>) Class.forName(interfaceName);
			serviceDefinition.put(interfaceClass, className);
		}
	}

}
