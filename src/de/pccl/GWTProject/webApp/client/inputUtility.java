package de.pccl.GWTProject.webApp.client;
import java.io.BufferedReader;
import java.io.File;	
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;


import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import edu.stanford.nlp.util.CoreMap;
import edu.stanford.nlp.ling.CoreAnnotations.LemmaAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class inputUtility {
	
	protected StanfordCoreNLP pipeline;
	
	final String inputFile = "input/de-en/europarl-v7.de-en.de";
	final String outputFile = "output/europarl-out-de.txt";
	final MaxentTagger tagger;
	final Properties prop = new Properties();
	private ArrayList<String> usedPOSTags = new ArrayList<>();
	private LinkedList<String> sentences;
	final int amountOfSentenes = 10000;
	private workingSentence sent = new workingSentence();
	private int testSize = 10;


	public inputUtility() {
		super();
		prop.setProperty("annotators", "tokenize, ssplit, pos, lemma, parse, sentiment");
		tagger= new MaxentTagger("stanford-postagger-full-2016-10-31/models/german-fast.tagger",prop,false);
		usedPOSTags.add("PIS");
		load();
	}
	
	public inputUtility(ArrayList<String>posTags, int aTestSize){
		prop.setProperty("annotators", "tokenize, ssplit, pos, lemma, parse, sentiment");
		tagger= new MaxentTagger("stanford-postagger-full-2016-10-31/models/german-fast.tagger",prop,false);
		usedPOSTags = posTags;
		testSize = aTestSize;
		load();
	}
	
	public void load(){
		sentences = new LinkedList<String>();
		if (!(new File(outputFile).exists()))
			try {
				new File(outputFile).createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		try (BufferedReader br = Files.newBufferedReader(Paths.get(inputFile), StandardCharsets.UTF_8)) {
		    for (String line = null; (line = br.readLine()) != null;) {
		    	if (sentences.size()>=amountOfSentenes)
		    		break;
		    	if (line.split("\\s+").length<=30)
		    		sentences.add(line);
		    	}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public workingSentence getSentence() throws IOException{
		Collections.shuffle(usedPOSTags);
			sent = new workingSentence();
			int randomNumber = (int) (Math.random()*(amountOfSentenes*0.9));
			for (int i=randomNumber;i<amountOfSentenes;i++){
				String line = sentences.get(i);
				String taggedSent = createStanfordPOS(line);
				HashMap<String,String> mappedSent = createTaggedSentence(taggedSent);
				if (useableSent(mappedSent)){
		    		sent.setSentence(line);
		    		sent.setTaggedSentence(mappedSent);
		    		for (String s : mappedSent.keySet()){
		    			if (mappedSent.get(s).equals(sent.getPosTag())){
		    				sent.setTargetWord(s);
		    				//System.out.println(getLemma(s,sent.getPosTag()));
		    				return sent;
		    			}
		    		}
		    	}
			}
			return new workingSentence();
		}
	
	public HashMap<String,String> createTaggedSentence(String posInput){
		HashMap<String,String> taggedWords = new HashMap<>();
		for (String posWord : posInput.split("\\s+")){
			if (posWord.length()<1)
				continue;
				taggedWords.put(posWord.split("_")[0], posWord.split("_")[1]);
		}
		return taggedWords;
	}
	
	public String createStanfordPOS(String inp){
		String taggedString = tagger.tagString(inp);
		return taggedString;
	}	
	
	public boolean useableSent(HashMap<String,String> tagSentence){
		for (String s : usedPOSTags){
			if (tagSentence.containsValue(s)){
				sent.setPosTag(s);
				return true;
			}
				
		}
		return false;
	}
	
	public void setPOSTags(ArrayList<String> tags){
		usedPOSTags = tags;
	}
	
	public LinkedList<workingSentence> generateSentences(){
		LinkedList<workingSentence> output = new LinkedList<>();
		for (int i=1;i<=testSize;i++){
			try {
				output.add(getSentence());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return output;
	}

	public String getLemma(String s, String posTag) throws FileNotFoundException{
		String senten = sent.getSentence();
		List<String> lemmas = new LinkedList<String>();
		Annotation sentens = new Annotation(senten);
        this.pipeline = new StanfordCoreNLP(prop);
        Annotation document = new Annotation(senten);
        pipeline.annotate(document);
        
        List<CoreMap> sentence = document.get(SentencesAnnotation.class);
        for (CoreLabel t : sentence.get(0).get(TokensAnnotation.class)){
        	System.out.println(t.get(LemmaAnnotation.class));
        }
		return s;
	}
	
}
