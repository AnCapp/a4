package part1;

public class Word {
	private String wordString;
	private int Freq;
	private boolean StW;
	
	public Word() {
		wordString=null;
		Freq=0;
		StW=false;
	}
	
	public Word(String word, int freq) {
		this.wordString=word;
		this.Freq=freq;
		if(Freq>=10&&wordString.length()<=4)
			StW=true;
		else 
			StW=false;
	}

	public String getWordString() {
		return wordString;
	}

	public void setWordString(String wordString) {
		this.wordString = wordString;
	}

	public int getFreq() {
		return Freq;
	}

	public void setFreq(int freq) {
		Freq = freq;
	}

	public boolean isStW() {
		return StW;
	}

	/*public void setStW(Word b) {
		if (Freq>=10 && wordString.length()<=4) {
			b.StW=true;
		}
		else
			b.StW=false;
	}*/
	  
	public String toString() {
		return "\nWordstring: "+wordString+"\nFrequency: "+Freq+"\n---------------";
	}
}
