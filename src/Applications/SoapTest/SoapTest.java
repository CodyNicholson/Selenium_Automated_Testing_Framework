package Applications.SoapTest;

import org.w3c.dom.NodeList;

import javax.xml.soap.*;
import java.io.File;
import java.io.FileInputStream;

/**
 * Created by CAD5124 on 3/7/2017.
 */
public class SoapTest
{
    public static void main(String[] args)
    {
        try {
            createSOAPRequest("filepath");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            getSOAPResponse(null, "blahh");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            validateValue(null, "strEI", "expected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static SOAPMessage createSOAPRequest(String strPath) throws Exception
    {
        // Create a SOAP message from the XML file located at the given path
        FileInputStream fis = new FileInputStream(new File(strPath));
        MessageFactory factory = MessageFactory.newInstance();
        SOAPMessage message = factory.createMessage(new MimeHeaders(), fis);
        return message;
    }

    private static SOAPMessage getSOAPResponse(SOAPMessage soapRequest, String strEndpoint) throws Exception, SOAPException
    {
        // Send the SOAP request to the given endpoint and return the corresponding response
        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection soapConnection = soapConnectionFactory.createConnection();
        SOAPMessage soapResponse = soapConnection.call(soapRequest, strEndpoint);
        return soapResponse;
    }

    //Parse the response message and validate the value of one of its elements, the validation result is sent to the stdout
    private static void validateValue(SOAPMessage soapMsg, String strEl, String strExpected) throws Exception {
        // Get all elements with the requested element tag from the SOAP message
        SOAPBody soapBody = soapMsg.getSOAPBody();
        NodeList elements = soapBody.getElementsByTagName(strEl);

        // Check whether there is exactly one element with the given tag
        if (elements.getLength() != 1){
            System.out.println("Expected exactly one element " + strEl + "in message, but found " + Integer.toString(elements.getLength()));
        } else {
            // Validate the element value against the expected value
            String strActual = elements.item(0).getTextContent();
            if (strActual.equals(strExpected)) {
                System.out.println("Actual value " + strActual + " for element " + strEl + " matches expected value");
            } else {
                System.out.println("Expected value " + strExpected + " for element " + strEl + ", but found " + strActual + " instead");
            }
        }
    }


}
