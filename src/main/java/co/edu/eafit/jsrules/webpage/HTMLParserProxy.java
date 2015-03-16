/**
 * 
 */
package co.edu.eafit.jsrules.webpage;

import java.util.ArrayList;

import org.htmlparser.Parser;
import org.htmlparser.util.ParserException;

import co.edu.eafit.jsrules.common.WebFormDetails;

/**
 * @author Julian Ortega
 * @author Sebastian Velez
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
        
        try {
            Parser p = new Parser(webPageString);
        } catch (ParserException e) {
            e.printStackTrace();
            System.out.println("Error tratando de realizar el parser HTML");
            return false;
        }
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * co.edu.eafit.jsrules.interfaces.IHTMLParserProxy#getFormList(java.lang
     * .String)
     */
    @Override
    public WebForm[] getFormList(String webPageString) {
        
        HTMLParserProxyVisitor visitor = new HTMLParserProxyVisitor();
        ArrayList <WebForm> webFormlist = visitor.getFormList(webPageString);
        
        WebForm[] tmpWebFormList = new WebForm[webFormlist.size()];
        
        tmpWebFormList = webFormlist.toArray(tmpWebFormList);
        
        return tmpWebFormList;        
    }

}
