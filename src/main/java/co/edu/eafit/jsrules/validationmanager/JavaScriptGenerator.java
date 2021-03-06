package co.edu.eafit.jsrules.validationmanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import co.edu.eafit.jsrules.interfaces.IProperty;
import co.edu.eafit.jsrules.property.Properties;
import co.edu.eafit.jsrules.servicelocator.ServiceLocator;

/**
 * Manages the validation of a javascript file.
 * @author Julian Ortega
 * @author Sebastian Velez
 *
 */
class JavaScriptGenerator {

	private StringBuffer bufferOfFile;
	
	/**
	 * hashmap containing the list of javascript functions for a group of validations.
	 * */
	private HashMap<String, List<JavaScriptFunction>>  hashMapOfSuites;
	
	
	private static final String FUNCTION_PREFIX = "validationFunction_";
	private static final String FUNCTION_GROUP_PREFIX = "validateForm_";

	/**
	 * Default constructor.
	 */
	public JavaScriptGenerator() {
		bufferOfFile = new StringBuffer();
		hashMapOfSuites = new HashMap<String, List<JavaScriptFunction>>();
	}
	
	/**
	 * Generate the complete javascript String.
	 * @return the code of the javascript generated.
	 * @exception Exception in case of error connecting to the property service
	 */
	public String generateJavaScriptString() throws Exception {
		bufferOfFile = new StringBuffer();
		//add all the functions to the buffer.
		for (List<JavaScriptFunction> list : hashMapOfSuites.values()) {
			for (JavaScriptFunction function : list) {
				bufferOfFile.append(function.generateFunctionCode());
				bufferOfFile.append("\n");
			}
		}
		//add the functions for validating a complete form.
		for (String key : hashMapOfSuites.keySet()) {
			String code = generateFunctionGroup(key, hashMapOfSuites.get(key));
			bufferOfFile.append(code);
			bufferOfFile.append("\n");
		}
		return bufferOfFile.toString();
	}
	
	/**
	 * Generate the code of a group of validations.
	 * @param key key of the validation group
	 * @param list list of functions for that group.
	 * @return the code with the function that validates that group.
	 * @exception Exception in case of error connecting to the property service
	 */
	private String generateFunctionGroup(String key,
			List<JavaScriptFunction> list) throws Exception {
		StringBuffer bufferOfGroup = new StringBuffer();
		bufferOfGroup.append("function " + FUNCTION_GROUP_PREFIX + key + "(){\n");
		
		for (JavaScriptFunction function : list) {
			bufferOfGroup.append("if(!" + function.getFunctionName() + "()) { return false; }\n");
		}
		IProperty p = ServiceLocator.getService(IProperty.class);
		String message = p.getPropertyByKey(Properties.SUCCESSFUL_MESSAGE).getValue();
		bufferOfGroup.append("alert('" + message + "');");
		bufferOfGroup.append("return true;\n}");
		return bufferOfGroup.toString();
	}

	/**
	 * Add a function to the function suite.
	 * @param elementId id of the element.
	 * @param group the group of this function.
	 * @param validationType type of validation to use. Define in the ValidationsTypeEnum enumerator.
	 * @param counter counter of functions for that element.
	 * @param message message to show to the user in case of error.
	 * @param parameters additional parameters when required.
	 * If the type of validation is a range. The parameters have the minimum and the maximum value.
	 * If the type of validation is a regular expression there is a parameter storing the expression.
	 * @return boolean with the result of the operation
	 * @exception Exception in case of not-founded property.
	 */
	public boolean addFunction(String group, String elementId, ValidationsTypeEnum validationType, 
			int counter, String message, String... parameters) throws Exception {
		if (elementId == null || validationType == null) {
			return false;
		}
		JavaScriptFunction function = new JavaScriptFunction();
		String functionName = FUNCTION_PREFIX + elementId + "_" + String.valueOf(counter);
		function.setFunctionName(functionName);
		String content = generateFunctionContent(elementId, validationType, message, parameters);
		function.setFunctionContent(content);
		addFunctionToHashMap(group, function);
		return true;
	}
	
	
	/**
	 * Adds a function to a group.
	 * @param group group.
	 * @param function function to be added.
	 */
	private void addFunctionToHashMap(String group, JavaScriptFunction function) {
		List<JavaScriptFunction>  functionList = hashMapOfSuites.get(group);
		if (functionList == null) {
			List<JavaScriptFunction>  newList = new ArrayList<JavaScriptFunction>();
			newList.add(function);
			hashMapOfSuites.put(group, newList);
		} else {
			functionList.add(function);
			hashMapOfSuites.put(group, functionList);
		}
	}

