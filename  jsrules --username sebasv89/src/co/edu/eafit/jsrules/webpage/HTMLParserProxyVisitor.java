package co.edu.eafit.jsrules.webpage;

import java.util.ArrayList;
import java.util.HashMap;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.Tag;
import org.htmlparser.tags.InputTag;
import org.htmlparser.tags.SelectTag;
import org.htmlparser.util.ParserException;
import org.htmlparser.visitors.NodeVisitor;

/**
 * @author Julian
 * 
 */
public class HTMLParserProxyVisitor extends NodeVisitor  {
    ArrayList<WebForm> webFormList = null;

    String webPageString = null;

    /**
     * Receives the contents of a HTML web page and returns a HashMap
     * 
     * @param webPageString
     *            - The contents of the HTML webPage
     * @return HashMap
     */
    public ArrayList<WebForm> getFormList(String webPageString) {
        webFormList = new ArrayList<WebForm>();
        this.webPageString = webPageString;
        try {
            Parser p = new Parser(webPageString);
            p.visitAllNodesWith(this);
        } catch (ParserException e) {
            System.out.println("Error tratando de realizar el parser HTML");
        }
        return webFormList;

    }

    /**
     * @param tag
     *            to be visited
     */
    public void visitTag(Tag tag) {
        // Retrieves indicated tag
        String name = tag.getTagName();        
        
        // Check if the tag is a form tag
        if (name.equalsIgnoreCase("form")) {
            
            // Create WebForm element to be populated with the form information
            WebForm webForm = new WebForm(); 

            // Get the id attribute of the form
            String formId = tag.getAttribute("id");
            
            // Get the name attribute of the form
            String formName = tag.getAttribute("name");
            
            if (formId != null) {
                // Set the form id in the webForm object
                webForm.setId(formId);                
            }
            
            if (formId != null) {
                // Set the form name in the webForm object
                webForm.setName(formName);
            }
            
            ArrayList<FormElement> formElements = new ArrayList<FormElement>();
            
            for (int i = 0; i < tag.getChildren().size(); i++)
            {
                Node currentNode = tag.getChildren().elementAt(i);
                if (currentNode instanceof InputTag || currentNode instanceof SelectTag) {
                                        
                    FormElement formElement = new FormElement();
                    
                    String elementId = ((Tag) currentNode).getAttribute("id");
                    String elementName = ((Tag) currentNode).getAttribute("name");
                    
                    if (elementId != null) 
                    {
                        formElement.setId(elementId);
                    }
                    
                    if (elementName != null) {
                        formElement.setName(elementName);
                    }
                    
                    formElements.add(formElement);                    
                }
                
            }
            
            FormElement[] tmpFormElement = new FormElement[formElements.size()];
            
            tmpFormElement = formElements.toArray(tmpFormElement);
            
            webForm.setFormElementList(tmpFormElement);            
            
            webFormList.add(webForm);
        }
    }
}
