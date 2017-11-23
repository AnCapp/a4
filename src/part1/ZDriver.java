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
	
	
	
	public static String countWords(String inputFile) throws IOException {
		FileInputStream input = null;
		try {
			input = new FileInputStream(inputFile);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		InputStreamReader inp = new InputStreamReader(input);
		Scanner br = new Scanner(inp);
		int count = 0;
		while (br.hasNext()) { 
			Pattern pattern = Pattern.compile("[a-zA-Z]*");
			String tmp=br.next().toLowerCase();
			Matcher matcher = pattern.matcher(tmp);
			
		    if (!matcher.matches()) {
		           System.out.println("string '"+tmp + "' contains special character");
		    } else {
		           count++;
		    }
			
			/*String tmp=br.next().toLowerCase();
			//System.out.println(tmp);
			
			if (tmp.find("[()-’.,!?]")) {
				System.out.println("1"+tmp);
				tmp=tmp.replaceAll("[\\p{P}\\p{S}]", "");
			}
			if (tmp.matches(".*[0-9]")) {
				System.out.println("2"+tmp);
				tmp=tmp.replaceAll("[0-9]", "");	
			}
			if (tmp.matches(".*[a-zA-Z]")  ) {
				System.out.println("3"+tmp);
				//System.out.println("1");
				count++;
			}*/
			
		}
		br.close();
		return "Number of word tokens: "+count;
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
		//ArrayList<String> SArr=new ArrayList<>();
		while(br.hasNext()) {
			Pattern pattern = Pattern.compile("[a-zA-Z]*");
			String tmp=br.next().toLowerCase();
			Matcher matcher = pattern.matcher(tmp);
			if (!matcher.matches()) {
				continue;
			}
			//tmp=tmp.replaceAll("[^a-zA-Z]", "");
			else {
				tmp.toLowerCase();
				WArr.add(new Word());
				WArr.get(count).setWordString(tmp);
				WArr.get(count).setFreq(1);
				WArr.get(count).setRank(count+1);
				
			}
			count++;
		}
		//int freq=0;
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
		
		
	}//Rank not setting properly
	public static void Sort(ArrayList<Word> WArr) {
		Word tmp=new Word();
		for(int i=0;i<WArr.size();i++) {
			for(int j=0;j<WArr.size();j++) {
				if (WArr.get(i).getFreq()>(WArr.get(j).getFreq())) {
					tmp=WArr.get(i).clone();
					WArr.get(i).setFreq(WArr.get(j).getFreq());
					WArr.get(i).setRank(WArr.get(j).getRank());
					WArr.get(i).setWordString(WArr.get(j).getWordString());
					WArr.get(j).setFreq(tmp.getFreq());
					WArr.get(j).setRank(tmp.getRank());
					WArr.get(j).setWordString(tmp.getWordString());
					tmp=null;
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println(countWords("jokes.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
		ArrayList<Word> WArr=new ArrayList<>();
		MovetoArray("jokes.txt",WArr);
		System.out.println("-------------------------------------");
		System.out.printf("%5s%15s%10s","Rank","Frequency ","Word" );
		System.out.println("\n-------------------------------------");
		Sort(WArr);
		for(int i=0;i<WArr.size();i++) {
			System.out.println(WArr.get(i));
		}
	}

}
