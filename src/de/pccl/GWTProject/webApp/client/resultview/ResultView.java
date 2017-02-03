
package de.pccl.GWTProject.webApp.client.resultview;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * This class represents the result view of the application and includes all
 * elements that are displayed in the result view.
 */
public class ResultView extends Composite {
	
	private Label resultCorrect = new Label();
	private Label resultIncorrect = new Label();
	private Label resultOverall = new Label();

	/**The main panel of the result view*/
	private VerticalPanel mainPanel = new VerticalPanel();

	private Header header = new Header();

	public ResultView() {
		
		mainPanel.add(resultCorrect);
		mainPanel.add(resultIncorrect);
		mainPanel.add(resultOverall);
		
		resultCorrect.setText("Correct: " + 1);
		resultIncorrect.setText("Incorrect: " + 1);
		resultOverall.setText("Overall: " + 2);
	}

	
	/**Returns the main panel of the result view
	 * 
	 * @return The main panel of the result view
	 * */
	public VerticalPanel getMainPanel() {
		return mainPanel;
	}
	
	/**Returns the header of the result view
	 * 
	 * @return The header of the result view
	 * */
	public Header getMainheader() {
		return header;
	}

}
