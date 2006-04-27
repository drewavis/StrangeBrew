/**
 * $Id: ImportXml.java,v 1.2 2006/04/27 17:29:52 andrew_avis Exp $
 *
 * This is the "driver" for xml import.  It sets up the parser, catches
 * exceptions, and associates our XmlHandler class with the parser so 
 * it can listen for events.  You create one of these and pass it an xml
 * file name (with path).  You get the resultant recipe with 
 * ImportXml.handler.getRecipe().  I wish I could figure out how
 * to just use ImportXml.getRecipe(), but it doesn't seem to work. 
 */

package ca.strangebrew;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class ImportXml  {
	
	public XmlHandler handler; 
	public XmlStyleHandler styleHandler;
	
	public ImportXml(String fileName, String type) {
		
		// Use the default (non-validating) parser
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// debug:
		System.out.println("Using Sax Parser factory: " + factory.getClass());
		try {

			// Parse the input
			SAXParser saxParser = factory.newSAXParser();
			if (type.equalsIgnoreCase("style")){
				styleHandler = new XmlStyleHandler();
				saxParser.parse(new File(fileName), styleHandler);
			}
			else {
				handler = new XmlHandler();
				saxParser.parse(new File(fileName), handler);
			}
				
			

		} catch (SAXParseException spe) {
			// Error generated by the parser
			System.out.println("\n** Parsing error" + ", line "
					+ spe.getLineNumber() + ", uri " + spe.getSystemId());
			System.out.println("   " + spe.getMessage());

			// Use the contained exception, if any
			Exception x = spe;
			if (spe.getException() != null)
				x = spe.getException();
			x.printStackTrace();

		} catch (SAXException sxe) {
			// Error generated by this application
			// (or a parser-initialization error)
			Exception x = sxe;
			if (sxe.getException() != null)
				x = sxe.getException();
			x.printStackTrace();

		} catch (ParserConfigurationException pce) {
			// Parser with specified options can't be built
			pce.printStackTrace();

		} catch (IOException ioe) {
			// I/O error
			ioe.printStackTrace();
		}


	}
	
	
	
}