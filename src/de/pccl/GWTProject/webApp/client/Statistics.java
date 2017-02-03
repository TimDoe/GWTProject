package de.pccl.GWTProject.webApp.client;

import java.io.IOException;
import java.lang.Object;
import java.util.ArrayList;
import java.util.List;

//import org.apache.commons.lang.time.StopWatch;
public class Statistics {
	static List<String> correct = new ArrayList<String>(); //
	static List<String> incorrect = new ArrayList<String>();
	public static int correctNum = 0;
	public static int incorrectNum = 0;
	public static int totalNum = 0;
	public boolean equals()
	{
		
		String correctWord = workingSentence.getTargetWord();//correct word from the sentence
				String inputWord = GWTProject.submitInput();//Word from user input	
				if (correctWord.equals(inputWord))
					correct.add(correctWord);
					return true;
		if (!correctWord.equals(inputWord)) {
			incorrect.add(correctWord);
			return false;
		}
		return false;
	}

	
	public static int correctResults()
	{
		correctNum = correct.size();
		return correctNum;
		
	}
	public static int incorrectResults()
	{
		
		incorrectNum = incorrect.size();
		return incorrectNum;
		
	}
	public static int totalResults()
	{
		totalNum = correctNum + incorrectNum;
		return correctNum;
		
	}

}


