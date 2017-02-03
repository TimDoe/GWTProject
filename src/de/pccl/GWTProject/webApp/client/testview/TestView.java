
package de.pccl.GWTProject.webApp.client.testview;

import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class TestView extends Composite{
	
	private static TextBox inputTextBox = new TextBox();
	private Label sentenceLabel1 = new Label();
	private Label sentenceLabel2 = new Label();
	private Button resultButton = new Button("Show results");
	/**Main panel of the test view*/
    private VerticalPanel mainPanel = new VerticalPanel();
	
	public TestView(){
		
		mainPanel.setHorizontalAlignment(HasAlignment.ALIGN_CENTER);
		mainPanel.add(sentenceLabel1);
		mainPanel.add(inputTextBox);
		mainPanel.add(sentenceLabel2);
		mainPanel.add(resultButton);
		inputTextBox.addStyleName(".textBox");
		sentenceLabel1.addStyleName(".textDisplay1");
		sentenceLabel2.addStyleName(".textDisplay2");
		sentenceLabel1.setText("This here");
		sentenceLabel2.setText("a very very very very very very long sentence.");
		inputTextBox.setFocus(true);

	    //submit by pressing enter
	    inputTextBox.addKeyDownHandler(new KeyDownHandler() {
	        public void onKeyDown(KeyDownEvent event) {
	          if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
	            submitInput();
	         }
	        }
	      });
	}

	public String submitInput() {
	      final String inputWord = inputTextBox.getText().toLowerCase().trim();
	      inputTextBox.setFocus(true);
	      //clears text box
	      inputTextBox.setText("");
		return inputWord;}

	/**Returns the main panel of the test view
	 * 
	 * @return The main panel of the test view
	 * */
	public VerticalPanel gethPanel() {
		return mainPanel;
	}
	
	public Button getResultButton() {
		return resultButton;
	}
}
