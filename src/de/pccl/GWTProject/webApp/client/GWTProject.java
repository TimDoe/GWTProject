package de.pccl.GWTProject.webApp.client;

import de.pccl.GWTProject.webApp.shared.FieldVerifier;

import java.util.ArrayList;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GWTProject implements EntryPoint {
	
	  private VerticalPanel mainPanel = new VerticalPanel();
	  private HorizontalPanel submitPanel = new HorizontalPanel();
	  private Label sentenceLabel1 = new Label();
	  private Label sentenceLabel2 = new Label();
	  private TextBox inputTextBox = new TextBox();
	  private Button submitInputButton = new Button("Submit");
	  private TextArea textField = new TextArea();
	  private inputUtility in = new inputUtility();
	  

	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	@SuppressWarnings("unused")
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	@SuppressWarnings("unused")
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	/**
	 * This is the entry point method.
	 */

	public void onModuleLoad() {
		in = new inputUtility();
		mainPanel.add(submitPanel);
		
		inputTextBox.addStyleName(".textBox");
		sentenceLabel1.addStyleName(".textDisplay1");
		sentenceLabel2.addStyleName(".textDisplay2");
		RootPanel.get("textBoxContainer").add(inputTextBox);

		//connect main panel to HTML
		RootPanel.get("textDisplayContainer1").add(sentenceLabel1);
		RootPanel.get("textDisplayContainer2").add(sentenceLabel2);
	    //cursor focus on text field
		inputTextBox.setFocus(true);
		//set Strings to be displayed in labels
		sentenceLabel1.setText("This here");
		sentenceLabel2.setText("a sentence.");

	    //submission by pressing enter
		//test comment
	    inputTextBox.addKeyDownHandler(new KeyDownHandler() {
	        public void onKeyDown(KeyDownEvent event) {
	          if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
	            submitInput();
	         }
	        }
	      });
	}

	
	private void submitInput() {
	      final String inputWord = inputTextBox.getText().toLowerCase().trim();
	      inputTextBox.setFocus(true);

	      //TODO Word must match solution
	      if (!inputWord.matches("word")) {
	        Window.alert("'" + inputWord + "' is not a valid answer.");
	        inputTextBox.selectAll();
	        return;
	      }
	      //clears text box
	      inputTextBox.setText("");
	}
}