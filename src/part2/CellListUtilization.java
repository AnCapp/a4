package part2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CellListUtilization {

	public static void main(String[] args) throws FileNotFoundException {
		
		CellList cl1 = new CellList();
		CellList cl2 = new CellList();
				
		FileInputStream fis = new FileInputStream("Cell_Info.txt");
		Scanner sc = new Scanner(fis);
		Scanner kb = new Scanner(System.in);
		while (sc.hasNext()) {
			long sn = sc.nextLong();
			String b = sc.next(); double p = sc.nextDouble(); int y = sc.nextInt();	
			while (cl1.contains(sn)) {
				System.out.print("Serial Number already in use, enter new: ");
				sn = kb.nextLong();
			}
			CellPhone cp = new CellPhone(sn, b, y, p);
			cl1.addToStart(cp);
		}
		
		cl1.showContents();
		
	}
	
}
