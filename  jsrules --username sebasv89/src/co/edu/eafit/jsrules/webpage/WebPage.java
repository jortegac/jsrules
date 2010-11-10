package co.edu.eafit.jsrules.webpage;

import java.util.ArrayList;

import co.edu.eafit.jsrules.common.FormElementDetails;
import co.edu.eafit.jsrules.common.WebFormDetails;
import co.edu.eafit.jsrules.interfaces.IWebPage;

/**
 * Implements the interface IWebPage.
 * 
 * @author Julian Ortega
 * @author Sebastian Velez
 * 
 */
public class WebPage implements IWebPage {

    HTMLParserProxy parserProxy = new HTMLParserProxy();

    /**
     * Constructor
     */
    public WebPage() {
        parserProxy = new HTMLParserProxy();
    }

    @Override
    public WebFormDetails[] getFormList(String webPageString) throws Exception {

        WebForm[] webFormList = parserProxy.getFormList(webPageString);

        WebFormDetails[] webFormDetailsList = new WebFormDetails[webFormList.length];

        for (int i = 0; i < webFormList.length; i++) {
            WebFormDetails formDetails = new WebFormDetails();

            if (webFormList[i].getId() == null) {
                throw new Exception("The form must have an id tag");
            }

            formDetails.setId(webFormList[i].getId());

            FormElementDetails[] elementDetailsList = new FormElementDetails[webFormList[i]
                    .getFormElementList().length];

            for (int j = 0; j < webFormList[i].getFormElementList().length; j++) {
                FormElementDetails elementDetails = new FormElementDetails();
                elementDetails.setId(webFormList[i].getFormElementList()[j]
                        .getId());

                elementDetailsList[j] = elementDetails;
            }

            formDetails.setAttributesList(elementDetailsList);

            webFormDetailsList[i] = formDetails;
        }

        return webFormDetailsList;

    }

    @Override
    public boolean isValidWebPage(String webPageString) {

        return parserProxy.isValidWebPage(webPageString);
    }

    @Override
    public boolean hasAtLeastOneForm(String webPageString) {

        return parserProxy.getFormList(webPageString).length > 0;
    }

}
