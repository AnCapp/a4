package part1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//-----------------------------------------------------
//Assignment #4
//Part: 1
//Written by: Anthony Cappello 40044215 Pim 40070487
//---------------------------------------------------
public class ZDriver {
	
//	private static ArrayList<Word> WdArr = new ArrayList<Word>();
	
	
	
	public static int countWords(String inputFile) throws IOException {
		FileInputStream input = null;
		try {
			input = new FileInputStream(inputFile);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		InputStreamReader inp = new InputStreamReader(input);
		Scanner br = new Scanner(inp);
		int count = 0;
		Pattern pattern = Pattern.compile("[a-zA-Z]*");
		while (br.hasNext()) { 
			String tmp=br.next().toLowerCase();
			Matcher matcher = pattern.matcher(tmp);
		    if (!matcher.matches()) {
		       continue;
		       //System.out.println("string '"+tmp + "' contains special character");
		    } else {
		           count++;
		    }
			
		}
		br.close();
		return count;
	}
	
	public static void MovetoArray(String inputFile,ArrayList<Word> WArr) {
		FileInputStream input = null;
		try {
			input = new FileInputStream(inputFile);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		InputStreamReader inp = new InputStreamReader(input);
		Scanner br = new Scanner(inp);
		int count=0;
		while(br.hasNext()) {
			Pattern pattern = Pattern.compile("[a-zA-Z]*");
			String tmp=br.next().toLowerCase();
			Matcher matcher = pattern.matcher(tmp);
			if (!matcher.matches()) {
				continue;
			}
			else {
				tmp.toLowerCase();
				WArr.add(new Word());
				WArr.get(count).setWordString(tmp);
				WArr.get(count).setFreq(1);
				WArr.get(count).setRank(count+1);
				
			}
			count++;
		}
		for (int i=0;i<WArr.size();i++) {
			for (int j=0;j<WArr.size();j++) {
				if (i==j)
					continue;
				else if (WArr.get(i).getWordString().equals(WArr.get(j).getWordString())) {
					WArr.get(i).setFreq(WArr.get(i).getFreq()+1);
					WArr.remove(WArr.get(j));
				}
			}
		}
		
		
	}
	public static void Sort(ArrayList<Word> WArr) {
		Word tmp=new Word();
		for(int i=0;i<WArr.size();i++) {
			for(int j=0;j<WArr.size();j++) {
				if (WArr.get(i).getFreq()>(WArr.get(j).getFreq())) {
					tmp=WArr.get(i).clone();
					WArr.get(i).setFreq(WArr.get(j).getFreq());
					WArr.get(i).setWordString(WArr.get(j).getWordString());
					WArr.get(j).setFreq(tmp.getFreq());
					WArr.get(j).setWordString(tmp.getWordString());
					tmp=null;
				}
			}
		}
		for (int i=0;i<WArr.size();i++) {
			WArr.get(i).setRank(WArr.indexOf(WArr.get(i))+1);
		}
	}
	public static int numHappax(ArrayList<Word> WArr) {
		int count=0;
		for(int i=0;i<WArr.size();i++) {
			if(!WArr.get(i).isStW()) {
				count++;
			}
			else
				continue;
		}
		
		return count;
	}
	public static int numStopWords(ArrayList<Word> WArr) {
		int count=0;
		for(int i=0;i<WArr.size();i++) {
			if(WArr.get(i).isStW()) {
				count++;
			}
			else
				continue;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println("Enter the file to be scanned: ");
		Scanner kb=new Scanner(System.in);// TODO Auto-generated method stub
		String file=kb.nextLine();
		
		ArrayList<Word> WArr=new ArrayList<>();
		MovetoArray(file,WArr);
		System.out.println("-------------------------------------");
		System.out.printf("%5s%15s%10s","Rank","Frequency ","Word" );
		System.out.println("\n-------------------------------------");
		Sort(WArr);
		for(int i=0;i<WArr.size();i++) {
			System.out.println(WArr.get(i));
		}
		int numwords=0;
		try {
			numwords=countWords(file);
			System.out.println("Number of word tokens: "+countWords(file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
		double phappax=(double)numHappax(WArr)/(double)numwords;
		System.out.println("number of word types: "+WArr.size());
		System.out.printf("\nnum hap %d \nPercentage of Happax: %.2f%% \nHappax Account for: %.2f%% \n",numHappax(WArr),((double)numHappax(WArr)/(double)numwords)*100,((double)numHappax(WArr)/(double)WArr.size())*100);
		//System.out.printf("%.2d","\nnumber of Happax:"+numHappax(WArr)+
				//"\nPercentage of Happax:"+phappax+"%\nHappax Account for: "+numHappax(WArr)/WArr.size()+"%");
		System.out.printf("\nnum Stop Words: %d \nPercentage of Stop Words: %.2f%% \nStop Words Account for: %.2f%%",numStopWords(WArr),((double)numStopWords(WArr)/(double)numwords)*100,((double)numStopWords(WArr)/(double)WArr.size())*100);
	}

}
