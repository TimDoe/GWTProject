
package de.pccl.GWTProject.webApp.client.resultview;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;

/**
*  This class represents the header of the result view.
**/
public class Header extends Composite{
	
	/**The main panel of the header*/
	private HorizontalPanel hPanel = new HorizontalPanel();
	
	/**The panel for buttons*/
	private HorizontalPanel buttonPanel = new HorizontalPanel();
	
	/**The restart button*/
	private Button restartButton = new Button("Again");
	
	/**The home button*/
	private Button homeButton = new Button("Home");
	
	
	public Header(){
		
		//configure buttons
		restartButton.getElement().setClassName("resultbutton");
		restartButton.getElement().getStyle().setBackgroundColor("white");
		restartButton.setWidth("80px");
		restartButton.setTitle("Close results");
		homeButton.getElement().setClassName("logoutbutton");
		homeButton.setWidth("80px");
		homeButton.setTitle("Logout");
		
		buttonPanel.setWidth("200px");
		buttonPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		buttonPanel.getElement().getStyle().setMarginLeft(500, Unit.PX);
		buttonPanel.add(restartButton);
		buttonPanel.add(homeButton);
		hPanel.add(buttonPanel);

		hPanel.getElement().setClassName("mainheader");	
		hPanel.setWidth("600px");
		hPanel.setHeight("50px");
	}

	/**Returns the main panel of the header
	 * 
	 * @return The main panel of the header
	 * */
	public HorizontalPanel gethPanel() {
		return hPanel;
	}
	
	/**Returns the result button
	 * 
	 * @return The result button
	 * */
	public Button getResultButton() {
		return restartButton;
	}

	/**Returns the home button
	 * 
	 * @return The home button
	 * */
	public Button getLogoutButton() {
		return homeButton;
	}
}
