package part1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

//-----------------------------------------------------
//Assignment #4
//Part: 1
//Written by: Anthony Cappello 40044215 Pim 40070487
//---------------------------------------------------
public class ZDriver {
	
	private static ArrayList<Word> WdArr = new ArrayList<Word>();
	
	
	
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
			String tmp=br.next().toLowerCase();
			//System.out.println(tmp);
			
			if (tmp.matches(".*[\\p{P}\\p{S}]*.")) {
				tmp=tmp.replaceAll("[\\p{P}\\p{S}]", "");
			}
			if (tmp.matches(".*[0-9]*.")) {
				tmp=tmp.replaceAll("[0-9]", "");	
			}
			if (tmp.matches(".*[a-zA-Z].*")  ) {
				//System.out.println(tmp);
				//System.out.println("1");
				count++;
			}
			
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
			String tmp=br.next().toLowerCase();
			tmp=tmp.replaceAll("[^a-zA-Z]", "");
			WArr.add(new Word());
			WArr.get(count).setWordString(tmp);
			WArr.get(count).setFreq(1);
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
		System.out.println(WArr);

	}

}
