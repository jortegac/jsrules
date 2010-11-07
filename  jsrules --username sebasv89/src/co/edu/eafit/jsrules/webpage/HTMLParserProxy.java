/**
 * 
 */
package co.edu.eafit.jsrules.webpage;

import java.util.ArrayList;

import co.edu.eafit.jsrules.common.WebFormDetails;
import co.edu.eafit.jsrules.interfaces.IHTMLParserProxy;

/**
 * @author Julian
 * 
 */
public class HTMLParserProxy implements IHTMLParserProxy {

    /*
     * (non-Javadoc)
     * 
     * @see
     * co.edu.eafit.jsrules.interfaces.IHTMLParserProxy#isValidWebPage(java.
     * lang.String)
     */
    @Override
    public boolean isValidWebPage(String webPageString) {

        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * co.edu.eafit.jsrules.interfaces.IHTMLParserProxy#getFormList(java.lang
     * .String)
     */
    @Override
    public WebFormDetails[] getFormList(String webPageString) {
        HTMLParserProxyVisitor visitor = new HTMLParserProxyVisitor();
        ArrayList <WebForm> webFormlist = visitor.getFormList(webPageString);
        
        ArrayList <WebFormDetails> webFormDetails = new ArrayList<WebFormDetails>();
        
        for (int i = 0; i < webFormlist.size(); i++) {
            WebFormDetails formDetails = new WebFormDetails();
            
        }
        
        return null;
    }

}
