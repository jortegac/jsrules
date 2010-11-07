package co.edu.eafit.jsrules.validationmanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Manages the validation of a javascript file.
 * @author sebastian
 *
 */
class JavaScriptGenerator {

	private StringBuffer bufferOfFile;
	
	/**
	 * hashmap containing the list of javascript functions for a group of validations.
	 * */
	private HashMap<String, List<JavaScriptFunction>>  hashMapOfSuites;
	
	
	private static final String FUNCTION_PREFIX = "validationFunction_";
	private static final String FUNCTION_GROUP_PREFIX = "groupFunction_";
	/**
	 * Default constructor.
	 */
	public JavaScriptGenerator() {
		bufferOfFile = new StringBuffer();
		hashMapOfSuites = new HashMap<String, List<JavaScriptFunction>>();
	}
	
	/**
	 * Generate the complete javascript String.
	 * @return
	 */
	public String generateJavaScriptString() {
		return null;//TODO
	}
	
	/**
	 * Add a function to the function suite.
	 * @param elementId id of the element.
	 * @param group the group of this function.
	 * @param validationType type of validation to use. Define in the ValidationsTypeEnum enumerator.
	 * @param parameters additional parameters when required.
	 * If the type of validation is a range. The parameters have the minimum and the maximum value.
	 * If the type of validation is a regular expression there is a parameter storing the expression.
	 * @return boolean with the result of the operation
	 */
	public boolean addFunction(String group, String elementId, ValidationsTypeEnum validationType, 
			String... parameters) {
		if (elementId == null || validationType == null) {
			return false;
		}
		JavaScriptFunction function = new JavaScriptFunction();
		String functionName = FUNCTION_PREFIX + elementId;
		function.setFunctionName(functionName);
		String content = generateFunctionContent(elementId, validationType, parameters);
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
	 */
	private String generateFunctionContent(String elementId, ValidationsTypeEnum validationType, 
			String... parameters) {
		StringBuffer code = new StringBuffer();
		//we always will need the element value,
		code.append("var elementValue = " + getValueOfElementById(elementId) + "\n");
		
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
		code.append("} else { return false }");
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
