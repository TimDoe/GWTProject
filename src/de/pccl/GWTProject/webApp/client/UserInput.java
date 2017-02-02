package de.pccl.GWTProject.webApp.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class UserInput extends Composite {

	private static UserInputUiBinder uiBinder = GWT.create(UserInputUiBinder.class);

	interface UserInputUiBinder extends UiBinder<Widget, UserInput> {
	}
	
	@UiField TextBox input;
	@UiField Label inputFeedback;
}
