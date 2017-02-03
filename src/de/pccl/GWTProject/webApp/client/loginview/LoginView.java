
package de.pccl.GWTProject.webApp.client.loginview;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;

/**
 * This class represents the login view of the application and includes all elements that are displayed in the
 * login view, which is used to log into the application.
 */
public class LoginView extends Composite {
	
	/**Main panel of the login view*/
    private VerticalPanel mainpanel = new VerticalPanel();
	
	/**The header object*/
	private LoginHeader loginheader = new LoginHeader();
	
	/**The footer object*/
	private LoginFooter loginfooter = new LoginFooter();

	/**Decorator panel for the login form*/
    private DecoratorPanel decPanel = new DecoratorPanel();
    
    /**Grid for login form elements*/
    private FlexTable loginLayout = new FlexTable();
    
    /**Labeling box and rb*/
    private Label labelRb = new Label("Choose the POS: ");
    private Label labelTb = new Label("Choose the number of tests: ");
    
    /**TextBox to enter number of tests*/
    private static TextBox tests = new TextBox();
    
    private RadioButton rb1 = new RadioButton("posRadio", "Random");
    private RadioButton rb2 = new RadioButton("posRadio", "PIS");

    private Button goButton = new Button("Start");    
    
    public LoginView (){
    	
    	int windowHeight = Window.getClientHeight();
		int windowWidth = Window.getClientWidth();
    	
        loginLayout.setCellSpacing(6);
        FlexCellFormatter cellFormatter = loginLayout.getFlexCellFormatter();
      
        //Add the loginbutton to the form
        loginLayout.setWidget(0, 40, goButton);
        cellFormatter.setColSpan(0, 0, 2);
        cellFormatter.setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);
        
        //Add test TextBox
        loginLayout.setWidget(2, 30, labelTb);
        loginLayout.setWidget(2, 40, tests);
        cellFormatter.setColSpan(0, 0, 2);
        cellFormatter.setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);
        //Add options
        loginLayout.setWidget(3, 30, labelRb);
        loginLayout.setWidget(3, 37, rb1);
        loginLayout.setWidget(3, 38, rb2);
        //loginLayout.setWidget(3, 39, rb3);

        // Wrap the content in a DecoratorPanel
        decPanel.setWidget(loginLayout);
        
        mainpanel.setWidth(windowWidth/2 + "px");
		mainpanel.setHeight(windowHeight*0.6 + "px");      
        mainpanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        mainpanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        mainpanel.add(decPanel);
    }

    public String getTestNumber() {
    	final String testNumber = tests.getText();
    	return testNumber;
    }

	/**Returns the login button
	 * 
	 * @return The login button
	 * */
	public Button getGoButton() {
		return goButton;
	}

	/**Returns the header of the login view
     * 
     * @return The header of the login view
     * */
	public LoginHeader getLoginheader() {
		return loginheader;
	}

	/**Returns the footer of the login view
     * 
     * @return The footer of the login view
     * */
	public LoginFooter getLoginfooter() {
		return loginfooter;
	}

    /**Returns the main panel of the login view
     * 
     * @return The main panel of the login view
     * */
	public VerticalPanel getMainPanel() {
		return mainpanel;
	}
}
