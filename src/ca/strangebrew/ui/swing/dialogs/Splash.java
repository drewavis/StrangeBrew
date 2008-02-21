/*
 * @(#)Splash.java  2.0  January 31, 2004
 *
 * Copyright (c) 2003-2004 Werner Randelshofer
 * Staldenmattweg 2, Immensee, CH-6405, Switzerland.
 * All rights reserved.
 *
 * This software is in the public domain.
 */

/**
 *
 * @author  werni
 */
package ca.strangebrew.ui.swing.dialogs;


public class Splash {
    /**
     * Shows the splash screen, launches the application and then disposes
     * the splash screen.
     * @param args the command line arguments
     */
	
	
	
    public static void main(String[] args) {
    	// check if this is a mac/osx machine, and deal accordingly
    	String lcOSName = System.getProperty("os.name").toLowerCase();
    	
    	if (lcOSName.startsWith("mac os x")) {
    		System.setProperty("apple.laf.useScreenMenuBar","true");
    		System.setProperty("com.apple.mrj.application.apple.menu.about.name","StrangeBrew");
    	}
    	
        SplashWindow.splash(Splash.class.getResource("splash.gif"));
        SplashWindow.invokeMain("StrangeSwing", args);
        SplashWindow.disposeSplash();
    }
    
}
