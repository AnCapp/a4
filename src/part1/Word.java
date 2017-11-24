package part1;

public class Word {
	private String wordString;
	private int Freq;
	private int Rank;
	private boolean StW;
	
	public Word() {
		wordString=null;
		Freq=0;
		Rank=0;
		StW=false;
	}
	
	public Word(String word, int freq) {
		this.wordString=word;
		this.Freq=freq;
		this.Rank=0;
		StW=false;
	}
	public Word(Word w) {
		this.wordString=w.wordString;
		this.Freq=w.getFreq();
		this.Rank=w.getRank();
		this.StW=w.isStW();
	}

	public Word clone() {
		return new Word(this);	
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
		if(Freq>=10&&wordString.length()<=4)
			StW=true;
		else 
			StW=false;
	}
	
	public void setRank(int rank) {
		Rank = rank;
	}
	
	public int getRank() {
		return Rank;
	}

	public boolean isStW() {
		return StW; 
	}

	  
	public String toString() {
		return "\n   "+Rank+"          "+Freq+"            "+wordString;
	}
}
