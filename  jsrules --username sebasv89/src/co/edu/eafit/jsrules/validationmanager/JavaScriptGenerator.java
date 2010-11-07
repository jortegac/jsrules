package co.edu.eafit.jsrules.validationmanager;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages the validation of a javascript file.
 * @author sebastian
 *
 */
class JavaScriptGenerator {

	private StringBuffer bufferOfFile;
	
	private List<JavaScriptFunction>  functionSuite;
	
	/**
	 * Default constructor.
	 */
	public JavaScriptGenerator() {
		bufferOfFile = new StringBuffer();
		functionSuite = new ArrayList<JavaScriptFunction>();
	}
	
	/**
	 * Generate the complete javascript String.
	 * @return
	 */
	public String generateJavaScriptString() {
		return null;//TODO
	}
	
	public boolean addFunction(String functionName, String elementId, ValidationsTypeEnum validationType, 
			String... parameters) {
		
		
		return false;
	}
	
	private String generateFunctionStub(String functionName, String functionContent) {
		StringBuffer result = new StringBuffer();
		result.append("function ");
		result.append(functionName);
		result.append("() {\n");
		result.append(functionContent);
		result.append("\n}");
		
		return "";
	}
	
	private String generateFunctionContent(String elementId, ValidationsTypeEnum validationType, 
			String... parameters) {
		
		
		return "";
	}
	
	
}
