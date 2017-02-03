package de.pccl.GWTProject.webApp.client;

import de.pccl.GWTProject.webApp.client.loginview.LoginView;
import de.pccl.GWTProject.webApp.client.resultview.ResultView;
import de.pccl.GWTProject.webApp.client.testview.TestView;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GWTProject implements EntryPoint {
	
	/* Main Elements of the Website which represent the divs in the HTML-Page*/
	private FlowPanel header  = new FlowPanel();
	private FlowPanel content = new FlowPanel();
	private FlowPanel footer = new FlowPanel();
	
	/*Element of the Login view*/
	private LoginView loginView = new LoginView();
	
	/*Element of the database view*/
	private TestView ResultView = new TestView();
	
	/*Element of the main view*/
	private ResultView mainView = new ResultView();

	/**
	 * This is the entry point method.
	 */	
	public void onModuleLoad() {
		
		/* Adding an Eventhandler to the Login-Button */
		this.loginView.getGoButton().addClickHandler(new ClickHandler() {
	          public void onClick(ClickEvent event) {

	        	  setContent(1);
	            }
	          });
		
		/* Adding an Eventhandler to the Open Database Button*/
		this.ResultView.getResultButton().addClickHandler(new ClickHandler() {
	          public void onClick(ClickEvent event) {

	        	  setContent(2);
	            }
	          });
		
		/*Adds an event handler on the result button to close the result page*/
		this.mainView.getMainheader().getResultButton().addClickHandler(new ClickHandler() {
	          public void onClick(ClickEvent event) {
	        	  
	        	  setContent(1);               
	          }
		 });
	    
		/*Adds an event handler on the logout button of the resultview to log out of the application*/	    
	    this.mainView.getMainheader().getLogoutButton().addClickHandler(new ClickHandler() {
	          public void onClick(ClickEvent event) {
	        	  
	        	  setContent(0);        	  
	          }
		 });
		
		this.setContent(0);		
	}

	/**Method to set 3 different contents to the HTML-Page, depending on the userstatus
	 * 
	 * @param status Integer value with the status number, 0 for loginview, 1 for testview and 2 for resultview
	 * */
	public void setContent(int status){
		switch(status){
        case 0:
            System.out.println("User is not logged in");
            header.clear();
			header.add(loginView.getLoginheader().gethPanel());
			
			content.clear();
			content.add(loginView.getMainPanel());
			
			footer.clear();
			footer.add(loginView.getLoginfooter().getHpanel());
			
			/* Associate the panels with the HTML host page.*/
			RootPanel.get("content").add(content);

			RootPanel.get("header").add(header);

			RootPanel.get("footer").add(footer);
            
            break;
        case 1:
            System.out.println("");

            header.clear();
			
			content.clear();
			content.add(ResultView.gethPanel());
			
			footer.clear();

		/* Associate the panels with the HTML host page.*/
		RootPanel.get("content").add(content);

		RootPanel.get("header").add(header);

		RootPanel.get("footer").add(footer);
		
         break;
        case 2:
            System.out.println("");
            header.clear();
			header.add(mainView.getMainheader().gethPanel());
			
			content.clear();
			content.add(mainView.getMainPanel());
			
			footer.clear();

		/* Associate the panels with the HTML host page.*/
		RootPanel.get("content").add(content);

		RootPanel.get("header").add(header);

            break;
        default:
            System.out.println("switch-case-defaulttext");
        } 		
	}
}