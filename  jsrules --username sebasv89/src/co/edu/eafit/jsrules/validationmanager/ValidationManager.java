package co.edu.eafit.jsrules.validationmanager;

import java.io.IOException;
import java.io.StringBufferInputStream;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.xml.sax.InputSource;

import co.edu.eafit.jsrules.common.FormElementDetails;
import co.edu.eafit.jsrules.common.WebFormDetails;
import co.edu.eafit.jsrules.interfaces.IValidateWebPage;
import co.edu.eafit.jsrules.interfaces.IValidationManager;
import co.edu.eafit.jsrules.servicelocator.ServiceLocator;

/**
 * Implements the services offered by the IValidationManager interface.
 * @author Julian Ortega
 * @author Sebastian Velez
 *
 */
public class ValidationManager implements IValidationManager {

	private static final String ROOT_ELEMENT_NAME = "validationschema";
	private static final String VALIDATION_GROUP_NAME = "validationgroup";
	private static final String VALIDATION_ELEMENT_NAME = "validationelement";
	private static final String VALIDATIONS_ELEMENT_NAME = "validations";

	@Override
	public String createSchema(WebFormDetails[] formList) {
		Document schema = new Document();
		Element rootElement = new Element(ROOT_ELEMENT_NAME);
		schema.setRootElement(rootElement);
		int formCounter = 1;
		for (WebFormDetails webForm : formList) {
			Element validationGroup = new Element(VALIDATION_GROUP_NAME);
			rootElement.addContent(validationGroup);
			validationGroup.setAttribute("id", String.valueOf(formCounter));
			validationGroup.setAttribute("formId", webForm.getId());
			int elementCounter = 1;
			for (FormElementDetails  element : webForm.getElementList()) {
				Element validationElement = new Element(VALIDATION_ELEMENT_NAME);
				validationGroup.addContent(validationElement);
				validationElement.setAttribute("id", String.valueOf(elementCounter));
				validationElement.setAttribute("formElementId", element.getId());
				Element validations = new Element(VALIDATIONS_ELEMENT_NAME);
				validationElement.addContent(validations);
				Element emptyValidation = new Element("validation");
				validations.addContent(emptyValidation);
				elementCounter++;
			}
			formCounter++;
		}
		XMLOutputter outputter = new XMLOutputter(Format.getCompactFormat());
		String result = outputter.outputString(schema);
		return result;
	}

	@Override
	public boolean validateSchema(String schema, String webPageString) {
		return true; //TODO! esta mierda creo q vuela.
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public String generateScript(String schema) throws Exception {
		JavaScriptGenerator generator = new JavaScriptGenerator();
		SAXBuilder sb = new SAXBuilder(false);
		Document schemaDocument = null; 
		try {
			schemaDocument = sb.build(new StringBufferInputStream(schema));
		} catch (Exception e) {
			throw new Exception("error building xml");
		}
		Element rootElement = schemaDocument.getRootElement();
		List<Element> listOfGroups = (List<Element>) rootElement.getChildren();
		for (Element group : listOfGroups) {
			String groupName = group.getAttributeValue("formid");
			List<Element> validationElementList = (List<Element>) group.getChildren(); 
			for (Element validationElement : validationElementList) {
				String elementId = validationElement.getAttributeValue("formElementId");
				Element validations = validationElement.getChild(VALIDATIONS_ELEMENT_NAME);
				List<Element> validationList = (List<Element>) validations.getChildren();
				int counter = 1;
				for (Element validation : validationList) {
					ValidationsTypeEnum type = null;
					String typeString = validation.getChild("type").getText();
					String message = validation.getChild("message").getText();
					if (typeString.equalsIgnoreCase("required")) {
						type = ValidationsTypeEnum.REQUIREDFIELD;
					} else if (typeString.equalsIgnoreCase("range")) { 
						type = ValidationsTypeEnum.RANGE;
					} else if (typeString.equalsIgnoreCase("regularExpression")) { 
						type = ValidationsTypeEnum.REGULAREXPRESSION;
					}
					switch (type) {
						case RANGE:
							String min = validation.getChild("min").getText();
							String max = validation.getChild("max").getText();
							if (min == null || max == null) {
								throw new Exception ("range validation does not contain min and max " 
										+ "properties");
							}
							generator.addFunction(groupName, elementId, type, counter, message, min, max);	
							break;
						case REQUIREDFIELD:
						generator.addFunction(groupName, elementId, type, counter, message);
							break;
						case REGULAREXPRESSION:
							String expression = validation.getChild("regularExpression").getText();
							if (expression == null) {
								throw new Exception ("regular expression validation without pattern");
							}
							generator.addFunction(groupName, elementId, type, counter, message, expression);
							break;
					}
					counter++;
				}
			}
		}
		return generator.generateJavaScriptString();
	}
	

}