	/**
	 * Generate the function content for validate an element with a validation type.
	 * @param elementId id of the element.
	 * @param validationType type of validation to use. Define in the ValidationsTypeEnum enumerator.
	 * @param parameters additional parameters when required.
	 * If the type of validation is a range. The parameters have the minimum and the maximum value.
	 * If the type of validation is a regular expression there is a parameter storing the expression.
	 * @return content of the function
	 * @param message message to show in case of error
	 * @exception Exception in case of not-founded property.
	 */
	private String generateFunctionContent(String elementId, ValidationsTypeEnum validationType, 
			String message, String... parameters) throws Exception {
		StringBuffer code = new StringBuffer();
		//we always will need the element value,
		code.append("var elementValue = " + getValueOfElementById(elementId) + "\n");
		code.append("document.getElementById('" + elementId + "').style.background = \"\";\n");
		
		/*code of validation string depending of the type of validation. This String MUST finish with a 
		contidional and a bracket*/
		String codeOfValidation = "";
		switch (validationType) {
			case REQUIREDFIELD :
				codeOfValidation = "if(";
				codeOfValidation += "elementValue != \"\"";
				codeOfValidation += ") {";
				break;
			case RANGE:
				if (parameters == null || parameters.length < 2) {
					return null;
				}
				String minValue = parameters[0];
				String maxValue = parameters[1];
				codeOfValidation = "if(";
				codeOfValidation += "elementValue >= " + minValue + "&& elementValue <=" + maxValue;
				codeOfValidation += ") {";
				break;
			case  REGULAREXPRESSION:
				if (parameters == null || parameters.length < 1) {
					return null;
				}
				String regularExpression = parameters[0];
				codeOfValidation = "var regularExpression = " + regularExpression;
				codeOfValidation += "\nif(";
				codeOfValidation += "regularExpression.test(elementValue)";
				codeOfValidation += ") {";
				break;
			default:
				//this never will happen.
				break;
		}
		code.append(codeOfValidation);
		code.append("\nreturn true;\n");
		code.append("} else { \n");
		code.append(generateMessageAlert(message, elementId));
		code.append("return false }");
		return code.toString();
	}
	
	/**
	 * Generates an alert message.
	 * @param message message to show.
	 * @param elementId element id.
	 * @return js code that shows the message.
	 * @exception Exception in case of not-founded property.
	 */
	private String generateMessageAlert(String message, String elementId) throws Exception{
		IProperty iProperty = ServiceLocator.getService(IProperty.class);
		String colorForError = iProperty.getPropertyByKey(Properties.ERROR_COLOR).getValue();
		String messageType = iProperty.getPropertyByKey(Properties.MESSAGE_TYPE).getValue();
 
		StringBuffer code = new StringBuffer();
		code.append("document.getElementById(\"" + elementId + "\").style.background = '" + colorForError + 
				"';\n");
		if (messageType.equals(Properties.ALERT_MESSAGE)) {
			code.append("alert('" + message + "');\n");
		} else {
			code.append("document.getElementById(\"" + elementId + "\").title = '" + message + "';\n");
		}
		return code.toString();
	}

	/**
	 * Get the javascript sintax for the value of an element.
	 * @param id id of the element.
	 * @return the javascript code to get the value
	 */
	private String getValueOfElementById(String id) {
		return "document.getElementById(\"" + id + "\").value";
	}
	
	
}
