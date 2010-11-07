package co.edu.eafit.jsrules.validationmanager;

/**
 * @author sebastian
 *
 */
class JavaScriptFunction {

	String functionName;
	String functionContent;
	
	/**
	 * Generates the code of the function.
	 * @return String with the function code.
	 */
	public String generateFunctionCode() {
		StringBuffer result = new StringBuffer();
		result.append("function ");
		result.append(functionName);
		result.append("() {\n");
		result.append(functionContent);
		result.append("\n}");
		
		return "";
	}

	/**
	 * @return the functionName
	 */
	public String getFunctionName() {
		return functionName;
	}

	/**
	 * @param functionName the functionName to set
	 */
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	/**
	 * @return the functionContent
	 */
	public String getFunctionContent() {
		return functionContent;
	}

	/**
	 * @param functionContent the functionContent to set
	 */
	public void setFunctionContent(String functionContent) {
		this.functionContent = functionContent;
	}
	
	
}
