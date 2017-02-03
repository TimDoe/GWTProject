
package de.pccl.GWTProject.webApp.client.loginview;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;

/**
 * This class contains the footer of the login view.
 */
public class LoginFooter  extends Composite{
	 
	/**The main panel of the footer*/
	private HorizontalPanel hpanel = new HorizontalPanel();
	
	public LoginFooter (){
	}
	
	/**Returns the main panel of the footer
	 * 
	 * @return The main panel of the footer
	 * */
	public HorizontalPanel getHpanel() {
		return hpanel;
	}
}
