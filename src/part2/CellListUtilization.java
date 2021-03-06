package part2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CellListUtilization {

	public static void main(String[] args) throws FileNotFoundException {
		
		CellList cellList1 = new CellList();
		CellList cellList2 = new CellList();
				
		FileInputStream fis = new FileInputStream("Cell_Info.txt");
		Scanner sc = new Scanner(fis);
		
		while (sc.hasNext()) {
			long sn = sc.nextLong(); String b = sc.next(); double p = sc.nextDouble(); int y = sc.nextInt();
			CellPhone cp = new CellPhone(sn, b, y, p);
			if (cellList1.contains(sn)) {
				System.out.println("Serial Number (" + sn + ") of " + b 
						+ " is already in use.\nWill be stored in cellList1 instead of cellList2");
				cellList2.addToStart(cp);
			}else {
				cellList1.addToStart(cp);
			}
		}
		System.out.println("\ncellList1: containing unique CellPhones");
		cellList1.showContents();
		System.out.println("\ncellList2: containing the duplicates");
		cellList2.showContents();
		
		System.out.println("\nInsert a new one in cellList2 at 2 (i = 1):");
		CellPhone cp = new CellPhone(1001913, "Eindhoven", 1913, 1913);
		System.out.println("New Entry: " + cp.toString());
		cellList2.insertAtIndex(cp, 1);
		cellList2.showContents();
		
		System.out.println("\nReplace duplicate 3 (i = 2) with new one:");
		cp = new CellPhone(1913100, "PSV", 1913, 1913);
		System.out.println("New Entry: " + cp.toString());
		cellList2.replaceAtIndex(cp, 2);
		cellList2.showContents();
		
		System.out.println("\nDelete duplicate 4 (i = 3):");
		cellList2.deleteAtIndex(3);
		cellList2.showContents();
		
		System.out.println("\nDelete from start:");
		cellList2.deleteFromStart();
		cellList2.showContents();
		
		// TO DO: DUPLICATION		
		System.out.println("\nDuplicate cellList1:");
		CellList cellList3 = cellList1.clone();
		cellList3.showContents();
		
		System.out.println("\nCheck if it is equal to cellList1:");
		System.out.println(cellList3.equals(cellList1));
		
		System.out.println("\nFind a CellPhone in cellList3 with Serial Number 8888902:");
		CellPhone found = cellList3.find(8888902);
		
		System.out.println("\nThe found CellPhone:");		
		System.out.println(found.toString());
		
		System.out.println("\nChange its Serial Number to 1111111 (found.setSerialNum(1111111)):");
		found.setSerialNum(1111111);
		
		System.out.println("\nSince Serial Number does not matter, cellList1 and 3 should still be the same:");
		System.out.println(cellList3.equals(cellList1));
		
		System.out.println("\nNow delete in cellList3 at index 10:");
		cellList3.deleteAtIndex(10);
		
		System.out.println("\nNew cellList3:");
		cellList3.showContents();
		
		System.out.println("\nCheck if cellList 3 is still equal to cellList1:");
		System.out.println(cellList3.equals(cellList1));
	}
	
}
