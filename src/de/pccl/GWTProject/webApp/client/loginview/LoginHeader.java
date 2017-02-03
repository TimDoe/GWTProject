
package de.pccl.GWTProject.webApp.client.loginview;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

/**
 * This class contains the header of the login view.
 */
public class LoginHeader  extends Composite{
	
	/**The main panel of the header*/
	private FlowPanel hPanel = new FlowPanel();
	
	public LoginHeader (){		
	}
	
	/**Returns the main panel of the header
	 * 
	 * @return The main panel of the header
	 * */
	public FlowPanel gethPanel() {
		return hPanel;
	}
}
