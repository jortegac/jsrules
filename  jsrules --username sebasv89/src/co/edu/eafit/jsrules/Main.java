package co.edu.eafit.jsrules;

import co.edu.eafit.jsrules.interfaces.IValidationManager;
import co.edu.eafit.jsrules.interfaces.IValidationSchema;
import co.edu.eafit.jsrules.interfaces.IWebPage;
import co.edu.eafit.jsrules.servicelocator.ServiceLocator;

/**
 * @author Julian
 *
 */
public class Main {

	/**
	 * @param args - command line arguments
	 */
	public static void main(String[] args) {
		IValidationSchema iValidationSchema = ServiceLocator.getService(IValidationSchema.class);
		
		String webPage = "<html>  <form id=\"Form1\" name=\"Formulario 1\">   Name: <input id=\"input1\" name=\"name\" type=\"text\" size=\"30\" /><br /> E-mail: <input id=\"input2\" name=\"E-mail\" type=\"text\" size=\"30\" /><br /> Date of birth: <input id=\"input3\" name=\"DOB\" type=\"text\" size=\"10\" />   </form>     <form id=\"Form2\" name=\"Formulario 2\">   Name: <input id=\"input1\" name=\"name\" type=\"text\" size=\"30\"/><br />  E-mail: <input id=\"input2\" name=\"E-mail\" type=\"text\" size=\"30\" /><br /> Date of birth: <input id=\"input3\" name=\"DOB\" type=\"text\" size=\"10\" />   </form></html>";
		
		try {
            System.out.println(iValidationSchema.createSchema(webPage));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        IValidationManager iValidationManager = ServiceLocator.getService(IValidationManager.class);
        
        String schema = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+
        "<validationschema>"+
        "<validationgroup id=\"1\" formid=\"myForm\">"+
        "<validationelement id=\"1\" formElementId=\"nombre\">"+
        "<validations>"+
        "<validation>"+
        "<type>required</type>"+
        "<message>El campo es obligatorio</message>"+
        "</validation>"+
        "<validation>"+
        "<type>range</type>"+
        "<min>0</min>"+
        "<max>100</max>"+
        "<message>Rango invalido</message>"+
        "</validation>"+
        "</validations>"+
        "</validationelement>"+
        "</validationgroup>"+
        "</validationschema>";
        
        try {
            System.out.println(iValidationManager.generateScript(schema));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

}
