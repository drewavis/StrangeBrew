/**
 * $Id: Hop.java,v 1.10 2007/12/14 18:40:28 jimcdiver Exp $
 * Created on Oct 5, 2004
 *
 * Base class for hops.  This object doesn't do much except hold data and
 * get/set data.
 */

package ca.strangebrew;


public class Hop extends Ingredient{
	private double alpha;
	private String add;
	private int minutes;
	private double storage;
	private double IBU;

	// Hops should know about hop types
	static final private String[] forms = {"Leaf", "Pellet", "Plug"};
	static final private String[] addTypes = {"Boil", "FWH", "Dry", "Mash"};
	
	// Constructors:
	
	public Hop(){
		// default constructor		
		setType("Leaf");
		setAdd("Boil");
		setUnits("oz");
	}
	
	public Hop(String u, String t){
		setUnits(u);
		setType(t);
		setAdd("Boil");
	}
	
	static public String[] getHopTypes() {
		return forms;
	}
	static public String[] getAddTypes() {
		return addTypes;
	}
	
	// get methods:
	public String getAdd(){ return add; }
	public double getAlpha(){ return alpha; }
	public double getIBU(){ return IBU; }
	public int getMinutes(){ return minutes; }
	public double getStorage(){ return storage; }

	
	// Setter methods:
	public void setAdd(String a){ add = a; }
	public void setAlpha(double a){ alpha = a; }
	// public void setForm(String f){ form = f; }
	public void setIBU(double i){ IBU = i; }
	public void setMinutes(int m){ minutes = m; }
	public void setStorage(double s){ storage = s; }	


	
	public String toXML(){
	    StringBuffer sb = new StringBuffer();
	    sb.append( "    <ITEM>\n" );
	    sb.append( "      <HOP>"+getName()+"</HOP>\n" );
	    sb.append( "      <AMOUNT>"+getAmountAs(getUnits())+"</AMOUNT>\n" );
	    sb.append( "      <TIME>"+getMinutes()+"</TIME>\n" );
	    sb.append( "      <UNITS>"+getUnitsAbrv()+"</UNITS>\n" );
	    sb.append( "      <FORM>"+getType()+"</FORM>\n" );
	    sb.append( "      <ALPHA>"+alpha+"</ALPHA>\n" );
	    sb.append( "      <COSTOZ>"+getCostPerU()+"</COSTOZ>\n" );
	    sb.append( "      <ADD>"+add+"</ADD>\n" );
	    sb.append( "      <DESCRIPTION>"+SBStringUtils.subEntities(getDescription())+"</DESCRIPTION>\n" );
	    sb.append( "      <DATE>"+getDate()+"</DATE>\n" );
	    sb.append( "    </ITEM>\n" );
	    return sb.toString();
	}
}
