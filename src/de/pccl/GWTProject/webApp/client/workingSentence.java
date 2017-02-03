package de.pccl.GWTProject.webApp.client;
import java.util.HashMap;

public class workingSentence {

	private String sentence;
	private String posTag;
	private String targetWord;
	private HashMap<String,String> taggedSentence;
	
	
	public workingSentence(String sentence, String posTag, String targetWord, HashMap<String, String> taggedSentence) {
		super();
		this.sentence = sentence;
		this.posTag = posTag;
		this.targetWord = targetWord;
		this.taggedSentence = taggedSentence;
	}


	public workingSentence() {
		super();
	}


	public String getSentence() {
		return sentence;
	}


	public void setSentence(String sentence) {
		this.sentence = sentence;
	}


	public String getPosTag() {
		return posTag;
	}


	public void setPosTag(String posTag) {
		this.posTag = posTag;
	}


	public String getTargetWord() {
		return targetWord;
	}


	public void setTargetWord(String targetWord) {
		this.targetWord = targetWord;
	}


	public HashMap<String, String> getTaggedSentence() {
		return taggedSentence;
	}


	public void setTaggedSentence(HashMap<String, String> taggedSentence) {
		this.taggedSentence = taggedSentence;
	}


	@Override
	public String toString() {
		return sentence;
	}
	
	
	
	
}
