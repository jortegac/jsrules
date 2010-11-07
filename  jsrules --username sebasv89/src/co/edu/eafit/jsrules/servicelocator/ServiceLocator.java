package co.edu.eafit.jsrules.servicelocator;

import java.util.HashMap;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class ServiceLocator {

	private static HashMap<Class<? extends Service>, String> serviceDefinition;

	@SuppressWarnings("unchecked")
	public synchronized static <T extends Service> T getService(Class<? extends Service> c) {
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

	private static void loadServiceDefinition() throws Exception{
		serviceDefinition = new HashMap<Class<? extends Service>, String>();
		SAXBuilder sb = new SAXBuilder(false);
		Document doc1 = sb.build("resources/serviceLocator.xml");
		Element root = doc1.getRootElement();
		List<Element> availableServicesList = root.getChildren();
		for (Element service : availableServicesList) {
			String interfaceName = service.getChild("interface").getText(); 
			String className = service.getChild("className").getText();
			Class interfaceClass = Class.forName(interfaceName);
			serviceDefinition.put(interfaceClass, className);
		}
	}

}
